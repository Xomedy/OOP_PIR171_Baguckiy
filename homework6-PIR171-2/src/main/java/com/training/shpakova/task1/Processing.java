package com.training.shpakova.task1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Processing {
    private String input;
    private ImmutableWordDictionary immutableWordDict;
    private Set<Character> characterList;
    private Map<String, Integer> wordMap;

    public Processing(String input) {
        this.input = input;
        formImmutableList();
    }

    public ImmutableWordDictionary getImmutableWordDict() {
        return immutableWordDict;
    }

    public Object[] getImmutableWordList() {
        return wordMap.keySet().toArray();
    }

    public Object[] getImmutableWordListCount() {
        return wordMap.values().toArray();
    }

    private void formImmutableList() {
        String[] wordArray = formWordArray();
        wordMap = new TreeMap<>();
        for (String word : wordArray) {
            wordMap.putIfAbsent(word, 0);
            wordMap.compute(word, (wordKey, count) -> ++ count);
        }
        characterList = new HashSet<>();
        wordMap.keySet().forEach(word -> setCharacterList(word));
        immutableWordDict = new ImmutableWordDictionary(wordMap, characterList);
    }

    private void setCharacterList(String word) {
        characterList.add(word.toUpperCase().charAt(0));
    }

    private String[] formWordArray() {
        input = input.replaceAll("[.,!?:;]", "");
        input = input.replaceAll(" - ", " ");
        input = input.toLowerCase();
        return input.split(" ");
    }

}
