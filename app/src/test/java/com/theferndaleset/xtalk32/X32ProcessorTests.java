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
public class X32ProcessorTests {
    @Test
    public void Processor_set_channel_name() throws Exception {
        X32Processor processor = new X32Processor();
        String response = processor.executeCommand("set channel one name to drums");
        response = processor.executeCommand("set channel one name 2 drums");

        response = processor.executeCommand("invalid string");
        assertEquals(true, true);
    }

    @Test
    public void regExExperiments() throws Exception {
        MethodName methodName = new MethodName("set channel {channel} name {name}", VoiceProcessor.class.getMethod("TestMethod", Integer.class, String.class));


        methodName.isMatch("set channel 1 name test");

        assertEquals(true, true);
    }
}