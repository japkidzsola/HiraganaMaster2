package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hiraganamaster.ui.hiraganalearn.HiraganaLearnFragment;

import java.util.ArrayList;

public class HiraganaLearn extends AppCompatActivity {

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

    }
}
