package com.freddy.apps.freddydemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntentDataSenderActivity extends AppCompatActivity {

    EditText etStringDataSender, etIntegerDataSender;
    CheckBox cbBooleanSender;
    TextView tvBackResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_data_sender);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etStringDataSender = findViewById(R.id.etStringDataSender);
        etIntegerDataSender = findViewById(R.id.etIntegerDataSender);
        cbBooleanSender = findViewById(R.id.cbBooleanSender);
        tvBackResult = findViewById(R.id.tvBackResult);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
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
        startActivityForResult(intent, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK) {
            String backData = data.getStringExtra("backData");
            tvBackResult.setText(backData);
        }
    }
}