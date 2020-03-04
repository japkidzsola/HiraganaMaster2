package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hiraganamaster.ui.hiraganalearn.HiraganaLearnFragment;

public class EndingFail extends AppCompatActivity {

    Button failredomedium, failredobeginner, failredolearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_fail);

        failredomedium = findViewById(R.id.failredomedium);
        failredobeginner = findViewById(R.id.failredobeginner);
        failredolearn = findViewById(R.id.failredolearn);

        failredomedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndingFail.this, Medium.class);
                startActivity(intent);
                finish();
            }
        });

        failredobeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndingFail.this, Beginner.class);
                startActivity(intent);
                finish();
            }
        });

        failredobeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndingFail.this, HiraganaLearnFragment.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
