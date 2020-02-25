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

import com.example.hiraganamaster.Beginner;
import com.example.hiraganamaster.R;

public class TestFragment extends Fragment {

    private Button beginnerbtn, mediumbtn, hardcorebtn;

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
        mediumbtn = getView().findViewById(R.id.beginnerbtn);
        hardcorebtn = getView().findViewById(R.id.beginnerbtn);

        beginnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Beginner.class);
                startActivity(intent);
            }
        });
    }

}
