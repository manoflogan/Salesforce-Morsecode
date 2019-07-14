package com.salesforce.tests.morse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Trie Node Data structure
 */
public class TrieNode {
  private final Map<Character, TrieNode> trieMap;
  
  private boolean isEndOfWord;
  
  private Set<String> words;
  
  public TrieNode() {
    this.trieMap = new HashMap<>();
    this.words = new HashSet<>();
  }
  
  public Map<Character, TrieNode> getTrieMap() {
    return trieMap;
  }

  @Override
  public String toString() {
    return new StringBuilder().append(this.trieMap).toString();
  }

  public boolean isEndOfWord() {
    return isEndOfWord;
  }

  public void setEndOfWord(boolean isEndOfWord) {
    this.isEndOfWord = isEndOfWord;
  }

  public Set<String> getWords() {
    return words;
  }
  
  public void addWord(String word) {
    this.words.add(word);
  }
}
