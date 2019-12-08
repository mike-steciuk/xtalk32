package com.theferndaleset.xtalk32;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VoiceProcessorTests {
    @Test
    public void Processor_finds_method_and_executes_method() throws Exception {
        VoiceProcessorTests.VoiceProcesserTestClass test = new VoiceProcesserTestClass();

        String result = test.executeCommand("My name is Mike Steciuk. I am 32 years OLD.");

        assertEquals("Mike Steciuk is 32 years old", result);
    }
    @Test
    public void Processor_propertly_converts_words_to_numbers() throws Exception {
        VoiceProcessorTests.VoiceProcesserTestClass test = new VoiceProcesserTestClass();

        String result = test.executeCommand("My name is Mike Steciuk. I am thirty two years OLD.");

        assertEquals("Mike Steciuk is 32 years old", result);
    }

    public class VoiceProcesserTestClass extends VoiceProcessor{
        @VoiceCommand(command={"my name is {firstName} {lastName}. i am {age} years old."})
        public String TestMethod(String firstName, String lastName, Integer age)
        {
            return firstName + " " + lastName + " is " + age.toString() + " years old";
        }
    }
}

