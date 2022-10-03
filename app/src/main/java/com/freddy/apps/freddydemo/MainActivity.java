package com.freddy.apps.freddydemo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvFirstTextView, tvSelectedCity;
    Button btnFirstButton, btnMoveToRelativeLayoutActivity;
    EditText etName;
    RadioGroup rgEnableButton;
    CheckBox cbCourse1, cbCourse2, cbCourse3;
    Spinner spCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirstTextView = findViewById(R.id.tvFirstTextView);
        btnFirstButton = findViewById(R.id.btnFirstButton);
        etName = findViewById(R.id.etName);
        rgEnableButton = findViewById(R.id.rgEnableButton);
        btnMoveToRelativeLayoutActivity = findViewById(R.id.btnMoveToRelativeLayoutActivity);
        cbCourse1 = findViewById(R.id.cbCourse1);
        cbCourse2 = findViewById(R.id.cbCourse2);
        cbCourse3 = findViewById(R.id.cbCourse3);
        spCities = findViewById(R.id.spCities);
        tvSelectedCity = findViewById(R.id.tvSelectedCity);

/*
        btnFirstButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Our Button is clicked successfully", Toast.LENGTH_SHORT).show();

            String userInput = etName.getText().toString();
            tvFirstTextView.setText(userInput);
            etName.setText("");
        });
*/
        btnMoveToRelativeLayoutActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RelativeLayoutExample.class);
            startActivity(intent);
        });
        btnFirstButton.setOnClickListener(v -> {
            String result = "";
            if (cbCourse1.isChecked()) {
                result = cbCourse1.getText().toString();
            }
            if (cbCourse2.isChecked()) {
                result = result + "\n" + cbCourse2.getText().toString();
            }
            if (cbCourse3.isChecked()) {
                result = result + "\n" + cbCourse3.getText().toString();
            }
            if (result.isEmpty()) {
                result = "No selection made";
            }
            tvFirstTextView.setText(result);
        });


        rgEnableButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rgEnableButton.getCheckedRadioButtonId() == R.id.rbFirst) {
                    btnFirstButton.setEnabled(true);
                } else {
                    btnFirstButton.setEnabled(false);
                }
            }
        });

        spCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String selectedCityText = textView.getText().toString();
                tvSelectedCity.setText(selectedCityText + "_" + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void moveToDataSenderActivity(View view) {
        Intent intent = new Intent(this, IntentDataSenderActivity.class);
        startActivity(intent);
    }
}