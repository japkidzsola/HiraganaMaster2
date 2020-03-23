package com.example.hiraganamaster.ui.test;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiraganamaster.Beginner;
import com.example.hiraganamaster.Hardcore;
import com.example.hiraganamaster.Medium;
import com.example.hiraganamaster.R;

import maes.tech.intentanim.CustomIntent;

public class TestFragment extends Fragment {

    private Button beginnerbtn, mediumbtn, hardcorebtn;
    private SeekBar seekBar;
    private TextView seekbartv, mediumdesc;

    private TestViewModel mViewModel;

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        // TODO: Use the ViewModel

        beginnerbtn = getView().findViewById(R.id.beginnerbtn);
        mediumbtn = getView().findViewById(R.id.mediumbtn);
        hardcorebtn = getView().findViewById(R.id.hardcorebtn);
        seekBar = getView().findViewById(R.id.idSeekBar);
        seekbartv = getView().findViewById(R.id.seekbartv);
        mediumdesc = getView().findViewById(R.id.mediumDescr);

        String dragbar = mediumdesc.getText().toString();

        String text = dragbar;

        SpannableString ss = new SpannableString(text);

        StyleSpan italicSpan = new StyleSpan(Typeface.ITALIC);

        ss.setSpan(italicSpan, 0, dragbar.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mediumdesc.setText(ss);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
                Toast.makeText(getContext(), "Press one of the test button to start to the test", Toast.LENGTH_SHORT).show();
            }
        });


        beginnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Beginner.class);
                String tovabbad = seekbartv.getText().toString();
                intent.putExtra("Value",tovabbad);
                startActivity(intent);
                CustomIntent.customType(getContext(),"bottom-to-up");
            }
        });
        mediumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setAlpha(1);
                seekbartv.setVisibility(View.VISIBLE);
                mediumdesc.setVisibility(View.VISIBLE);
                Intent intent = new Intent(getContext(), Medium.class);
                String tovabbad = seekbartv.getText().toString();
                int itovabbad = Integer.parseInt(tovabbad);
                intent.putExtra("Value",tovabbad);
                startActivity(intent);
                CustomIntent.customType(getContext(),"fadein-to-fadeout");
            }
        });
        hardcorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Hardcore.class);
                String tovabbad = seekbartv.getText().toString();
                intent.putExtra("Value",tovabbad);
                startActivity(intent);
                CustomIntent.customType(getContext(),"up-to-bottom");
            }
        });

    }

}
