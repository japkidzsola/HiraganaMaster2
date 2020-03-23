package com.example.hiraganamaster;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiraganamaster.ui.test.TestFragment;

import java.util.Objects;

public class Ending extends AppCompatActivity {

    Button redobeginner,redomedium,redohardcore, changehiraganaamount;
    TextView score, taxfraud, percenttv, seekbartv;
    SeekBar seekbar;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        redobeginner = findViewById(R.id.redobeginner);
        redomedium = findViewById(R.id.redomedium);
        redohardcore = findViewById(R.id.redohardcore);
        seekbar = findViewById(R.id.idSeekBar);
        seekbartv = findViewById(R.id.seekbartv);
        changehiraganaamount = findViewById(R.id.changehiraganaamount);

        score = findViewById(R.id.score);
        String successful = getIntent().getExtras().getString("Success");
        String unsuccessful = getIntent().getExtras().getString("Unsuccess");
        final String testamount = getIntent().getExtras().getString("Value");
        //final String value = getIntent().getExtras().getString("Value");
        String asd = score.getText().toString();
        String end_with = getString(R.string.ending_with);
        String end_mistake = getString(R.string.ending_mistakes);
        score.setText(String.format("%s%s %s %s %s", asd, successful, end_with, unsuccessful, end_mistake));

        percenttv = findViewById(R.id.percenttv);
        double helyes = Integer.parseInt(Objects.requireNonNull(successful));
        double hibas = Integer.parseInt(Objects.requireNonNull(unsuccessful));
        double max = helyes + hibas;
        String percent = Double.toString((helyes / max)*100);
        percenttv.setText(percent + "%");
        seekbartv.setText(testamount);

        changehiraganaamount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekbar.setAlpha(1);
                seekbartv.setVisibility(View.VISIBLE);
            }
        });

        final String toastStopTouch = getString(R.string.test_seekbar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress += 1;
                seekbartv.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Ending.this, toastStopTouch, Toast.LENGTH_SHORT).show();
            }
        });

        redobeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ending.this, Beginner.class);
                String e = seekbartv.getText().toString();
                intent.putExtra("Value",e);
                startActivity(intent);
                finish();
            }
        });

        redomedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ending.this, Medium.class);
                String e = seekbartv.getText().toString();
                intent.putExtra("Value",e);
                startActivity(intent);
                finish();
            }
        });

        redohardcore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ending.this, Hardcore.class);
                String e = seekbartv.getText().toString();
                intent.putExtra("Value",e);
                startActivity(intent);
                finish();
            }
        });
    }
}
