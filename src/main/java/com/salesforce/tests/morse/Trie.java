package com.salesforce.tests.morse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Trie data structure
 * 
 * @author krishnanand (Kartik Krishnanand)
 */
public class Trie {

  private final TrieNode morseCodeTrie;


  private Map<Character, String> characterToMorseMap;

  public Trie() {
    this.morseCodeTrie = new TrieNode();
    this.characterToMorseMap = new LinkedHashMap<>();
  }

  public void addPattern(String letter, String code) {
    this.characterToMorseMap.put(letter.charAt(0), code);
  }

  public void initialisePatterns(String input) {
    String[] wordToMorseCodeMapping = input.split(" ");
    String character = wordToMorseCodeMapping[0].trim();
    String morseCode = wordToMorseCodeMapping[wordToMorseCodeMapping.length - 1].trim();
    this.addPattern(character, morseCode);
  }

  public void initialiseMorseCode(String word) {
    if (word == null || word.isEmpty()) {
      return;
    }
    char[] charArray = word.toCharArray();
    TrieNode current = this.morseCodeTrie;
    for (int i = 0; i < charArray.length; i++) {
      String morseCode = characterToMorseMap.get(charArray[i]);
      for (int j = 0; j < morseCode.length(); j++) {
        Map<Character, TrieNode> trieMap = current.getTrieMap();
        char c = morseCode.charAt(j);
        TrieNode next = trieMap.getOrDefault(c, new TrieNode());
        trieMap.put(c, next);
        current = next;
      }
    }
    current.setEndOfWord(true);
    current.addWord(word);
  }

  public List<String> evaluateString(String pattern) {
    String[] patternFragments = pattern.split(" ");
    List<String> words = new ArrayList<>();
    for (String patternFragment : patternFragments) {
      patternFragment = patternFragment.trim();
      if (patternFragment == null || patternFragment.isEmpty()) {
        continue;
      }
      TrieNode current = this.morseCodeTrie;
      char[] charArray = patternFragment.toCharArray();
      String word = getWord(charArray, "", 0, current);
      if (word != null) {
        words.add(word);
      }
      /*for (int i = 0; i < charArray.length; i++) {
        Map<Character, TrieNode> trieMap = current.getTrieMap();
        TrieNode next = trieMap.get(charArray[i]);
        if (next == null) {
          break;
        }
        current = next;
      }
      if (current.isEndOfWord()) {
        words.add(current.getWord());
      }*/
    }
    return words;
  }

  private String getWord(char[] patternFragment, String fragment, int index,
      TrieNode current) {
    if (current == null) {
      return null;
    }
    if (index == patternFragment.length) {
      Set<String> words = current.getWords();
      return words.isEmpty() ? null : words.iterator().next();
    }
    Map<Character, TrieNode> trieMap = current.getTrieMap();
    if (trieMap == null) {
      return null;
    }
    char c = patternFragment[index];
    TrieNode next = trieMap.get(c);
    if (next == null) {
      return null;
    }

    String word = getWord(patternFragment, fragment + c, index + 1, next);
    if (word != null) {
      return word;
    }
    word =  getProbableString(current);
    if (word != null) {
      return word + "?";
    }
    return "No matching word found";
  }

  private String getProbableString(TrieNode current) {
    if (current == null) {
      return null;
    }
    if (current.isEndOfWord()) {
      Set<String> words = current.getWords();
      return words.isEmpty() ? null : words.iterator().next();
    }
    Map<Character, TrieNode> map = current.getTrieMap();
    for (Map.Entry<Character, TrieNode> entry : map.entrySet()) {
      TrieNode next = entry.getValue();
      String word = getProbableString(next);
      if (word != null) {
        return word;
      }
    }
    return null;
  }
}
