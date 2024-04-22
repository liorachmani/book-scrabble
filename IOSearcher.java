package test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOSearcher {

    public static boolean search (String word, String ...fileNames) throws IOException {
        for(String fileName : fileNames) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("\\W+"); // Split the line into words
                    for (String wordInFile : words) {
                        if(wordInFile.equals(word)) return true;
                    }
                }
            }
        }

        return false;
    }
}
