package com.theferndaleset.xtalk32;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 12/23/2017.

 */
public class VoiceProcessor {

    public List<MethodName> methodList = new ArrayList<>();

    public VoiceProcessor()
    {
        Method[] methods = this.getClass().getMethods();
        for(Method m : methods)
        {
            Annotation[] annotations = m.getDeclaredAnnotations();
            for(Annotation a : annotations)
            {
                if (a.annotationType().equals(VoiceCommand.class))
                {
                    String[] commands = ((VoiceCommand)a).command();
                    for(String command : commands) {
                        methodList.add(new MethodName(command, m));
                    }
                }
            }
        }
    }

    public String defaultFunction()
    {
        return "No valid function was found";
    }

    public String executeCommand(String input) {
        TextConverter converter = new TextConverter();
        input = converter.ReplaceNumbers(input);
        for(MethodName method : methodList){
            if (method.isMatch(input)){
                try {
                    String result = (String)method.method.invoke(this, method.getParameterArray(input));
                    return result;
                } catch (InvocationTargetException e) {
                    return "Failed to execute function";
                }catch (IllegalAccessException e) {
                    return "Failed to execute function";
                }
            }
        }

        return defaultFunction();
    }
}
