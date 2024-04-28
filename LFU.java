package test;


import java.util.HashMap;
import java.util.PriorityQueue;

public class LFU implements CacheReplacementPolicy{
    private final HashMap<String, Integer> wordsMap = new HashMap<>();
    private final PriorityQueue<String> pq = new PriorityQueue<>((word1, word2) ->  wordsMap.get(word1) - wordsMap.get(word2));

    public LFU() {}

    @Override
    public void add(String word) {
        // In case the received word is new
        if (!wordsMap.containsKey(word)){
            wordsMap.put(word, 1);
            pq.add(word);
            return;
        }

        // In case the word already exist
        wordsMap.put(word, wordsMap.get(word) + 1);
        pq.remove(word);
        pq.add(word);
    }

    @Override
    public String remove() {
        String removedWord = pq.poll();;
        wordsMap.remove(removedWord);
        return removedWord;
    }
}
