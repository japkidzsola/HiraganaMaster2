package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Medium extends AppCompatActivity {

    public Button first,second,third,fourth,fifth,sixth;
    public TextView timer, points, pointsneeded;
    public ImageView mediumimg;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 60000;
    private boolean timerRunning;

    public int pontokk = 0;
    //public

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);
        init();

        final String[] megoldas = {general()};
        final int[] pointtt = {0};

        // general();.Resources$NotFoundException: String resource ID #0x1
        do {

            final String seged = points.getText().toString();
            final int pontok = Integer.parseInt(seged);
            final int seged2 = pontok;
            points.setText(seged);

            /*

            random(1-6) szam
            ciklus(1-6;i<=6,i++){
                if(i==szam){
                jofunction(+1 betolt)
                }
                else{
                function(betolt)
                }
            }

             */

            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(first.getText().toString().toLowerCase())){
                        Toast.makeText(Medium.this, "done", Toast.LENGTH_SHORT).show();
                        int kiir = sikeres(pontokk);
                        points.setText(kiir);
                        /*pointtt[0]++;
                        points.setText(pointtt[0]);*/
                        //megoldas[0] = general();
                    } else {
                        Toast.makeText(Medium.this, "nem egyenlő", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(second.getText().toString().toLowerCase())) {
                        Toast.makeText(Medium.this, "done", Toast.LENGTH_SHORT).show();
                        //sikeres(seged2);
                        /*pointtt++;
                        points.setText(pointtt);*/
                        megoldas[0] = general();
                    } else {
                        Toast.makeText(Medium.this, "nem egyenlő", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(third.getText().toString().toLowerCase())) {
                        Toast.makeText(Medium.this, "done", Toast.LENGTH_SHORT).show();
                        //sikeres(seged2);
                        /*pointtt++;
                        points.setText(pointtt);*/
                        megoldas[0] = general();
                    } else {
                        Toast.makeText(Medium.this, "nem egyenlő", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            fourth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(fourth.getText().toString().toLowerCase())) {
                        Toast.makeText(Medium.this, "done", Toast.LENGTH_SHORT).show();
                        //sikeres(seged2);
                       /* pointtt++;
                        points.setText(pointtt);*/
                        megoldas[0] = general();
                    } else {
                        Toast.makeText(Medium.this, "nem egyenlő", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            fifth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(fifth.getText().toString().toLowerCase())) {
                        Toast.makeText(Medium.this, "done", Toast.LENGTH_SHORT).show();
                        //sikeres(seged2);
                        /*pointtt++;
                        points.setText(pointtt);*/
                        megoldas[0] = general();
                    } else {
                        Toast.makeText(Medium.this, "nem egyenlő", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            sixth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(sixth.getText().toString().toLowerCase())) {
                        Toast.makeText(Medium.this, "done", Toast.LENGTH_SHORT).show();
                        //sikeres(seged2);
                        /*pointtt++;
                        points.setText(pointtt);/*/
                        megoldas[0] = general();
                    } else {
                        Toast.makeText(Medium.this, "nem egyenlő", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        while(points.getText().toString().equals(pointsneeded.getText().toString()));
    }


    public String general()
    {
        String megoldas = null;
        int random = random();
        int elhelyez = randomelhelyez();

        if(random == 1) {
            mediumimg.setImageResource(R.drawable.qa);
            megoldas = "a";
        }
        else if(random == 2) {
            mediumimg.setImageResource(R.drawable.qi);
            megoldas = "i";
        }
        else if(random == 3) {
            mediumimg.setImageResource(R.drawable.qu);
            megoldas = "u";
            first.setText("u");
        }

        if(megoldas != null)
        {
            if(elhelyez == 0)
            {
                first.setText(megoldas);
            } else if(elhelyez == 1)
            {
                second.setText(megoldas);
            } else if(elhelyez == 2)
            {
                third.setText(megoldas);
            } else if(elhelyez == 3)
            {
                fourth.setText(megoldas);
            } else if(elhelyez == 4)
            {
                fifth.setText(megoldas);
            } else if(elhelyez == 5)
            {
                sixth.setText(megoldas);
            }
        }
        return megoldas;
    }

    public int random()
    {
        int min = 1;
        int max = 3;
        Random r = new Random();
        int generalt = r.nextInt(max-min) + min;
        return generalt;
    }

    public int randomelhelyez()
    {
        int min = 0;
        int max = 5;
        Random r = new Random();
        int generalt = r.nextInt(max-min) + min;
        return generalt;
    }

    public int sikeres(int pontokk)
    {
        int i = 0;
        i = i+1;
        points.setText(i);
        return i;
    }

    public void init()
    {
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        fifth = findViewById(R.id.fifth);
        sixth = findViewById(R.id.sixth);
        mediumimg = findViewById(R.id.mediumimg);
        points = findViewById(R.id.points);
        pointsneeded = findViewById(R.id.pointsneeded);

        timer = findViewById(R.id.timer);
    }
}
