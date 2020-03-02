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
    public TextView beginnertv, points, pointsneeded;

    List<String> randomHiragana, voltmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
        init();

        final String megold = general();

        final int seged = 0;

        //randomHiragana = new ArrayList<>();

     /*   randomHiragana.add("A");
        randomHiragana.add("I");
        randomHiragana.add("U");
        randomHiragana.add("E");
        randomHiragana.add("O");*/
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

        /*for (int i = 0; i < randomHiragana.size(); i++) {
            pointsneeded.setText("végigment");
        }

        int k = randomHiragana.size();
        String po = Integer.toString(k);
        points.setText(po);

        if (randomHiragana.isEmpty())
        {
            pointsneeded.setText("ez üres gecc");
        }*/

        //general();
        elhelyez();

        int place = randomplace();

        if(megold != null)
        {
            //beginnertv.setText(megold);
        }

        String randomgene = randomgenerator();

        //pointsneeded.setText(randomgene);


       /* if(megold != null)
        {
            if (place == 1) {
                first.setText(megold);
            } else if (place == 2) {
                second.setText(megold);
            } else if (place == 3) {
                third.setText(megold);
            } else if (place == 4) {
                fourth.setText(megold);
            }
        }
        else
        {
            Toast.makeText(this, "nem tudom elhelyezni", Toast.LENGTH_SHORT).show();
        }*/

        /*for (String t: randomHiragana)
        {
            if(t.equals(randoms))
            {
                beginnertv.setText("no luck");
                beginnerimg.setImageResource(R.drawable.qn);
            }
            beginnertv.setText("it is possible");
        }*/

        if(points.getText().toString().equals(pointsneeded.getText().toString()))
        {
            Intent intent = new Intent(Beginner.this, Ending.class);
            startActivity(intent);
            finish();
        }

        //final String finalMegoldas = megold;
        if(megold != null) {
            //final String finalMegoldas = megold;
            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //randomgenerator();
                    //beginnertv.setText(randomgenerator());
                    //beginnertv.setText(kiir);
                    if (megold.equals(first.getText().toString().toLowerCase())) {
                        Toast.makeText(Beginner.this, "Good job", Toast.LENGTH_SHORT).show();
                        general();
                        elhelyez();
                        String pont = points.getText().toString();
                        int pont1 = Integer.parseInt(pont);
                        points.setText(pont1+1);
                    } else {
                        Toast.makeText(Beginner.this, "Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megold.equals(second.getText().toString().toLowerCase())) {
                        Toast.makeText(Beginner.this, "Good job", Toast.LENGTH_SHORT).show();
                        general();
                        elhelyez();
                        String pont = points.getText().toString();
                        int pont1 = Integer.parseInt(pont);
                        points.setText(pont1+1);
                    } else {
                        Toast.makeText(Beginner.this, "Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megold.equals(third.getText().toString().toLowerCase())) {
                        Toast.makeText(Beginner.this, "Good job", Toast.LENGTH_SHORT).show();
                        general();
                        elhelyez();
                        String pont = points.getText().toString();
                        int pont1 = Integer.parseInt(pont);
                        points.setText(pont1+1);
                    } else {
                        Toast.makeText(Beginner.this, "Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            fourth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (megold.equals(fourth.getText().toString().toLowerCase())) {
                        Toast.makeText(Beginner.this, "Good job", Toast.LENGTH_SHORT).show();
                        general();
                        elhelyez();
                        String pont = points.getText().toString();
                        int pont1 = Integer.parseInt(pont);
                        points.setText(pont1+1);
                    } else {
                        Toast.makeText(Beginner.this, "Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    public String general()
    {


        randomHiragana = new ArrayList<>();
        voltmar = new ArrayList<>();


        //voltmar = new ArrayList<>();

        randomHiragana.add("a");
        randomHiragana.add("i");
        randomHiragana.add("u");
        randomHiragana.add("e");
        randomHiragana.add("o");
        String megoldas = null;
        int randoms = Integer.parseInt(randomgenerator());
        final String kiir = Integer.toString(randoms);
        beginnertv.setText(kiir);

        for (int i = 0; i < randomHiragana.size(); i++)
        {
            if(i == randoms)
            {

                if (randoms == 1) {
                    beginnerimg.setImageResource(R.drawable.qa);
                    megoldas = "a";
                    //voltmar.add("a");
                } else if (randoms == 2) {
                    beginnerimg.setImageResource(R.drawable.qi);
                    megoldas = "i";
                    //voltmar.add("i");
                } else if (randoms == 3) {
                    beginnerimg.setImageResource(R.drawable.qu);
                    megoldas = "u";
                    //voltmar.add("u");
                } else if (randoms == 4) {
                    beginnerimg.setImageResource(R.drawable.qe);
                    megoldas = "e";
                    //voltmar.add("e");
                } else if (randoms == 5) {
                    beginnerimg.setImageResource(R.drawable.qo);
                    megoldas = "o";
                    //voltmar.add("o");
                }
                else{ beginnertv.setText("not these");
                    megoldas = null;}
            }
        }
        return megoldas;
    }

    public void elhelyez()
    {
        String megold = general();
        int place = randomplace();

        if(megold != null)
        {
            if (place == 1) {
                first.setText(megold);
            } else if (place == 2) {
                second.setText(megold);
            } else if (place == 3) {
                third.setText(megold);
            } else if (place == 4) {
                fourth.setText(megold);
            }
        }
        else
        {
            Toast.makeText(this, "nem tudom elhelyezni", Toast.LENGTH_SHORT).show();
        }
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
