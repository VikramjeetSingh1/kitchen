package com.example.hp.kitchen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class fridge extends AppCompatActivity {
    private RadioButton fridgeSettings;
    private RadioButton freezerSettings;
    private Button tempSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        fridgeSettings = (RadioButton) findViewById(R.id.fridge);
        freezerSettings= (RadioButton) findViewById(R.id.freezer);
        tempSettings = (Button) findViewById(R.id.tempSettings);
        tempSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(fridgeSettings.isChecked())
                {

                    Intent intent = new Intent(getApplicationContext(),fridgesettings.class);
                    startActivityForResult(intent,5);

                }
                else
                {
                    if(freezerSettings.isChecked())
                    {
                        Intent intent = new Intent(getApplicationContext(),freezersettings.class);
                        startActivityForResult(intent,5);

                    }
                }
            }
        });
    }
}