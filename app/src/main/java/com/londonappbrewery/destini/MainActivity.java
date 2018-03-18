package com.londonappbrewery.destini;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Declare variables (object & Data Variables)
    TextView StoryBox;
    Button TopBBox;
    Button BBBox;
    String StoryText;
    String TBText;
    String BBText;
    String[] sFileArray = new String[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link screen objects to variables
        StoryBox = (TextView) findViewById(R.id.storyTextView);
        TopBBox = (Button) findViewById(R.id.buttonTop);
        BBBox = (Button) findViewById(R.id.buttonBottom);

        //Set objects data to variable
        StoryText = (String) StoryBox.getText();
        TBText = (String) TopBBox.getText();
        BBText = (String) BBBox.getText();

        //Array to link to string file
        sFileArray[0] = getResources().getString(R.string.T1_Story);
        sFileArray[1] = getResources().getString(R.string.T1_Ans1);
        sFileArray[2] = getResources().getString(R.string.T1_Ans2);
        sFileArray[3] = getResources().getString(R.string.T2_Story);
        sFileArray[4] = getResources().getString(R.string.T2_Ans1);
        sFileArray[5] = getResources().getString(R.string.T2_Ans2);
        sFileArray[6] = getResources().getString(R.string.T3_Story);
        sFileArray[7] = getResources().getString(R.string.T3_Ans1);
        sFileArray[8] = getResources().getString(R.string.T3_Ans2);
        sFileArray[9] = getResources().getString(R.string.T4_End);
        sFileArray[10] = getResources().getString(R.string.T5_End);
        sFileArray[11] = getResources().getString(R.string.T6_End);


        // Set a listener on the top button:
        /* Send current Story and Response Button text/data to TurnPg class
           Get next StoryBox & Button Text from TurnPg Method */
        TopBBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnPg CurrentDisplayInfo = new TurnPg(StoryText, TBText, sFileArray);
                String[] TempBookmark = CurrentDisplayInfo.NxtChpDetails();
                StoryText = TempBookmark[0];
                TBText = TempBookmark[1];
                BBText = TempBookmark[2];
                Log.d("TempBookmark[0]", (String) TempBookmark[0]);
                Log.d("TempBookmark[1]", (String) TempBookmark[1]);
                Log.d("TempBookmark[2]", (String) TempBookmark[2]);
                //Display new Story & button data on screen
                StoryBox.setText(StoryText);
                TopBBox.setText(TBText);
                BBBox.setText(BBText);
                if (TBText.contains("The End") || BBText.contains("The End")) {
                    TopBBox.setVisibility(View.INVISIBLE);
                    BBBox.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Set a listener on the bottom button:
        /* Send current Story and Response Button text/data to TurnPg class
           Get next StoryBox & Button Text from TurnPg Method*/
        BBBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnPg CurrentDisplayInfo = new TurnPg(StoryText, BBText, sFileArray);
                String[] TempBookmark = CurrentDisplayInfo.NxtChpDetails();
                StoryText = TempBookmark[0];
                TBText = TempBookmark[1];
                BBText = TempBookmark[2];
                Log.d("TempBookmark[0]", (String) TempBookmark[0]);
                Log.d("TempBookmark[1]", (String) TempBookmark[1]);
                Log.d("TempBookmark[2]", (String) TempBookmark[2]);
                //Display new Story & button data on screen
                StoryBox.setText(StoryText);
                TopBBox.setText(TBText);
                BBBox.setText(BBText);
                if (TBText.contains("The End") || BBText.contains("The End")) {
                    TopBBox.setVisibility(View.INVISIBLE);
                    BBBox.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}
