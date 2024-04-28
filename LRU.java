package test;


import java.util.*;

public class LRU implements CacheReplacementPolicy{
    private final Set<String> words = new HashSet<>();

    private final LinkedList<String> linkedList =  new LinkedList<>();

    public LRU() {}

    @Override
    public void add(String word) {
        if(words.contains(word)) {
            linkedList.remove(word);
        }
        else {
            words.add(word);
        }
        linkedList.addLast(word);
    }

    @Override
    public String remove() {
        String removedWord = linkedList.removeFirst();
        words.remove(removedWord);
        return removedWord;
    }
}
