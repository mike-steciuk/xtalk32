package com.theferndaleset.xtalk32;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface VoiceCommand
{
    String[] command();
}
