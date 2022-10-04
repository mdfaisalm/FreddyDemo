package com.freddy.apps.freddydemo;

import static com.freddy.apps.freddydemo.RelativeLayoutExample.userDetailClass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView tvUserDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvUserDetails = findViewById(R.id.tvUserDetails);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dummy_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int clickedMenuItemID = item.getItemId();
        switch (clickedMenuItemID) {
            case android.R.id.home:
                finish();
                break;
            case R.id.actionFirstMenu:
                Toast.makeText(this, "First Menu Clicked", Toast.LENGTH_SHORT).show();
                tvUserDetails.setText(userDetailClass.getUserName()
                        + " " + userDetailClass.getUserAge());
                break;

            case R.id.actionSecondMenu:
                Toast.makeText(this, "Second Menu Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.actionThirdMenu:
                Toast.makeText(this, "Third Menu Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}