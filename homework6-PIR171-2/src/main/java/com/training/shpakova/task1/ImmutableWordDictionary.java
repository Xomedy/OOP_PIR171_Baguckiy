package com.training.shpakova.task1;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ImmutableWordDictionary {
    private final Map<String, Integer> wordList;
    private Set<Character> characterListCopy;

    public ImmutableWordDictionary(Map<String, Integer> wordMap, Set<Character> characterList) {
        this.wordList = Collections.unmodifiableMap(wordMap);
        characterListCopy = characterList;
    }

    public void print() {
        wordList.forEach((word, count)-> output(word,count));
    }

    private void output(String word, Integer count) {
        char currentCharacter = word.toUpperCase().charAt(0);
        boolean needLetter = characterListCopy.contains(currentCharacter);
        System.out.print((needLetter ? currentCharacter + ":" : "  ")+ " ");
        characterListCopy.remove(word.toUpperCase().charAt(0));
        System.out.println(word + " " + count.toString());
    }

}
