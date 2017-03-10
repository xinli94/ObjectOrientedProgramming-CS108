package edu.stanford.cs108.colorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeColor(View view) {
        TextView textView = (TextView) findViewById(R.id.colorOutput);
        SeekBar seekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);
        View colorView = (View) findViewById(R.id.colorView);

        int redValue = seekBarRed.getProgress();
        int greenValue = seekBarGreen.getProgress();
        int blueValue = seekBarBlue.getProgress();
        textView.setText("Red: "+Integer.toString(redValue)
                +", Green: "+Integer.toString(greenValue)
                +", Blue: "+Integer.toString(blueValue));
        colorView.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

    }
}
