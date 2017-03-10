package edu.stanford.cs108.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addItem(View view) {
        TextView textView = (TextView) findViewById(R.id.textOutput);
        EditText editText = (EditText) findViewById(R.id.textInput);
        textView.append(editText.getText().toString()+'\n');
        editText.setText("");
    }

    public void clearList(View view) {
        TextView textView = (TextView) findViewById(R.id.textOutput);
        EditText editText = (EditText) findViewById(R.id.textInput);
        textView.setText("");
        editText.setText("");
    }
}
