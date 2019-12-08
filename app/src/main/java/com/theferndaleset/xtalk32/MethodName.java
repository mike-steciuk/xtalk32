package com.theferndaleset.xtalk32;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mike on 12/24/2017.
 */

public class MethodName {
    public String name;
    public String regEx;
    public Method method;

    private List<Object> parameterValues;

    public MethodName(String name, Method method){
        this.name = name;
        this.method = method;

        Pattern pattern = Pattern.compile("\\{(\\S*)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);

        this.regEx = name;
        while(matcher.find()) {
            String groupName = matcher.group(1);
            this.regEx = this.regEx.replaceAll("\\{"+groupName+"\\}", "(?<"+groupName+">\\\\S*)");
        }
        this.regEx = this.regEx.replaceAll("\\s+", "\\\\s+");
    }
    //InvocationTargetException
    public boolean isMatch(String input)
    {
        Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        m.find();
        Type[] types = method.getParameterTypes();
        //Parameter[] parameters = method.getParameters();

        this.parameterValues = new ArrayList<>();
        if (types != null && types.length == 0)
            return true;
        Integer index = 0;
        for(Type type : types) {
            index++;
            try{
                Object val = getValue(type, m.group(index));
                if (val == null) {
                    this.parameterValues = null;
                    return false;
                }

                parameterValues.add(val);
            } catch (Exception e) {
                if (e.getClass() == InvocationTargetException.class || e.getClass() == IllegalStateException.class){
                    this.parameterValues = null;
                    return false;
                }
                throw e;
            }
        }
        return true;
    }

    public Object[] getParameterArray(String input)
    {
        if (parameterValues != null || (parameterValues == null && this.isMatch(input)))
        {
            return this.parameterValues.toArray();
        }

        return null;
    }

    private Object getValue(Type type, String value) {
        if (type == String.class) {
            return value;
        }
        if (type == Integer.class) {

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e){
                return null;
            }
        }
        if (type == Double.class){
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                return null;
            }
        }

        return null;
    }
}
