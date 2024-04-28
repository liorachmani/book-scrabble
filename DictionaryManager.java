package test;
import java.util.HashMap;

public class DictionaryManager {
    private static DictionaryManager singleDictionaryManager = null;
    private final HashMap<String, Dictionary> dict = new HashMap<>();


    public boolean query(String ...fileNames) {
        boolean found = false;
        String word = fileNames[fileNames.length - 1];

        for (int i = 0; i < fileNames.length - 1; i++) {
            String fileName  = fileNames[i];

            if(!this.dict.containsKey(fileName)) {
                this.dict.put(fileName, new Dictionary(fileName));
            }

            if(this.dict.get(fileName).query(word)) {
                found = true;
            }
        }

        return found;
    }

    public boolean challenge(String ...fileNames) {
        boolean found = false;
        String word = fileNames[fileNames.length - 1];

        for (int i = 0; i < fileNames.length - 1; i++) {
            String fileName  = fileNames[i];

            if(!this.dict.containsKey(fileName)) {
                this.dict.put(fileName, new Dictionary(fileName));
            }

            if(this.dict.get(fileName).challenge(word)) {
                found = true;
            }
        }

        return found;
    }


    public int getSize() {
        return this.dict.size();
    }

    public static DictionaryManager get() {
        if(singleDictionaryManager == null) {
            singleDictionaryManager = new DictionaryManager();
        }

        return singleDictionaryManager;
    }
}
