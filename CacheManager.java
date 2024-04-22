package test;


import java.util.HashSet;
import java.util.Set;

public class CacheManager {

    private final int maxSize;
    private final Set<String> cache;
    private final CacheReplacementPolicy crp;

    public CacheManager(int size, CacheReplacementPolicy crp) {
        this.maxSize = size;
        this.cache = new HashSet<>(size);
        this.crp = crp;
    }

    public boolean query (String word) {
        return cache.contains(word);
    }

    public void add (String word) {
        this.crp.add(word);
        this.cache.add(word);
        if(this.cache.size() > this.maxSize) {
            String removedWord = this.crp.remove();
            this.cache.remove(removedWord);
        }
    }
}
