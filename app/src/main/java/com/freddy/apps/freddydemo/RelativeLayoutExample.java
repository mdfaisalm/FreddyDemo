package com.freddy.apps.freddydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RelativeLayoutExample extends AppCompatActivity {

    static UserDetailClass userDetailClass = new UserDetailClass("Faisal");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_example);
    }
}