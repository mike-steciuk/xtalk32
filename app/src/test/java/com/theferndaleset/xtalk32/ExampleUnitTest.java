package com.theferndaleset.xtalk32;

import org.junit.Test;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void regExExperiments() throws Exception {
        MethodName methodName = new MethodName("set channel {channel} name {name}", VoiceProcessor.class.getMethod("TestMethod", Integer.class, String.class));


        methodName.isMatch("set channel 1 name test");

        assertEquals(true, true);
    }
}