package com.example.hiraganamaster.ui.hiraganamasterhome;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hiraganamaster.Login;
import com.example.hiraganamaster.R;

public class HiraganaMasterHomeFragment extends Fragment {

    private Button login;

    private HiraganaMasterHomeViewModel mViewModel;

    public static HiraganaMasterHomeFragment newInstance() {
        return new HiraganaMasterHomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hiragana_master_home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HiraganaMasterHomeViewModel.class);

        SharedPreferences sharedPreferences = getSharedPreferences("felhasznalo", Context.MODE_PRIVATE);
        String felhasznalonev = sharedPreferences.getString("felhnev", "");

        Cursor eredmeny = db.selectTeljesNev(felhasznalonev);

        login = getView().findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
            }
        });
    }

}
