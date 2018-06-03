package com.thunkable.android.diogo_borbar.EvapoCalc;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle args2 = getIntent().getExtras();
        String hs =args2.getString("Hargreaves");
        TextView tsHs = (TextView)findViewById(R.id.textViewHS);
        tsHs.setText(hs);

        String linacre = args2.getString("Linacre");
        TextView tsLinacre = (TextView)findViewById(R.id.textViewLinacre);
        tsLinacre.setText(linacre);


    }
}
