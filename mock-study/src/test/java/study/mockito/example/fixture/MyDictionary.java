package study.mockito.example.fixture;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary {
    Map<String, String> wordMap = new HashMap<>();

    public MyDictionary() {
    }

    public MyDictionary(Map<String, String> wordMap) {
        this.wordMap = wordMap;
    }
    public void add(final String word, final String meaning) {
        wordMap.put(word, meaning);
    }
    public String getMeaning(final String word) {
        return wordMap.get(word);
    }
}
