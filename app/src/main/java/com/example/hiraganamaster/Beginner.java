package com.example.hiraganamaster;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Beginner extends AppCompatActivity {

    public Button first, second,third, fourth;
    public ImageView beginnerimg;
    public TextView beginnertv;

    List<String> randomHiragana, voltmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
        init();

        String megold = general();

        final int seged = 0;

        randomHiragana = new ArrayList<>();
        voltmar = new ArrayList<>();

        randomHiragana.add("a");
        randomHiragana.add("i");
        randomHiragana.add("u");
        randomHiragana.add("e");
        randomHiragana.add("o");
      /*   randomHiragana.add("ka");
        randomHiragana.add("ki");
        randomHiragana.add("ku");
        randomHiragana.add("ke");
        randomHiragana.add("ko");
        randomHiragana.add("sa");
        randomHiragana.add("shi");
        randomHiragana.add("su");
        randomHiragana.add("se");
        randomHiragana.add("so");
        randomHiragana.add("ta");
        randomHiragana.add("chi");
        randomHiragana.add("tsu");
        randomHiragana.add("te");
        randomHiragana.add("to");*/
        int i = 0;
        while(i > 6) {
            general();
            i++;
        }

        final int[] success = {0};
        if (success[0] > 1)
        {
            Intent intent = new Intent(Beginner.this, Login.class);
            startActivity(intent);
        }

        /*for (String t: randomHiragana)
        {
            if(t.equals(randoms))
            {
                beginnertv.setText("no luck nigga");
                beginnerimg.setImageResource(R.drawable.qn);
            }
            beginnertv.setText("it is possible");
        }*/

        final String finalMegoldas = megold;
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //randomgenerator();
                //beginnertv.setText(randomgenerator());
                //beginnertv.setText(kiir);
                if (finalMegoldas.equals(first.getText().toString())) {
                    Toast.makeText(Beginner.this, "Good job nigga", Toast.LENGTH_SHORT).show();
                    success[0] = success[0] +1;
                    general();
                } else {
                    Toast.makeText(Beginner.this, "Try again nigga", Toast.LENGTH_SHORT).show();
                }
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalMegoldas.equals(second.getText().toString())) {
                    Toast.makeText(Beginner.this, "Good job nigga", Toast.LENGTH_SHORT).show();
                    success[0] = success[0]+1;
                    general();
                } else {
                    Toast.makeText(Beginner.this, "Try again nigga", Toast.LENGTH_SHORT).show();
                }
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalMegoldas.equals(third.getText().toString())) {
                    Toast.makeText(Beginner.this, "Good job nigga", Toast.LENGTH_SHORT).show();
                    general();
                } else {
                    Toast.makeText(Beginner.this, "Try again nigga", Toast.LENGTH_SHORT).show();
                }
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalMegoldas.equals(fourth.getText().toString())) {
                    Toast.makeText(Beginner.this, "Good job nigga", Toast.LENGTH_SHORT).show();
                    general();
                } else {
                    Toast.makeText(Beginner.this, "Try again nigga", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public String general()
    {
        String megoldas = null;
        int randoms = Integer.parseInt(randomgenerator());
        final String kiir = Integer.toString(randoms);
        final int place = randomplace();
        //for (int j = 0; j < 6; j++)
        for (int i = 0; i < 6; i++)
        {
            if(i == randoms)
            {
                beginnertv.setText(kiir);
                if (i == 0) {
                    beginnerimg.setImageResource(R.drawable.qa);
                    megoldas = "a";
                    //voltmar.add("a");
                    if (place == 1) {
                        first.setText("a");
                    } else if (place == 2) {
                        second.setText("a");
                    } else if (place == 3) {
                        third.setText("a");
                    } else if (place == 4) {
                        fourth.setText("a");
                    }
                } else if (i == 1) {
                    beginnerimg.setImageResource(R.drawable.qi);
                    megoldas = "i";
                    //voltmar.add("i");
                    if (place == 1) {
                        first.setText("i");
                    } else if (place == 2) {
                        second.setText("i");
                    } else if (place == 3) {
                        third.setText("i");
                    } else if (place == 4) {
                        fourth.setText("i");
                    }
                } else if (i == 2) {
                    beginnerimg.setImageResource(R.drawable.qu);
                    megoldas = "u";
                    //voltmar.add("u");
                    if (place == 1) {
                        first.setText("u");
                    } else if (place == 2) {
                        second.setText("u");
                    } else if (place == 3) {
                        third.setText("u");
                    } else if (place == 4) {
                        fourth.setText("u");
                    }
                } else if (i == 3) {
                    beginnerimg.setImageResource(R.drawable.qe);
                    megoldas = "e";
                    //voltmar.add("e");
                    if (place == 1) {
                        first.setText("e");
                    } else if (place == 2) {
                        second.setText("e");
                    } else if (place == 3) {
                        third.setText("e");
                    } else if (place == 4) {
                        fourth.setText("e");
                    }
                } else if (i == 4) {
                    beginnerimg.setImageResource(R.drawable.qo);
                    megoldas = "o";
                    //voltmar.add("o");
                    if (place == 1) {
                        first.setText("o");
                    } else if (place == 2) {
                        second.setText("o");
                    } else if (place == 3) {
                        third.setText("o");
                    } else if (place == 4) {
                        fourth.setText("o");
                    }
                }
                else{ beginnertv.setText("not these nigga");
                megoldas = null;}


            }/*else {
            beginnertv.setText("it is not possible");}*/
        }
        return megoldas;
    }

    public String randomgenerator()
    {
        int min=0;
        int max=6;

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
