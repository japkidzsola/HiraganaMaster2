package com.example.hiraganamaster.ui.learn;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hiraganamaster.R;
import com.example.hiraganamaster.ui.hiraganalearn.HiraganaLearnFragment;

public class LearnFragment extends Fragment {

    private LearnViewModel mViewModel;

    private ImageView a;

    public static LearnFragment newInstance() {
        return new LearnFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.learn_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LearnViewModel.class);

        /*a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnFragment.this, HiraganaLearnFragment.class);
                startActivity(intent);
            }
        });*/
    }

}
