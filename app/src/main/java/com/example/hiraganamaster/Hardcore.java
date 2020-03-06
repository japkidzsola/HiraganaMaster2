package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Hardcore extends AppCompatActivity {

    public Button hardcoresend;
    public EditText hardcoreet;
    public TextView timer,points,pointsneeded, hardcoretv;
    public ImageView hardcoreimg;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 10000;
    private long timeRestartInMilliseconds = 10000;
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardcore);
        init();

        startTimer();

        String ertek = getIntent().getExtras().getString("Valueh");
        pointsneeded.setText(ertek);

        final String[] megoldas = {general()};
        final int[] pontok = {0};
        final int[] minuszpontok = {0};

        hardcoresend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hardcoreet.getText().toString().isEmpty()) {
                    Toast.makeText(Hardcore.this, "Please enter a valid hiragana", Toast.LENGTH_SHORT).show();
                }

                if (megoldas.equals(hardcoreet.getText().toString().toLowerCase())) {
                    Toast.makeText(Hardcore.this, "Good job!", Toast.LENGTH_SHORT).show();
                    String seged = Integer.toString(pontHozzaad(pontok[0]));
                    pontok[0] = pontHozzaad(pontok[0]);
                    points.setText(seged);
                    if (points.getText().toString().equals(pointsneeded.getText().toString())) {
                        stopTimer();
                        Intent intent = new Intent(Hardcore.this, Ending.class);
                        String tovabbit = pointsneeded.getText().toString();
                        String minusztovabbit = Integer.toString(minuszpontok[0]);
                        String e = pointsneeded.getText().toString();
                        intent.putExtra("Success", tovabbit);
                        intent.putExtra("Unsuccess", minusztovabbit);
                        intent.putExtra("Value", e);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Hardcore.this, "That's not it", Toast.LENGTH_SHORT).show();
                        megoldas[0] = general();
                        stopTimer();
                        timeReset();
                        startTimer();
                    }
                } else {
                    Toast.makeText(Hardcore.this, "That's not the correct answer", Toast.LENGTH_SHORT).show();
                    pontHozzaad(minuszpontok[0]);
                    minuszpontok[0] = pontHozzaad(minuszpontok[0]);
                    String seged = Integer.toString(minuszpontok[0]);
                    hardcoretv.setText(seged);
                    if (minuszpontok[0] == 3) {
                        stopTimer();
                        Intent intent = new Intent(Hardcore.this, EndingFail.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    public void init()
    {
        hardcoresend = findViewById(R.id.hardcoresend);
        hardcoreet = findViewById(R.id.hardcoreet);
        timer = findViewById(R.id.timer);
        points = findViewById(R.id.hardcorepoints);
        pointsneeded = findViewById(R.id.hardcorepointsneeded);
        hardcoreimg = findViewById(R.id.hardcoreimg);
        hardcoretv = findViewById(R.id.hardcoretv);
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
                Intent intent = new Intent(Hardcore.this, EndingFail.class);
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

    public String general()
    {
        int min = 1;
        int max = 46;
        Random r = new Random();
        int random = r.nextInt(max-min+1) + min;
        String megoldas = null;
        if(random == 1) {
            hardcoreimg.setImageResource(R.drawable.qa);
            megoldas = "a";
        }
        else if(random == 2) {
            hardcoreimg.setImageResource(R.drawable.qi);
            megoldas = "i";
        }
        else if(random == 3) {
            hardcoreimg.setImageResource(R.drawable.qu);
            megoldas = "u";
        }
        else if(random == 4) {
            hardcoreimg.setImageResource(R.drawable.qe);
            megoldas = "e";
        }
        else if(random == 5) {
            hardcoreimg.setImageResource(R.drawable.qo);
            megoldas = "o";
        }
        else if(random == 6) {
            hardcoreimg.setImageResource(R.drawable.qka);
            megoldas = "ka";
        }
        else if(random == 7) {
            hardcoreimg.setImageResource(R.drawable.qki);
            megoldas = "ki";
        }
        else if(random == 8) {
            hardcoreimg.setImageResource(R.drawable.qku);
            megoldas = "ku";
        }
        else if(random == 9) {
            hardcoreimg.setImageResource(R.drawable.qke);
            megoldas = "ke";
        }
        else if(random == 10) {
            hardcoreimg.setImageResource(R.drawable.qko);
            megoldas = "ko";
        }
        else if(random == 11) {
            hardcoreimg.setImageResource(R.drawable.qsa);
            megoldas = "sa";
        }
        else if(random == 12) {
            hardcoreimg.setImageResource(R.drawable.qshi);
            megoldas = "shi";
        }
        else if(random == 13) {
            hardcoreimg.setImageResource(R.drawable.qsu);
            megoldas = "su";
        }
        else if(random == 14) {
            hardcoreimg.setImageResource(R.drawable.qse);
            megoldas = "se";
        }
        else if(random == 15) {
            hardcoreimg.setImageResource(R.drawable.qso);
            megoldas = "so";
        }
        else if(random == 16) {
            hardcoreimg.setImageResource(R.drawable.qta);
            megoldas = "ta";
        }
        else if(random == 17) {
            hardcoreimg.setImageResource(R.drawable.qchi);
            megoldas = "chi";
        }
        else if(random == 18) {
            hardcoreimg.setImageResource(R.drawable.qtsu);
            megoldas = "tsu";
        }
        else if(random == 19) {
            hardcoreimg.setImageResource(R.drawable.qte);
            megoldas = "te";
        }
        else if(random == 20) {
            hardcoreimg.setImageResource(R.drawable.qto);
            megoldas = "to";
        }
        else if(random == 21) {
            hardcoreimg.setImageResource(R.drawable.qna);
            megoldas = "na";
        }
        else if(random == 22) {
            hardcoreimg.setImageResource(R.drawable.qni);
            megoldas = "ni";
        }
        else if(random == 23) {
            hardcoreimg.setImageResource(R.drawable.qnu);
            megoldas = "nu";
        }
        else if(random == 24) {
            hardcoreimg.setImageResource(R.drawable.qne);
            megoldas = "ne";
        }
        else if(random == 25) {
            hardcoreimg.setImageResource(R.drawable.qno);
            megoldas = "no";
        }
        else if(random == 26) {
            hardcoreimg.setImageResource(R.drawable.qha);
            megoldas = "ha";
        }
        else if(random == 27) {
            hardcoreimg.setImageResource(R.drawable.qhi);
            megoldas = "hi";
        }
        else if(random == 28) {
            hardcoreimg.setImageResource(R.drawable.qfu);
            megoldas = "hu";
        }
        else if(random == 29) {
            hardcoreimg.setImageResource(R.drawable.qhe);
            megoldas = "he";
        }
        else if(random == 30) {
            hardcoreimg.setImageResource(R.drawable.qho);
            megoldas = "ho";
        }
        else if(random == 31) {
            hardcoreimg.setImageResource(R.drawable.qma);
            megoldas = "ma";
        }
        else if(random == 32) {
            hardcoreimg.setImageResource(R.drawable.qmi);
            megoldas = "mi";
        }
        else if(random == 33) {
            hardcoreimg.setImageResource(R.drawable.qmu);
            megoldas = "mu";
        }
        else if(random == 34) {
            hardcoreimg.setImageResource(R.drawable.qme);
            megoldas = "me";
        }
        else if(random == 35) {
            hardcoreimg.setImageResource(R.drawable.qmo);
            megoldas = "mo";
        }
        else if(random == 36) {
            hardcoreimg.setImageResource(R.drawable.qya);
            megoldas = "ya";
        }
        else if(random == 37) {
            hardcoreimg.setImageResource(R.drawable.qyu);
            megoldas = "yu";
        }
        else if(random == 38) {
            hardcoreimg.setImageResource(R.drawable.qyo);
            megoldas = "yo";
        }
        else if(random == 39) {
            hardcoreimg.setImageResource(R.drawable.qra);
            megoldas = "ra";
        }
        else if(random == 40) {
            hardcoreimg.setImageResource(R.drawable.qri);
            megoldas = "ri";
        }
        else if(random == 41) {
            hardcoreimg.setImageResource(R.drawable.qru);
            megoldas = "ru";
        }
        else if(random == 42) {
            hardcoreimg.setImageResource(R.drawable.qre);
            megoldas = "re";
        }
        else if(random == 43) {
            hardcoreimg.setImageResource(R.drawable.qro);
            megoldas = "ro";
        }
        else if(random == 44) {
            hardcoreimg.setImageResource(R.drawable.qwa);
            megoldas = "wa";
        }
        else if(random == 45) {
            hardcoreimg.setImageResource(R.drawable.qwo);
            megoldas = "wo";
        }
        else if(random == 46) {
            hardcoreimg.setImageResource(R.drawable.qn);
            megoldas = "n";
        }

        return megoldas;
    }

    public int pontHozzaad(int pont)
    {
        int pontnovel = pont +1;
        return pontnovel;
    }
}
