package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText amount;
    private SeekBar seekBar;
    private TextView percentage;
    private Button btn;
    private TextView result;
    private int seekValue;
    private float billAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.amount);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        percentage = (TextView) findViewById(R.id.percentage);
        btn = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);

        btn.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percentage.setText(String.valueOf(seekBar.getProgress())+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekValue = seekBar.getProgress();
            }
        });
    }


    @Override
    public void onClick(View view) {
        float tip = 0.0f;
        // Log.d("Whatever", String.valueOf(billAmount) );
        if(!(amount.getText().toString().equals(""))) {
            billAmount = Float.parseFloat(amount.getText().toString());
            tip = billAmount * seekValue / 100;
            result.setText("Tip: $"+String.valueOf(tip)+"\nMoney Spent: $"+String.valueOf(tip+billAmount));
        } else {
            Toast.makeText(MainActivity.this, "Please enter bill amount.", Toast.LENGTH_LONG).show();
        }
    }
}