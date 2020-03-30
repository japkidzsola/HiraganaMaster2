package com.example.hiraganamaster;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maes.tech.intentanim.CustomIntent;

public class Beginner extends AppCompatActivity {

    public Button first, second,third, fourth;
    public ImageView beginnerimg;
    public TextView beginnertv, points, pointsneeded;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 1000;
    private boolean timerRunning;

    List<String> randomHiragana, voltmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
        init();

        final String[] megold = {general()};
        String ertek = getIntent().getExtras().getString("Value");
        pointsneeded.setText(ertek);
        final int seged = 0;

        //general();
        final int[] pontok = {0};
        final int[] minuszpontok = {0};

        int place = randomplace();



        if(points.getText().toString().equals(pointsneeded.getText().toString()))
        {
            Intent intent = new Intent(Beginner.this, Ending.class);
            startActivity(intent);
            finish();
        }

        final String tryagain = getString(R.string.tryagain);
        //final String finalMegoldas = megold;
        if(megold[0] != null) {
            //final String finalMegoldas = megold;
            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megold[0].equals(first.getText().toString().toLowerCase())) {
                        startAnim();
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            Intent intent = new Intent(Beginner.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            megold[0] = general();
                        }
                    } else {
                        Toast.makeText(Beginner.this, tryagain, Toast.LENGTH_SHORT).show();
                        startFailAnim();
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                    }
                }
            });
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megold[0].equals(second.getText().toString().toLowerCase())) {
                        startAnim();
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            Intent intent = new Intent(Beginner.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            megold[0] = general();
                        }
                    } else {
                        Toast.makeText(Beginner.this, tryagain, Toast.LENGTH_SHORT).show();
                        startFailAnim();
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                    }
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megold[0].equals(third.getText().toString().toLowerCase())) {
                        startAnim();
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            Intent intent = new Intent(Beginner.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            megold[0] = general();
                        }
                    } else {
                        Toast.makeText(Beginner.this, tryagain, Toast.LENGTH_SHORT).show();
                        startFailAnim();
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                    }
                }
            });
            fourth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megold[0].equals(fourth.getText().toString().toLowerCase())) {
                        startAnim();
                        String seged = Integer.toString(pontHozzaad(pontok[0]));
                        pontok[0] = pontHozzaad(pontok[0]);
                        points.setText(seged);
                        if(points.getText().toString().equals(pointsneeded.getText().toString()))
                        {
                            Intent intent = new Intent(Beginner.this, Ending.class);
                            String tovabbit = pointsneeded.getText().toString();
                            String minusztovabbit = Integer.toString(minuszpontok[0]);
                            String e = pointsneeded.getText().toString();
                            intent.putExtra("Success",tovabbit);
                            intent.putExtra("Unsuccess",minusztovabbit);
                            intent.putExtra("Value",e);
                            startActivity(intent);
                            finish();
                        }else {
                            megold[0] = general();
                        }
                    } else {
                        Toast.makeText(Beginner.this, tryagain, Toast.LENGTH_SHORT).show();
                        startFailAnim();
                        pontHozzaad(minuszpontok[0]);
                        minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                    }
                }
            });
        }

    }

    public String general()
    {
        String[] tobbigenereal = {"a","i","u","e","o","ka","ki","ku","ke","ko","sa","shi","su","se","so","ta","chi","tsu","te","to","na","ni","nu","ne","no","ha","hi","hu","he","ho","ma","mi","mu","me","mo","ya","yu","yo","ra","ri","ru","re","ro","wa","wo","n"};
        int min = 1;
        int max = 46;
        Random r = new Random();
        int random = r.nextInt(max-min+1) + min;
        String megoldas = null;

        int elhelyez = randomelhelyez();

        if(random == 1) {
            beginnerimg.setImageResource(R.drawable.qa);
            megoldas = "a";
        }
        else if(random == 2) {
            beginnerimg.setImageResource(R.drawable.qi);
            megoldas = "i";
        }
        else if(random == 3) {
            beginnerimg.setImageResource(R.drawable.qu);
            megoldas = "u";
        }
        else if(random == 4) {
            beginnerimg.setImageResource(R.drawable.qe);
            megoldas = "e";
        }
        else if(random == 5) {
            beginnerimg.setImageResource(R.drawable.qo);
            megoldas = "o";
        }
        else if(random == 6) {
            beginnerimg.setImageResource(R.drawable.qka);
            megoldas = "ka";
        }
        else if(random == 7) {
            beginnerimg.setImageResource(R.drawable.qki);
            megoldas = "ki";
        }
        else if(random == 8) {
            beginnerimg.setImageResource(R.drawable.qku);
            megoldas = "ku";
        }
        else if(random == 9) {
            beginnerimg.setImageResource(R.drawable.qke);
            megoldas = "ke";
        }
        else if(random == 10) {
            beginnerimg.setImageResource(R.drawable.qko);
            megoldas = "ko";
        }
        else if(random == 11) {
            beginnerimg.setImageResource(R.drawable.qsa);
            megoldas = "sa";
        }
        else if(random == 12) {
            beginnerimg.setImageResource(R.drawable.qshi);
            megoldas = "shi";
        }
        else if(random == 13) {
            beginnerimg.setImageResource(R.drawable.qsu);
            megoldas = "su";
        }
        else if(random == 14) {
            beginnerimg.setImageResource(R.drawable.qse);
            megoldas = "se";
        }
        else if(random == 15) {
            beginnerimg.setImageResource(R.drawable.qso);
            megoldas = "so";
        }
        else if(random == 16) {
            beginnerimg.setImageResource(R.drawable.qta);
            megoldas = "ta";
        }
        else if(random == 17) {
            beginnerimg.setImageResource(R.drawable.qchi);
            megoldas = "chi";
        }
        else if(random == 18) {
            beginnerimg.setImageResource(R.drawable.qtsu);
            megoldas = "tsu";
        }
        else if(random == 19) {
            beginnerimg.setImageResource(R.drawable.qte);
            megoldas = "te";
        }
        else if(random == 20) {
            beginnerimg.setImageResource(R.drawable.qto);
            megoldas = "to";
        }
        else if(random == 21) {
            beginnerimg.setImageResource(R.drawable.qna);
            megoldas = "na";
        }
        else if(random == 22) {
            beginnerimg.setImageResource(R.drawable.qni);
            megoldas = "ni";
        }
        else if(random == 23) {
            beginnerimg.setImageResource(R.drawable.qnu);
            megoldas = "nu";
        }
        else if(random == 24) {
            beginnerimg.setImageResource(R.drawable.qne);
            megoldas = "ne";
        }
        else if(random == 25) {
            beginnerimg.setImageResource(R.drawable.qno);
            megoldas = "no";
        }
        else if(random == 26) {
            beginnerimg.setImageResource(R.drawable.qha);
            megoldas = "ha";
        }
        else if(random == 27) {
            beginnerimg.setImageResource(R.drawable.qhi);
            megoldas = "hi";
        }
        else if(random == 28) {
            beginnerimg.setImageResource(R.drawable.qfu);
            megoldas = "hu";
        }
        else if(random == 29) {
            beginnerimg.setImageResource(R.drawable.qhe);
            megoldas = "he";
        }
        else if(random == 30) {
            beginnerimg.setImageResource(R.drawable.qho);
            megoldas = "ho";
        }
        else if(random == 31) {
            beginnerimg.setImageResource(R.drawable.qma);
            megoldas = "ma";
        }
        else if(random == 32) {
            beginnerimg.setImageResource(R.drawable.qmi);
            megoldas = "mi";
        }
        else if(random == 33) {
            beginnerimg.setImageResource(R.drawable.qmu);
            megoldas = "mu";
        }
        else if(random == 34) {
            beginnerimg.setImageResource(R.drawable.qme);
            megoldas = "me";
        }
        else if(random == 35) {
            beginnerimg.setImageResource(R.drawable.qmo);
            megoldas = "mo";
        }
        else if(random == 36) {
            beginnerimg.setImageResource(R.drawable.qya);
            megoldas = "ya";
        }
        else if(random == 37) {
            beginnerimg.setImageResource(R.drawable.qyu);
            megoldas = "yu";
        }
        else if(random == 38) {
            beginnerimg.setImageResource(R.drawable.qyo);
            megoldas = "yo";
        }
        else if(random == 39) {
            beginnerimg.setImageResource(R.drawable.qra);
            megoldas = "ra";
        }
        else if(random == 40) {
            beginnerimg.setImageResource(R.drawable.qri);
            megoldas = "ri";
        }
        else if(random == 41) {
            beginnerimg.setImageResource(R.drawable.qru);
            megoldas = "ru";
        }
        else if(random == 42) {
            beginnerimg.setImageResource(R.drawable.qre);
            megoldas = "re";
        }
        else if(random == 43) {
            beginnerimg.setImageResource(R.drawable.qro);
            megoldas = "ro";
        }
        else if(random == 44) {
            beginnerimg.setImageResource(R.drawable.qwa);
            megoldas = "wa";
        }
        else if(random == 45) {
            beginnerimg.setImageResource(R.drawable.qwo);
            megoldas = "wo";
        }
        else if(random == 46) {
            beginnerimg.setImageResource(R.drawable.qn);
            megoldas = "n";
        }


        if(megoldas != null)
        {
            int valasztott1 = r.nextInt(tobbigenereal.length);
            String valsztottneve1 = tobbigenereal[valasztott1];
            while (valsztottneve1.equals(megoldas)) {
                valasztott1 = r.nextInt(tobbigenereal.length);
                valsztottneve1 = tobbigenereal[valasztott1];
            }

            int valasztott2 = r.nextInt(tobbigenereal.length);
            String valsztottneve2 = tobbigenereal[valasztott2];
            while (valsztottneve2.equals(valsztottneve1)) {
                valasztott2 = r.nextInt(tobbigenereal.length);
                valsztottneve2 = tobbigenereal[valasztott2];
            }
            while (valsztottneve2.equals(megoldas)) {
                valasztott2 = r.nextInt(tobbigenereal.length);
                valsztottneve2 = tobbigenereal[valasztott2];
            }

            int valasztott3 = r.nextInt(tobbigenereal.length);
            String valsztottneve3 = tobbigenereal[valasztott3];
            while (valsztottneve3.equals(valsztottneve2)) {
                valasztott3 = r.nextInt(tobbigenereal.length);
                valsztottneve3 = tobbigenereal[valasztott3];
            }
            while (valsztottneve3.equals(valsztottneve1)) {
                valasztott3 = r.nextInt(tobbigenereal.length);
                valsztottneve3 = tobbigenereal[valasztott3];
            }
            while (valsztottneve3.equals(megoldas)) {
                valasztott3 = r.nextInt(tobbigenereal.length);
                valsztottneve3 = tobbigenereal[valasztott3];
            }

            int valasztott4 = r.nextInt(tobbigenereal.length);
            String valsztottneve4 = tobbigenereal[valasztott4];
            while (valsztottneve4.equals(valsztottneve3)) {
                valasztott4 = r.nextInt(tobbigenereal.length);
                valsztottneve4 = tobbigenereal[valasztott4];
            }
            while (valsztottneve4.equals(valsztottneve2)) {
                valasztott4 = r.nextInt(tobbigenereal.length);
                valsztottneve4 = tobbigenereal[valasztott4];
            }
            while (valsztottneve4.equals(valsztottneve1)) {
                valasztott4 = r.nextInt(tobbigenereal.length);
                valsztottneve4 = tobbigenereal[valasztott4];
            }
            while (valsztottneve4.equals(megoldas)) {
                valasztott4 = r.nextInt(tobbigenereal.length);
                valsztottneve4 = tobbigenereal[valasztott4];
            }

            int valasztott5 = r.nextInt(tobbigenereal.length);
            String valsztottneve5 = tobbigenereal[valasztott5];
            while (valsztottneve5.equals(valsztottneve4)) {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }
            while (valsztottneve5.equals(valsztottneve3)) {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }
            while (valsztottneve5.equals(valsztottneve2)) {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }
            while (valsztottneve5.equals(valsztottneve1)) {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }
            while (valsztottneve5.equals(megoldas)) {
                valasztott5 = r.nextInt(tobbigenereal.length);
                valsztottneve5 = tobbigenereal[valasztott5];
            }

            if (elhelyez == 0) {
                first.setText(megoldas);
                second.setText(valsztottneve1);
                third.setText(valsztottneve2);
                fourth.setText(valsztottneve3);
            } else if (elhelyez == 1) {
                second.setText(megoldas);
                first.setText(valsztottneve1);
                third.setText(valsztottneve2);
                fourth.setText(valsztottneve3);
            } else if (elhelyez == 2) {
                third.setText(megoldas);
                first.setText(valsztottneve1);
                second.setText(valsztottneve2);
                fourth.setText(valsztottneve3);
            } else if (elhelyez == 3) {
                fourth.setText(megoldas);
                first.setText(valsztottneve1);
                second.setText(valsztottneve2);
                third.setText(valsztottneve3);
            } else {
                first.setText(megoldas);
                second.setText(valsztottneve1);
                third.setText(valsztottneve2);
                fourth.setText(valsztottneve3);
            }
        }

        return megoldas;
    }

    private int randomelhelyez() {
        int min = 0;
        int max = 4;
        Random r = new Random();
        int generalt = r.nextInt(max-min) + min;
        return generalt;
    }

    public int pontHozzaad(int pont)
    {
        int pontnovel = pont +1;
        return pontnovel;
    }

    public String randomgenerator()
    {
        int min=0;
        int max=5;

        Random random=new Random();
        int randomnumber=random.nextInt(max-min)+min;
        String rand = Integer.toString(randomnumber);
        return rand;
    }

    public int randomplace()
    {
        int min=1;
        int max=4;

        Random random=new Random();
        int randomnumber=random.nextInt(max-min)+min;
        return randomnumber+min;
    }

    public void init()
    {
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        beginnerimg = findViewById(R.id.begginerimg);
        beginnertv = findViewById(R.id.beginnertv);
        points = findViewById(R.id.points);
        pointsneeded = findViewById(R.id.pointsneeded);
    }

    public void startAnim()
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                RelativeLayout relativeLayout = findViewById(R.id.beginnerrelative);
                relativeLayout.setBackgroundColor(Color.GREEN);
            }

            @Override
            public void onFinish() {
                RelativeLayout relativeLayout = findViewById(R.id.beginnerrelative);
                relativeLayout.setBackgroundColor(Color.WHITE);
            }
        }.start();
        timerRunning = true;
    }
    public void startFailAnim()
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                RelativeLayout relativeLayout = findViewById(R.id.beginnerrelative);
                relativeLayout.setBackgroundColor(Color.RED);
            }

            @Override
            public void onFinish() {
                RelativeLayout relativeLayout = findViewById(R.id.beginnerrelative);
                relativeLayout.setBackgroundColor(Color.WHITE);
            }
        }.start();
        timerRunning = true;
    }
    @Override
    public void onBackPressed() {

        String yes = getString(R.string.yes);
        String no = getString(R.string.no2);
        String exitTest = getString(R.string.exit_test);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(exitTest)
                .setCancelable(false)
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Beginner.this.finish();
                        CustomIntent.customType(Beginner.this,"fadein-to-fadeout");
                    }
                })
                .setNegativeButton(no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
    /*public void onBackPressed()
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
    }*/
}
