package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hiraganamaster.ui.hiraganalearn.HiraganaLearnFragment;

public class HiraganaLearn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiragana_learn_activity);
        String betu = getIntent().getStringExtra("betu");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HiraganaLearnFragment.newInstance(betu))
                    .commitNow();
        }
    }
}
