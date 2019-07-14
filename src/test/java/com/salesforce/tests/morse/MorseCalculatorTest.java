package com.salesforce.tests.morse;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

/**
 * Unit test for the sample input
 */
public class MorseCalculatorTest extends BaseTest {

    @Test
    public void testSampleInput() throws IOException {
        String[] testInput = {
                "A .-",
                "B -...",
                "C -.-.",
                "D -..",
                "E .",
                "F ..-.",
                "G --.",
                "H ....",
                "I ..",
                "J .---",
                "K -.-",
                "L .-..",
                "M --",
                "N -.",
                "O ---",
                "P .--.",
                "Q --.-",
                "R .-.",
                "S ...",
                "T -",
                "U ..-",
                "V ...-",
                "W .--",
                "X -..-",
                "Y -.--",
                "Z --..",
                "0 ------",
                "1 .-----",
                "2 ..---",
                "3 ...--",
                "4 ....-",
                "5 .....",
                "6 -....",
                "7 --...",
                "8 ---..",
                "9 ----.",
                "*",
                "AN",
                "EARTHQUAKE",
                "EAT",
                "GOD",
                "HATH",
                "IM",
                "READY",
                "TO",
                "WHAT",
                "WROTH",
                "*",
                ".--.....-- .....--....",
                "--.----.. .--.-.----..",
                ".--.....-- .--.",
                "..-.-.-....--.-..-.--.-.",
                "..-- .-...--..-.--",
                "---- ..--",
                "*"
        };

        String[] expectedOutput = {
                "WHAT",
                "HATH",
                "GOD",
                "WROTH?",
                "WHAT",
                "AN",
                "EARTHQUAKE",
                "IM",
                "READY",
                "TO",
                "IM"
        };
        runTest(Arrays.asList(testInput), expectedOutput);
    }
    
    @Test
    public void testWroth() throws Exception {
      String[] testInput = {
          "A .-",
          "B -...",
          "C -.-.",
          "D -..",
          "E .",
          "F ..-.",
          "G --.",
          "H ....",
          "I ..",
          "J .---",
          "K -.-",
          "L .-..",
          "M --",
          "N -.",
          "O ---",
          "P .--.",
          "Q --.-",
          "R .-.",
          "S ...",
          "T -",
          "U ..-",
          "V ...-",
          "W .--",
          "X -..-",
          "Y -.--",
          "Z --..",
          "0 ------",
          "1 .-----",
          "2 ..---",
          "3 ...--",
          "4 ....-",
          "5 .....",
          "6 -....",
          "7 --...",
          "8 ---..",
          "9 ----.",
          "*",
          "AN",
          "EARTHQUAKE",
          "EAT",
          "GOD",
          "HATH",
          "IM",
          "READY",
          "TO",
          "WHAT",
          "WROTH",
          "*",
          ".--.-.----..",
          "*"
      };
      String[] expectedOutput =new String[] {"WROTH?"};
      runTest(Arrays.asList(testInput), expectedOutput);
    }
}
