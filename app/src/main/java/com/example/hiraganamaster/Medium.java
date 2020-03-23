package com.example.hiraganamaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import maes.tech.intentanim.CustomIntent;

public class Medium extends AppCompatActivity {

    public Button first,second,third,fourth,fifth,sixth;
    public TextView timer, points, pointsneeded, beginnertv;
    public ImageView mediumimg;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 10000;
    private long timeRestartInMilliseconds = 10000;
    private boolean timerRunning;

    private Handler mHandler = new Handler();

    private Menu menu;

    public int pontokk = 0;
    //public

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*LinearLayout linearLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/

        init();

        startTimer();

        String ertek = getIntent().getExtras().getString("Value");
        pointsneeded.setText(ertek);

        final String[] megoldas = {general()};
        final int[] pontok = {0};
        final int[] minuszpontok = {0};

        // general();.Resources$NotFoundException: String resource ID #0x1
        do {

            /*final String seged = points.getText().toString();
            final int pontok = Integer.parseInt(seged);
            final int seged2 = pontok;
            points.setText(seged);*/

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

            if(timer.getText().toString().equals("0"))
            {
                megoldas[0] = general();
            }

            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(first.getText().toString().toLowerCase())){
                        /*int kiir = sikeres(pontokk);
                        points.setText(kiir);*/
                        startColorAnim1(first);
                        //stopColorAnim(first);
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);

                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            animdelay1();
                            megoldas[0] = general();
                            stopTimer();
                            timeReset();
                            startTimer();
                        }
                    } else {
                        startFailAnim1(first);
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                        String seged = Integer.toString(minuszpontok[0]);
                        beginnertv.setText(seged);
                        if (minuszpontok[0] == 3)
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, EndingFail.class);
                            String hiba = megoldas[0];
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Mistake",hiba);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            });

            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(second.getText().toString().toLowerCase())) {
                        //sikeres(seged2);
                        startColorAnim2(second);
                        //stopColorAnim1(second);
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            megoldas[0] = general();
                            stopTimer();
                            timeReset();
                            startTimer();
                        }
                    }  else {
                        startFailAnim2(second);
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                        String seged = Integer.toString(minuszpontok[0]);
                        beginnertv.setText(seged);
                        if (minuszpontok[0] == 3)
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, EndingFail.class);
                            String hiba = megoldas[0];
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Mistake",hiba);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            });

            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(third.getText().toString().toLowerCase())) {
                        //sikeres(seged2);
                        startColorAnim3(third);
                        //stopColorAnim2(third);
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            megoldas[0] = general();
                            stopTimer();
                            timeReset();
                            startTimer();
                        }
                    } else {
                        startFailAnim3(third);
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                        String seged = Integer.toString(minuszpontok[0]);
                        beginnertv.setText(seged);
                        if (minuszpontok[0] == 3)
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, EndingFail.class);
                            String hiba = megoldas[0];
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Mistake",hiba);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            });

            fourth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(fourth.getText().toString().toLowerCase())) {
                        //sikeres(seged2);
                        startColorAnim4(fourth);
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            megoldas[0] = general();
                            stopTimer();
                            timeReset();
                            startTimer();
                        }
                    }  else {
                        startFailAnim4(fourth);
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                        String seged = Integer.toString(minuszpontok[0]);
                        beginnertv.setText(seged);
                        if (minuszpontok[0] == 3)
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, EndingFail.class);
                            String hiba = megoldas[0];
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Mistake",hiba);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            });

            fifth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(fifth.getText().toString().toLowerCase())) {
                        //sikeres(seged2);
                        startColorAnim5(fifth);
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            megoldas[0] = general();
                            stopTimer();
                            timeReset();
                            startTimer();
                        }
                    } else {
                        startFailAnim5(fifth);
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                        String seged = Integer.toString(minuszpontok[0]);
                        beginnertv.setText(seged);
                        if (minuszpontok[0] == 3)
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, EndingFail.class);
                            String hiba = megoldas[0];
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Mistake",hiba);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            });

            sixth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megoldas[0].equals(sixth.getText().toString().toLowerCase())) {
                        //sikeres(seged2);
                        startColorAnim6(sixth);
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else{
                            megoldas[0] = general();
                            stopTimer();
                            timeReset();
                            startTimer();
                        }
                    } else {
                        startFailAnim6(sixth);
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                        String seged = Integer.toString(minuszpontok[0]);
                        beginnertv.setText(seged);
                        if (minuszpontok[0] == 3)
                        {
                            stopTimer();
                            Intent intent = new Intent(Medium.this, EndingFail.class);
                            String hiba = megoldas[0];
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Mistake",hiba);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            });

            if(points.equals(pointsneeded))
            {
                finish();
            }
        }
        while(points.getText().toString().equals(pointsneeded.getText().toString()));
    }

    private void animdelay1() {
        Runnable animdelay1 = new Runnable() {
            @Override
            public void run() {
                startColorAnim1(first);
                mHandler.postDelayed(this, 3000);
            }
        };
    }
    private void animdelay2() {
        Runnable animdelay2 = new Runnable() {
            @Override
            public void run() {
                startColorAnim2(second);
                mHandler.postDelayed(this, 3000);
            }
        };
    }
    @SuppressLint("RestrictedApi")
    public void startColorAnim1(View v)
    {
        int colorStart = first.getSolidColor();
        int colorEnd = Color.GREEN;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(500);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startColorAnim2(View v)
    {
        int colorStart = second.getSolidColor();
        int colorEnd = Color.GREEN;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(500);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startColorAnim3(View v)
    {
        int colorStart = third.getSolidColor();
        int colorEnd = Color.GREEN;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startColorAnim4(View v)
    {
        int colorStart = fourth.getSolidColor();
        int colorEnd = Color.GREEN;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startColorAnim5(View v)
    {
        int colorStart = fifth.getSolidColor();
        int colorEnd = Color.GREEN;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startColorAnim6(View v)
    {
        int colorStart = sixth.getSolidColor();
        int colorEnd = Color.GREEN;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }

    @SuppressLint("RestrictedApi")
    public void startFailAnim1(View v)
    {
        int colorStart = first.getSolidColor();
        int colorEnd = Color.RED;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startFailAnim2(View v)
    {
        int colorStart = second.getSolidColor();
        int colorEnd = Color.RED;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startFailAnim3(View v)
    {
        int colorStart = third.getSolidColor();
        int colorEnd = Color.RED;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startFailAnim4(View v)
    {
        int colorStart = fourth.getSolidColor();
        int colorEnd = Color.RED;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startFailAnim5(View v)
    {
        int colorStart = fifth.getSolidColor();
        int colorEnd = Color.RED;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
    @SuppressLint("RestrictedApi")
    public void startFailAnim6(View v)
    {
        int colorStart = sixth.getSolidColor();
        int colorEnd = Color.RED;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        colorAnim.setDuration(350);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(1);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }


    public int pontLevon(int pontlevonas)
    {
        return pontlevonas+1;
    }

    public int pontHozzaad(int pont)
    {
        int pontnovel = pont +1;
        return pontnovel;
    }

    public String general()
    {
        String[] tobbigenereal = {"a","i","u","e","o","ka","ki","ku","ke","ko","sa","shi","su","se","so","ta","chi","tsu","te","to","na","ni","nu","ne","no","ha","hi","hu","he","ho","ma","mi","mu","me","mo","ya","yu","yo","ra","ri","ru","re","ro","wa","wo","n"};
        int min = 1;
        int max = 46;
        Random r = new Random();
        int random = r.nextInt(max-min+1) + min;
        String melyiksazm = Integer.toString(random);
        String megoldas = null;
        //int random = random();

        //beginnertv.setText(melyiksazm);

        /*fourth.setBackgroundColor(Color.parseColor("F0B3B3B3"));
        fifth.setBackgroundColor(Color.parseColor("F0B3B3B3"));
        sixth.setBackgroundColor(Color.parseColor("F0B3B3B3"));*/


        int elhelyez = randomelhelyez();
        //String toltelek = toltelek();

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
        }
        else if(random == 4) {
            mediumimg.setImageResource(R.drawable.qe);
            megoldas = "e";
        }
        else if(random == 5) {
            mediumimg.setImageResource(R.drawable.qo);
            megoldas = "o";
        }
        else if(random == 6) {
            mediumimg.setImageResource(R.drawable.qka);
            megoldas = "ka";
        }
        else if(random == 7) {
            mediumimg.setImageResource(R.drawable.qki);
            megoldas = "ki";
        }
        else if(random == 8) {
            mediumimg.setImageResource(R.drawable.qku);
            megoldas = "ku";
        }
        else if(random == 9) {
            mediumimg.setImageResource(R.drawable.qke);
            megoldas = "ke";
        }
        else if(random == 10) {
            mediumimg.setImageResource(R.drawable.qko);
            megoldas = "ko";
        }
        else if(random == 11) {
            mediumimg.setImageResource(R.drawable.qsa);
            megoldas = "sa";
        }
        else if(random == 12) {
            mediumimg.setImageResource(R.drawable.qshi);
            megoldas = "shi";
        }
        else if(random == 13) {
            mediumimg.setImageResource(R.drawable.qsu);
            megoldas = "su";
        }
        else if(random == 14) {
            mediumimg.setImageResource(R.drawable.qse);
            megoldas = "se";
        }
        else if(random == 15) {
            mediumimg.setImageResource(R.drawable.qso);
            megoldas = "so";
        }
        else if(random == 16) {
            mediumimg.setImageResource(R.drawable.qta);
            megoldas = "ta";
        }
        else if(random == 17) {
            mediumimg.setImageResource(R.drawable.qchi);
            megoldas = "chi";
        }
        else if(random == 18) {
            mediumimg.setImageResource(R.drawable.qtsu);
            megoldas = "tsu";
        }
        else if(random == 19) {
            mediumimg.setImageResource(R.drawable.qte);
            megoldas = "te";
        }
        else if(random == 20) {
            mediumimg.setImageResource(R.drawable.qto);
            megoldas = "to";
        }
        else if(random == 21) {
            mediumimg.setImageResource(R.drawable.qna);
            megoldas = "na";
        }
        else if(random == 22) {
            mediumimg.setImageResource(R.drawable.qni);
            megoldas = "ni";
        }
        else if(random == 23) {
            mediumimg.setImageResource(R.drawable.qnu);
            megoldas = "nu";
        }
        else if(random == 24) {
            mediumimg.setImageResource(R.drawable.qne);
            megoldas = "ne";
        }
        else if(random == 25) {
            mediumimg.setImageResource(R.drawable.qno);
            megoldas = "no";
        }
        else if(random == 26) {
            mediumimg.setImageResource(R.drawable.qha);
            megoldas = "ha";
        }
        else if(random == 27) {
            mediumimg.setImageResource(R.drawable.qhi);
            megoldas = "hi";
        }
        else if(random == 28) {
            mediumimg.setImageResource(R.drawable.qfu);
            megoldas = "hu";
        }
        else if(random == 29) {
            mediumimg.setImageResource(R.drawable.qhe);
            megoldas = "he";
        }
        else if(random == 30) {
            mediumimg.setImageResource(R.drawable.qho);
            megoldas = "ho";
        }
        else if(random == 31) {
            mediumimg.setImageResource(R.drawable.qma);
            megoldas = "ma";
        }
        else if(random == 32) {
            mediumimg.setImageResource(R.drawable.qmi);
            megoldas = "mi";
        }
        else if(random == 33) {
            mediumimg.setImageResource(R.drawable.qmu);
            megoldas = "mu";
        }
        else if(random == 34) {
            mediumimg.setImageResource(R.drawable.qme);
            megoldas = "me";
        }
        else if(random == 35) {
            mediumimg.setImageResource(R.drawable.qmo);
            megoldas = "mo";
        }
        else if(random == 36) {
            mediumimg.setImageResource(R.drawable.qya);
            megoldas = "ya";
        }
        else if(random == 37) {
            mediumimg.setImageResource(R.drawable.qyu);
            megoldas = "yu";
        }
        else if(random == 38) {
            mediumimg.setImageResource(R.drawable.qyo);
            megoldas = "yo";
        }
        else if(random == 39) {
            mediumimg.setImageResource(R.drawable.qra);
            megoldas = "ra";
        }
        else if(random == 40) {
            mediumimg.setImageResource(R.drawable.qri);
            megoldas = "ri";
        }
        else if(random == 41) {
            mediumimg.setImageResource(R.drawable.qru);
            megoldas = "ru";
        }
        else if(random == 42) {
            mediumimg.setImageResource(R.drawable.qre);
            megoldas = "re";
        }
        else if(random == 43) {
            mediumimg.setImageResource(R.drawable.qro);
            megoldas = "ro";
        }
        else if(random == 44) {
            mediumimg.setImageResource(R.drawable.qwa);
            megoldas = "wa";
        }
        else if(random == 45) {
            mediumimg.setImageResource(R.drawable.qwo);
            megoldas = "wo";
        }
        else if(random == 46) {
            mediumimg.setImageResource(R.drawable.qn);
            megoldas = "n";
        }


        if(megoldas != null)
        {
            int valasztott1 = r.nextInt(tobbigenereal.length);
            String valsztottneve1 = tobbigenereal[valasztott1];
            while(valsztottneve1.equals(megoldas))
            {
                valasztott1 = r.nextInt(tobbigenereal.length);
                valsztottneve1 = tobbigenereal[valasztott1];
            }

            int valasztott2 = r.nextInt(tobbigenereal.length);
            String valsztottneve2 = tobbigenereal[valasztott2];
            while(valsztottneve2.equals(valsztottneve1))
            {
                valasztott2 = r.nextInt(tobbigenereal.length);
                valsztottneve2 = tobbigenereal[valasztott2];
            }
            while(valsztottneve2.equals(megoldas))
            {
                valasztott2 = r.nextInt(tobbigenereal.length);
                valsztottneve2 = tobbigenereal[valasztott2];
            }

            int valasztott3 = r.nextInt(tobbigenereal.length);
            String valsztottneve3 = tobbigenereal[valasztott3];
            while(valsztottneve3.equals(valsztottneve2))
            {
                valasztott3 = r.nextInt(tobbigenereal.length);
                valsztottneve3 = tobbigenereal[valasztott3];
            }
            while(valsztottneve3.equals(valsztottneve1))
            {
                valasztott3 = r.nextInt(tobbigenereal.length);
                valsztottneve3 = tobbigenereal[valasztott3];
            }
            while(valsztottneve3.equals(megoldas))
            {
                valasztott3 = r.nextInt(tobbigenereal.length);
                valsztottneve3 = tobbigenereal[valasztott3];
            }

            int valasztott4 = r.nextInt(tobbigenereal.length);
            String valsztottneve4 = tobbigenereal[valasztott4];
            while(valsztottneve4.equals(valsztottneve3))
            {
                valasztott4 = r.nextInt(tobbigenereal.length);
                valsztottneve4 = tobbigenereal[valasztott4];
            }
            while(valsztottneve4.equals(valsztottneve2))
            {
                valasztott4 = r.nextInt(tobbigenereal.length);
                valsztottneve4 = tobbigenereal[valasztott4];
            }
            while(valsztottneve4.equals(valsztottneve1))
            {
                valasztott4 = r.nextInt(tobbigenereal.length);
                valsztottneve4 = tobbigenereal[valasztott4];
            }
            while(valsztottneve4.equals(megoldas))
            {
                valasztott4 = r.nextInt(tobbigenereal.length);
                valsztottneve4 = tobbigenereal[valasztott4];
            }

            int valasztott5 = r.nextInt(tobbigenereal.length);
            String valsztottneve5 = tobbigenereal[valasztott5];
            while(valsztottneve5.equals(valsztottneve4))
            {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }
            while(valsztottneve5.equals(valsztottneve3))
            {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }
            while(valsztottneve5.equals(valsztottneve2))
            {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }
            while(valsztottneve5.equals(valsztottneve1))
            {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }
            while(valsztottneve5.equals(megoldas))
            {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }

            //if(!megoldas.equals(valsztottneve1) && !megoldas.equals(valsztottneve2) && !megoldas.equals(valsztottneve3) && !megoldas.equals(valsztottneve4) && !megoldas.equals(valsztottneve5)) {
                if (elhelyez == 0) {
                    first.setText(megoldas);
                    second.setText(valsztottneve1);
                    third.setText(valsztottneve2);
                    fourth.setText(valsztottneve3);
                    fifth.setText(valsztottneve4);
                    sixth.setText(valsztottneve5);
                } else if (elhelyez == 1) {
                    second.setText(megoldas);
                    first.setText(valsztottneve1);
                    third.setText(valsztottneve2);
                    fourth.setText(valsztottneve3);
                    fifth.setText(valsztottneve4);
                    sixth.setText(valsztottneve5);
                } else if (elhelyez == 2) {
                    third.setText(megoldas);
                    first.setText(valsztottneve1);
                    second.setText(valsztottneve2);
                    fourth.setText(valsztottneve3);
                    fifth.setText(valsztottneve4);
                    sixth.setText(valsztottneve5);
                } else if (elhelyez == 3) {
                    fourth.setText(megoldas);
                    first.setText(valsztottneve1);
                    second.setText(valsztottneve2);
                    third.setText(valsztottneve3);
                    fifth.setText(valsztottneve4);
                    sixth.setText(valsztottneve5);
                } else if (elhelyez == 4) {
                    fifth.setText(megoldas);
                    first.setText(valsztottneve1);
                    second.setText(valsztottneve2);
                    third.setText(valsztottneve3);
                    fourth.setText(valsztottneve4);
                    sixth.setText(valsztottneve5);
                } else if (elhelyez == 5) {
                    sixth.setText(megoldas);
                    first.setText(valsztottneve1);
                    second.setText(valsztottneve2);
                    third.setText(valsztottneve3);
                    fourth.setText(valsztottneve4);
                    fifth.setText(valsztottneve5);
                }
            //}
            else
            {
                beginnertv.setText("no");
                first.setText(megoldas);
                second.setText(valsztottneve1);
                third.setText(valsztottneve2);
                fourth.setText(valsztottneve3);
                fifth.setText(valsztottneve4);
                sixth.setText(valsztottneve5);
            }
        }

        return megoldas;
    }

    /*public String toltelek()
    {

        return tobbigenereal[valasztott];
    }*/

    public int random()
    {
        int min = 2;
        int max = 4;
        Random r = new Random();
        int generalt = r.nextInt(max-min) + min;
        return generalt;
    }

    public int randomelhelyez()
    {
        int min = 0;
        int max = 6;
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
        beginnertv = findViewById(R.id.beginnertv);

        timer = findViewById(R.id.timer);
    }

    @Override
    public void onBackPressed() {
        stopTimer();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Would you like to exit this test?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Medium.this.finish();
                        CustomIntent.customType(Medium.this,"fadein-to-fadeout");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        startTimer();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    public void onRestart() {
        super.onRestart();
        startTimer();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopTimer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.pause)
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Paused. Are you ready to continue?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            startTimer();
                        }
                    })
                    .setNegativeButton("No, I want to exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Medium.this.finish();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        startStop();

        return true;
    }

    public void timeReset()
    {
        timeLeftInMilliseconds = timeRestartInMilliseconds;
    }

    public void startStop()
    {
        if(timerRunning)
        {
            stopTimer();
        }
        else
        {
            startTimer();
        }
    }

    public void startTimer()
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Medium.this, EndingFail.class);
                startActivity(intent);
                finish();
            }
        }.start();
        timerRunning = true;
    }

    public void stopTimer()
    {
        countDownTimer.cancel();
        timerRunning = false;

        /**/
        /*MenuItem menuStart = menu.findItem(R.id.pause);
        menuStart.setIcon(R.drawable.ic_play_arrow);*/
    }

    public void updateTimer()
    {
        int seconds = (int) timeLeftInMilliseconds / 1000;

        String timeLeftText;
        timeLeftText = "" + seconds;

        timer.setText(timeLeftText);
    }
}
