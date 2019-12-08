package com.theferndaleset.xtalk32;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mike on 12/23/2017.
 */

public class TextConverter {

    private static  Map<String, Integer> numberMap;
    static {
        numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("ten", 10);
        numberMap.put("eleven", 11);
        numberMap.put("twelve", 12);
        numberMap.put("thirteen", 13);
        numberMap.put("fourteen", 14);
        numberMap.put("fifteen", 15);
        numberMap.put("sixteen", 16);
        numberMap.put("seventeen", 17);
        numberMap.put("eighteen", 18);
        numberMap.put("nineteen", 19);
        numberMap.put("twenty", 20);
        numberMap.put("thirty", 30);
        numberMap.put("forty", 40);
        numberMap.put("fifty", 50);
        numberMap.put("sixty", 60);
    }

    public String ReplaceNumbers(String original)
    {
        StringBuilder builder = new StringBuilder();
        String[] wordArray = original.split(" ");

        Integer numberValue = null;
        for (String w : wordArray)
        {
            String lowerCase = w.toLowerCase();
            if (numberMap.containsKey(lowerCase))
            {
                if (numberValue == null) numberValue = 0;
                numberValue += numberMap.get(lowerCase);
            }
            else
            {
                if (numberValue != null) {
                    builder.append(" " + numberValue.toString());
                    numberValue = null;
                }

                builder.append(" " + w);
            }
        }

        if (numberValue != null)
            builder.append(" " + numberValue.toString());

        return builder.toString().trim();
    }
}
