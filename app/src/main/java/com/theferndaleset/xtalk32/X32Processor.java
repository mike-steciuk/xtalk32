package com.theferndaleset.xtalk32;

/**
 * Created by Mike on 12/24/2017.
 */

public class X32Processor extends VoiceProcessor{

    @VoiceCommand(command={"set channel {channel} name to {name}", "set channel {channel} name 2 {name}"})
    public String setChannelName(Integer channel, String name)
    {

        return String.format("Renamed channel %s to %s", channel.toString(), name);
    }
}
