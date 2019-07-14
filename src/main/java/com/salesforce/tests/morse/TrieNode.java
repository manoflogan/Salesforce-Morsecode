package com.salesforce.tests.morse;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie Node Data structure
 */
public class TrieNode {
  private final Map<Character, TrieNode> trieMap;
  
  private boolean isEndOfWord;
  
  private Character character;
  
  private String word;
  
  public TrieNode() {
    this.trieMap = new HashMap<>();
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

  public String getWord() {
    return word;
  }

  public void setWord(String endWord) {
    this.word = endWord;
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }
}
