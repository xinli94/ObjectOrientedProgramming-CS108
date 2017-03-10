package edu.stanford.cs108.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateCost(View view) {
        EditText editText = (EditText) findViewById(R.id.textInput);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.speedGroup);
        CheckBox checkBox = (CheckBox) findViewById(R.id.insurance);
        TextView textView = (TextView) findViewById(R.id.cost);

        double weight = Double.parseDouble(editText.getText().toString());
        int speed = radioGroup.getCheckedRadioButtonId();
        double unit = 3; //case R.id.standard
        switch (speed) {
            case R.id.nextDay:
                unit = 10;
                break;
            case R.id.secondDay:
                unit = 5;
                break;
        }
        int cost;
        if (checkBox.isChecked()){
            cost = (int) Math.round(1.2*weight*unit);
        }
        else{
            cost = (int) Math.round(weight*unit);
        }

        textView.setText("Cost:"+Integer.toString(cost));
//        editText.setText("");
//        radioGroup.check(R.id.nextDay);
//        checkBox.setChecked(true);
    }
}
