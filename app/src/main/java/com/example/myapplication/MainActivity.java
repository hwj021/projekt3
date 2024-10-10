package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private CountViewModel countViewModel;
    private TextView textViewCount;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);

        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        updateCountText();

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countViewModel.incrementCount();

                updateCountText();
            }
        });
    }
    private void updateCountText(){
        textViewCount.setText("Licznik:" + countViewModel.getCount());
    }
}