package com.theferndaleset.xtalk32;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TextConverterTests {
    @Test
    public void replaceNumbers_resolves_twenty_two_with_upper_case() throws Exception {
        TextConverter converter = new TextConverter();
        String result = converter.ReplaceNumbers("Twenty Two");
        assertEquals("22", result);
    }

    @Test
    public void replaceNumbers_resolves_twenty_two_with_lower_case() throws Exception {
        TextConverter converter = new TextConverter();
        String result = converter.ReplaceNumbers("twenty two");
        assertEquals("22", result);
    }

    @Test
    public void replaceNumbers_resolves_sentence_with_multiple_numbers() throws Exception {
        TextConverter converter = new TextConverter();
        String result = converter.ReplaceNumbers("swap labels for channel one and channel thirty two");
        assertEquals("swap labels for channel 1 and channel 32", result);
    }
}