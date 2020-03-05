package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hiraganamaster.ui.test.TestFragment;

public class Ending extends AppCompatActivity {

    Button redomedium,redohardcore;
    TextView score, taxfraud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        redomedium = findViewById(R.id.redomedium);
        redohardcore = findViewById(R.id.redohardcore);
        score = findViewById(R.id.score);
        String successful = getIntent().getExtras().getString("Success");
        String unsuccessful = getIntent().getExtras().getString("Unsuccess");
        //final String value = getIntent().getExtras().getString("Value");
        String asd = score.getText().toString();
        score.setText(asd + successful + " ,with " + unsuccessful+ " mistakes");


        redomedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ending.this, TestFragment.class);
                //String e = taxfraud.getText().toString();
                //startActivity(intent);
                //intent.putExtra("Value",value);
                finish();
            }
        });
    }
}
