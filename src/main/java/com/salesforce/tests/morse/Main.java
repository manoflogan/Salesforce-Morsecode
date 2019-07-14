package com.salesforce.tests.morse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The entry point for the Test program
 */
public class Main {

    /**
     * do the work here
     *
     * @param input the input text
     * @return the result
     */
    public String[] doIt(List<String> inputs) throws IOException {
      Trie calculator = new Trie();
      boolean parseAlphaNumericCharacters = false;
      boolean parseMorseCharacters = false;
      List<String> words = new ArrayList<>();
      for (String input : inputs) {
        if (!input.equals("*")) {
          if (!parseAlphaNumericCharacters && !parseMorseCharacters) {
            calculator.initialisePatterns(input);
          } else if (parseAlphaNumericCharacters) {
            calculator.initialiseMorseCode(input);
          } else if (parseMorseCharacters) {
            words.addAll(calculator.evaluateString(input));
          }
        } else if (!parseAlphaNumericCharacters && !parseMorseCharacters) {
          parseAlphaNumericCharacters = true;
        } else if (!parseMorseCharacters) {
          parseMorseCharacters = true;
          parseAlphaNumericCharacters = false;
        }
      }
      return words.toArray(new String[0]);
    }
    
    
    //==================You don't need to change the following codes ==========================//
    public static void main(String[] args) throws IOException {
        Main theOne = new Main();

        FileReader reader = null;
        try {
            //read from the input file
            reader = new FileReader(args.length == 1 ? args[0] : "input.txt");

            //do the processing
            String[] output = theOne.doIt(readFromFile(reader));

            //write the output to stdout
            //the output should be one we see in output.txt
            for (String s : output) {
                System.out.println(s);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Read input from the file and convert into a String
     *
     * @param reader Input file
     * @return Input in a String
     * @throws IOException
     */
  private static List<String> readFromFile(FileReader reader) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(reader);) {

      String line;
      List<String> words = new ArrayList<>();
      while (((line = bufferedReader.readLine()) != null) && line.trim().length() > 0) {
        words.add(line);
      }
      return words;
    }
  }
}
