package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hiraganamaster.ui.hiraganalearn.HiraganaLearnFragment;

import java.util.ArrayList;

public class HiraganaLearn extends AppCompatActivity {

    private final AdatbazisSegito dbhelper = new AdatbazisSegito(this);
    ArrayList<String> regikedvencek = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiragana_learn_activity);
        String betu = getIntent().getStringExtra("betu");
        String balra = getIntent().getStringExtra("balra");
        String jobbra = getIntent().getStringExtra("jobbra");
        String adatb = regikedvencek.toString();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HiraganaLearnFragment.newInstance(betu, balra, jobbra,adatb))
                    .commitNow();
        }

        Cursor cursorAdatok = dbhelper.adatLekerdezes();
        if (cursorAdatok == null){
            Toast.makeText(this,
                    "Sikertlen Adatlekérdezés", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cursorAdatok.getCount() == 0){
            Toast.makeText(this,
                    "Nincs még felvéve adat", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (cursorAdatok.moveToNext()){
            stringBuffer.append(cursorAdatok.getString(4));
        }
        String adatbaziskedvenc = stringBuffer.toString();

        String[] sor = adatbaziskedvenc.split(",");
        String kedvenc = sor[0];
        regikedvencek.add(kedvenc);
        Toast.makeText(this, "sikeres", Toast.LENGTH_SHORT).show();
    }
}
