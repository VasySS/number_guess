package com.example.number_guess;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.number_guess.databinding.ActivityGameBinding;

public class GameActivity extends AppCompatActivity {
    int start, end;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        start = intent.getIntExtra("rangeStart",0);
        end = intent.getIntExtra("rangeEnd",100);

        tv = findViewById(R.id.msgToUser);
        tv.setText("Ваше число больше " + (start+end)/2 + " ?");
    }

    public void onClick(View view) {
        if (end==start){
            tv.setText("Ваше число: " + (start));

            findViewById(R.id.btnYes).setVisibility(View.INVISIBLE);
            findViewById(R.id.btnNo).setVisibility(View.INVISIBLE);
            return;
        }

        if (end-start==2) {
            tv.setText("Ваше число: " + (start+1));

            findViewById(R.id.btnYes).setVisibility(View.INVISIBLE);
            findViewById(R.id.btnNo).setVisibility(View.INVISIBLE);
            return;
        }

        if (view.getId() == R.id.btnYes) {
            start = (start+end+1)/2;
        } else {
            end = (start+end)/2;
        }

        tv.setText("Ваше число больше " + (start+end)/2 + " ?");
    }
}