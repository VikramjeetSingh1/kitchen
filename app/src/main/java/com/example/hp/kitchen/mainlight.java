package com.example.hp.kitchen;

import android.content.ContentResolver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class mainlight extends AppCompatActivity {
    //  private SeekBar dim ;
    private WindowManager.LayoutParams lp;
    private SeekBar brightbar;

    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Window object, that will store a reference to the current window
    private Window window;

    TextView txtPerc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /** Called when the activity is first created. */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlight);

        Button on = (Button) findViewById(R.id.kitchen_light_on);
        Button off = (Button) findViewById(R.id.kitchen_light_off);


        //Instantiate seekbar object
        brightbar = (SeekBar) findViewById(R.id.brightbar);

        txtPerc = (TextView) findViewById(R.id.txtPercentage);

        //Get the content resolver
        cResolver = getContentResolver();

        //Get the current window
        window = getWindow();

        //Set the seekbar range between 0 and 100
        brightbar.setMax(100);
        //Set the seek bar progress to 1
        brightbar.setKeyProgressIncrement(1);
        lp = getWindow().getAttributes();
        lp.screenBrightness = 50 / 100.0f;
        getWindow().setAttributes(lp);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brightbar.setProgress(100);
                lp.screenBrightness = 100 / 100.0f;
                getWindow().setAttributes(lp);
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brightbar.setProgress(0);
                lp.screenBrightness = 0 / 100.0f;
                txtPerc.setText("0%");
                getWindow().setAttributes(lp);
            }
        });

        //Set the progress of the seek bar based on the system's brightness
        brightbar.setProgress(brightness);

        //Register OnSeekBarChangeListener, so it can actually change values
        brightbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onStopTrackingTouch(SeekBar seekBar)
            {

                //Get the current window attributes
                WindowManager.LayoutParams layoutpars = window.getAttributes();
                //Set the brightness of this window
                layoutpars.screenBrightness = brightness / (float)100;
                //Apply attribute changes to this window
                window.setAttributes(layoutpars);
            }

            public void onStartTrackingTouch(SeekBar seekBar)
            {
                //Nothing handled here
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //Set the minimal brightness level
                //if seek bar is 20 or any value below
                if(progress<=20)
                {
                    //Set the brightness to 20
                    brightness=20;
                }
                else //brightness is greater than 20
                {
                    //Set brightness variable based on the progress bar
                    brightness = progress;
                }
                //Calculate the brightness percentage
                float perc = (brightness /(float)100)*100;
                //Set the brightness percentage
                txtPerc.setText((int)perc +"%");
            }
        });
    }}
