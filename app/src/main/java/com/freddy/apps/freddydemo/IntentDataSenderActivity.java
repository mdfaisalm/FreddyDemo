package com.freddy.apps.freddydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class IntentDataSenderActivity extends AppCompatActivity {

    EditText etStringDataSender, etIntegerDataSender;
    CheckBox cbBooleanSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_data_sender);

        etStringDataSender = findViewById(R.id.etStringDataSender);
        etIntegerDataSender = findViewById(R.id.etIntegerDataSender);
        cbBooleanSender = findViewById(R.id.cbBooleanSender);
    }

    public void sendDataToNextScreen(View view) {
        String strData = etStringDataSender.getText().toString();
        if (strData.isEmpty()) {
            Toast.makeText(this, "Please enter string data", Toast.LENGTH_SHORT).show();
            return;
        }
        String intDataStr = etIntegerDataSender.getText().toString();
        if (intDataStr.isEmpty()) {
            Toast.makeText(this, "Please enter digit data", Toast.LENGTH_SHORT).show();
            return;
        }
        int intData = Integer.parseInt(intDataStr);
        boolean booleanData = cbBooleanSender.isChecked();

        Intent intent = new Intent(IntentDataSenderActivity.this, IntentDataReceiverExample.class);
        intent.putExtra("strData", strData);
        intent.putExtra("intData", intData);
        intent.putExtra("booleanData", booleanData);
        startActivity(intent);
    }
}