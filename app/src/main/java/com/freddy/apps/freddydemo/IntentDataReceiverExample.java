package com.freddy.apps.freddydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class IntentDataReceiverExample extends AppCompatActivity {

    TextView tvStringData, tvIntegerData;
    CheckBox cbBooleanData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_data_receiver);

        tvStringData = findViewById(R.id.tvStringData);
        tvIntegerData = findViewById(R.id.tvIntegerData);
        cbBooleanData = findViewById(R.id.cbBooleanData);

        String strData = getIntent().getStringExtra("strData");
        int intData = getIntent().getIntExtra("intData", 0);
        boolean booleanData = getIntent().getBooleanExtra("booleanData", false);

        tvStringData.setText(strData);
        tvIntegerData.setText(String.valueOf(intData));
        cbBooleanData.setChecked(booleanData);
    }
}