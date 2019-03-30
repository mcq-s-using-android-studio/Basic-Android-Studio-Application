package com.example.multiplechoicequiz;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity2 extends AppCompatActivity {
    private TextView ScoreView;
    private TextView CommentView;
    private MainActivity myActivity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ScoreView = (TextView) findViewById(R.id.textView);
        CommentView = (TextView) findViewById(R.id.textView5);


        //Getting the text score info from 2nd xml activity
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("Final_Score_Value");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("Final_Score_Value");
        }

        ScoreView.setText("You Scored \t "+newString);//Set texts from the main activity and parses into the secondary activity
        int my_Score = Integer.parseInt(newString);
        if (my_Score >= 8 && my_Score <= 11) {
            CommentView.setText("Bravo!!");
        } else if (my_Score >= 5 && my_Score < 8) {
            CommentView.setText("Well Done!!");
        } else if (my_Score > 3 && my_Score < 5) {
            CommentView.setText("Average!!");
        } else if (my_Score <= 3) {
            CommentView.setText("Push yourself a little!!");
        }

        /*Intent launchNextActivity;
        launchNextActivity = new Intent(MainActivity2.this, MainActivity.class);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(launchNextActivity);
    */}
    //Now exiting the application when back is pressed
    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        Intent launchNextActivity;
        launchNextActivity = new Intent(MainActivity2.this, MainActivity.class);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(launchNextActivity);
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }

}
