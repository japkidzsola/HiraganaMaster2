package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hiraganamaster.ui.hiraganamasterhome.HiraganaMasterHomeFragment;

public class HiraganaMasterHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiragana_master_home_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HiraganaMasterHomeFragment.newInstance())
                    .commitNow();
        }
    }
}
