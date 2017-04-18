package com.example.hp.kitchen;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class microwave extends AppCompatActivity {

    private Button turnoff;
    private Button turnon;
    private Button stop;
    private EditText inputTime;
    private ImageView microwaveImage;
    private ProgressBar timeProgress;
    private TextView tView;
    private static boolean turnOn = true;
    private int processTime=0;
    private final static String ACTIVITY_NAME="Microwave_Activity";
    private int progress=0;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microwave);

        //link to all view items
        turnon = (Button) findViewById(R.id.onOffButton);
        stop = (Button) findViewById(R.id.microwave_stop);
        inputTime = (EditText)findViewById(R.id.inputTime);
        tView = (TextView) findViewById(R.id.tv_runningtimer);
        microwaveImage = (ImageView) findViewById(R.id.microwaveImage);
        timeProgress = (ProgressBar) findViewById(R.id.microwave_progress);

        turnoff = (Button) (findViewById(R.id.turnoff)) ;
        timeProgress.setProgress(0);

        //button function - when clicked, it also changes the image
        turnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "turns on", Toast.LENGTH_SHORT).show() ;
                microwaveImage.setImageResource(R.drawable.microwaveon);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // timer.cancel();
                //turnOff();
                Toast.makeText(getApplicationContext(), " it stops", Toast.LENGTH_SHORT).show();
            }
        });


        turnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), " turns off", Toast.LENGTH_SHORT).show() ;
                microwaveImage.setImageResource(R.drawable.microwaveoff);
            }
        });
    }



    public void turnOn(){
        // microwave is off
        stop.setText("");
        stop.setEnabled(true);
        timeProgress.setVisibility(View.VISIBLE);

        //turn on microwave and allow microwave to be turned off
        turnOn = false;
        //     microwaveImage.setImageResource(R.drawable.);
        turnon.setText("");
    }

    public void turnOff(){

        stop.setEnabled(false);
        processTime = 0;
        progress = 0;
        timeProgress.setVisibility(View.INVISIBLE);
        inputTime.setText("");

        turnOn = true;

    }


}