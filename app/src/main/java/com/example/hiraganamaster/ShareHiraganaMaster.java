package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hiraganamaster.ui.sharehiraganamaster.ShareHiraganaMasterFragment;

public class ShareHiraganaMaster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_hiragana_master_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ShareHiraganaMasterFragment.newInstance())
                    .commitNow();
        }
    }
}
