package com.example.hp.kitchen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class freezersettings extends AppCompatActivity {
    private Spinner spin2;
    private Button btnSubmit;
    private TextView initialTemp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freezersettings);
        addListenerOnButton();
    }
    public void addListenerOnButton() {

        spin2 = (Spinner) findViewById(R.id.spin2);
        btnSubmit = (Button) findViewById(R.id.changeSettings);
        initialTemp1 = (TextView) findViewById(R.id.initFreezerTemp);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(freezersettings.this,
                        "OnClickListener : " +
                                "\nChanged Temperature : "+ String.valueOf(spin2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
                initialTemp1.setText(String.valueOf(spin2.getSelectedItem()));
            }

        });
    }
}
