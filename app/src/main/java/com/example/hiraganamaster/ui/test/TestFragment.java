package com.example.hiraganamaster.ui.test;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiraganamaster.Beginner;
import com.example.hiraganamaster.Medium;
import com.example.hiraganamaster.R;

public class TestFragment extends Fragment {

    private Button beginnerbtn, mediumbtn, hardcorebtn;
    public SeekBar seekBar;
    public TextView seekbartv;

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
                Toast.makeText(getContext(), "Press the medium button to go to the test", Toast.LENGTH_SHORT).show();
            }
        });

        beginnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Beginner.class);
                startActivity(intent);
            }
        });
        final int[] i = {0};
        mediumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setAlpha(1);
                seekbartv.setVisibility(View.VISIBLE);

                i[0]++;
                if(i[0] == 2)
                {
                    Intent intent = new Intent(getContext(), Medium.class);
                    String tovabbad = seekbartv.getText().toString();
                    int itovabbad = Integer.parseInt(tovabbad);
                    intent.putExtra("Value",tovabbad);
                    startActivity(intent);
                    i[0] = 0;
                }

            }
        });

        final int[] j = {0};
        mediumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setAlpha(1);
                seekbartv.setVisibility(View.VISIBLE);

                j[0]++;
                if(j[0] == 2)
                {
                    Intent intent = new Intent(getContext(), Medium.class);
                    String tovabbad = seekbartv.getText().toString();
                    int itovabbad = Integer.parseInt(tovabbad);
                    intent.putExtra("Value",tovabbad);
                    startActivity(intent);
                    j[0] = 0;
                }

            }
        });
    }

}
