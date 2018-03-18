package com.londonappbrewery.destini;

import android.util.Log;
import android.widget.Button;

import java.lang.reflect.Constructor;

/**
 * Created by Charlie on 2018/03/10.
 */

public class TurnPg {

    // Class Variables (Store current story and button response data to TurnPg data variables)
    String StoryIndex;
    String AnsIndex;
    String NxtStoryTxt;
    String NxtTText;
    String NxtBText;

    // BookMark Array to store new Story & Button text
    String BookMark[] = {NxtStoryTxt, NxtTText, NxtBText};

    // StringIndexArray linked to StringDBArray (Main) : To get all the strings saved in String file
    String StringIndexArray[];

    /*Constructor method to get MainClass data from screen
      Store data received from MainScreen to TurnPg Data Variables */
    public TurnPg(String MainStory, String MainAnswer, String MainStringArray[]) {
        StoryIndex = MainStory;
        AnsIndex = MainAnswer;
        StringIndexArray = MainStringArray;
    }

    // Method to Find next story and answer according to the current TurnPg variables data
    /* If Else statement : Find next Story & Button Text according to current TurnPg data
       Store NxtStory & Button Text in Bookmark Array (NxtStoryText,NxtTopBText,NxtBBText) */
    public String[] NxtChpDetails() {
        Log.d("debug", "I'm in the NxtChpDetails() method");
        Log.d("StoryIndex", StoryIndex);
        Log.d("AnsIndex", AnsIndex);

        if (StoryIndex == StringIndexArray[0] & AnsIndex == StringIndexArray[1]) {
            Log.d("debug", "I'm in IF statement 1");
            BookMark[0] = StringIndexArray[6];
            BookMark[1] = StringIndexArray[7];
            BookMark[2] = StringIndexArray[8];
        } else if (StoryIndex == StringIndexArray[0] & AnsIndex == StringIndexArray[2]) {
            Log.d("debug", "I'm in IF statement 2");
            BookMark[0] = StringIndexArray[3];
            BookMark[1] = StringIndexArray[4];
            BookMark[2] = StringIndexArray[5];
        } else if (StoryIndex == StringIndexArray[3] & AnsIndex == StringIndexArray[4]) {
            Log.d("debug", "I'm in IF statement 3");
            BookMark[0] = StringIndexArray[6];
            BookMark[1] = StringIndexArray[7];
            BookMark[2] = StringIndexArray[8];
        } else if (StoryIndex == StringIndexArray[3] & AnsIndex == StringIndexArray[5]) {
            Log.d("debug", "I'm in IF statement 4");
            BookMark[0] = StringIndexArray[9];
            BookMark[1] = "The End";
            BookMark[2] = "The End";
        } else if (StoryIndex == StringIndexArray[6] & AnsIndex == StringIndexArray[7]) {
            Log.d("debug", "I'm in IF statement 5");
            BookMark[0] = StringIndexArray[11];
            BookMark[1] = "The End";
            BookMark[2] = "The End";
        } else if (StoryIndex == StringIndexArray[6] & AnsIndex == StringIndexArray[8]) {
            Log.d("debug", "I'm in IF statement 6");
            BookMark[0] = StringIndexArray[10];
            BookMark[1] = "The End";
            BookMark[2] = "The End";
        } else {
            Log.d("debug", "No answer found! BOO!");
            BookMark[0] = "No Story Found!! :(";
            BookMark[1] = (String) "The End";
            BookMark[2] = (String) "The End";
        }
        Log.d("Bookmark[0]", (String) BookMark[0]);
        Log.d("Bookmark[1]", (String) BookMark[1]);
        Log.d("Bookmark[2]", (String) BookMark[2]);

        //Send BookMark Array details to NewTemp Array (MainClass)
        return BookMark;
    }
}
