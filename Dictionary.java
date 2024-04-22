package test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {

    private String[] fileNames;
    private final CacheManager existingWordsCache;
    private final CacheManager nonExistingWordsCache;
    private final BloomFilter bloomFilter;

    public Dictionary(String ...fileNames) {
        this.existingWordsCache = new CacheManager(400, new LRU());
        this.nonExistingWordsCache = new CacheManager(100, new LFU());
        this.bloomFilter = new BloomFilter(256, "MD5", "SHA1");
        this.fileNames = fileNames;

        for (String fileName: fileNames) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("\\W+"); // Split the line into words
                    for (String word : words) {
                        this.bloomFilter.add(word);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean query(String word) {
        if(this.existingWordsCache.query(word)) return true;
        if(this.nonExistingWordsCache.query(word)) return false;

        boolean isWordExistUsingBloom = this.bloomFilter.contains(word);
        if(isWordExistUsingBloom) {
            this.existingWordsCache.add(word);
        }
        else {
            this.nonExistingWordsCache.add(word);
        }

        return isWordExistUsingBloom;
    }

    public boolean challenge(String word) {

        try {
            boolean isWordExistUsingIOSearcher = IOSearcher.search(word, this.fileNames);

            if(isWordExistUsingIOSearcher) {
                this.existingWordsCache.add(word);
            }
            else {
                this.nonExistingWordsCache.add(word);
            }

            return isWordExistUsingIOSearcher;

        } catch (IOException e) {
            return false;
        }
    }
}
