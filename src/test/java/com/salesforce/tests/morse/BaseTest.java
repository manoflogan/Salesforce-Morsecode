package com.salesforce.tests.morse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

/**
 * Test runner for test scenarios
 */
public class BaseTest {

    protected void runTest(List<String> inputs, String[] expectedOutput) throws IOException {
        Main main = new Main();
        String[] output = main.doIt(inputs);
        Assert.assertEquals(Arrays.toString(expectedOutput), Arrays.toString(output));
    }
}
