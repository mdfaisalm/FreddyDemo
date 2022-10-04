package com.freddy.apps.freddydemo;

import static com.freddy.apps.freddydemo.RelativeLayoutExample.userDetailClass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserDetailsSetterGetterActivity extends AppCompatActivity {

    EditText etUserName, etUserAge;
    TextView tvUserName, tvUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details_setter_getter);

        etUserName = findViewById(R.id.etUserName);
        etUserAge = findViewById(R.id.etUserAge);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserAge = findViewById(R.id.tvUserAge);
    }

    public void setDataToUserDetailClass(View view) {
        String userAgeStr = etUserAge.getText().toString();
        if (userAgeStr.isEmpty()) {
            Toast.makeText(this, "Please enter age", Toast.LENGTH_SHORT).show();
            return;
        }
        int age = Integer.parseInt(userAgeStr);
        if (age > 100) {
            Toast.makeText(this, "Please enter valid age", Toast.LENGTH_SHORT).show();
            return;
        }
        userDetailClass.setUserName(etUserName.getText().toString());
        userDetailClass.setUserAge(age);
    }

    public void getDataFromUserDetailClass(View view) {
        tvUserName.setText(userDetailClass.getUserName());
        tvUserAge.setText(String.valueOf(userDetailClass.getUserAge()));
    }

    public void goToMenuActivity(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}