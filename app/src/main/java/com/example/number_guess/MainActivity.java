package com.example.number_guess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText st = findViewById(R.id.rangeStart);
        EditText nd = findViewById(R.id.rangeEnd);

        int start = Integer.parseInt(st.getText().toString());
        int end = Integer.parseInt(nd.getText().toString());

        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.putExtra("rangeStart", start);
        intent.putExtra("rangeEnd", end);
        startActivity(intent);
    }
}