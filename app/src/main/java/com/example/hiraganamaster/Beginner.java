package com.example.hiraganamaster;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Beginner extends AppCompatActivity {

    public Button first, second,third, fourth;
    public ImageView beginnerimg;
    public TextView beginnertv;

    List<String> randomHiragana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
        init();

        randomHiragana = new ArrayList<>();

        randomHiragana.add("a");
        randomHiragana.add("i");
        randomHiragana.add("u");
        randomHiragana.add("e");
        randomHiragana.add("o");

        for(int i = 0; i < 48; i++)
        {

        }

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //randomgenerator();
                beginnertv.setText(randomgenerator());
            }
        });

    }

    public String randomgenerator()
    {
        int min=1;
        int max=48;

        Random random=new Random();
        int randomnumber=random.nextInt(max-min)+min;
        String rand = Integer.toString(randomnumber);
        return rand;
    }

    public void init()
    {
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        beginnerimg = findViewById(R.id.begginerimg);
        beginnertv = findViewById(R.id.beginnertv);
    }

    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You think you can't do this test?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Beginner.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
