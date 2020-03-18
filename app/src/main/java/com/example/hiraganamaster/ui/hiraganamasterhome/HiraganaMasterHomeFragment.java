package com.example.hiraganamaster.ui.hiraganamasterhome;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.hiraganamaster.AdatbazisSegito;
import com.example.hiraganamaster.Login;
import com.example.hiraganamaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HiraganaMasterHomeFragment extends Fragment {

    private Button login;
    private AdatbazisSegito db;

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
        db = new AdatbazisSegito(getContext());

        /*FloatingActionButton fab = getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Bruh", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        TextView tw = getView().findViewById(R.id.welcome);

        CoordinatorLayout linearLayout = getView().findViewById(R.id.hiraganamasterhome);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        login = getView().findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
            }
        });
        if(bejelentkezett()) {
            tw.setText("Welcome "+getTeljesNev());
        }
        else
        {
            tw.setText("Welcome to Hiragana Master");
        }

    }

    private boolean bejelentkezett()
    {
        return true;
    }

    private String getTeljesNev()
    {
        SharedPreferences sharedPreferences = new ContextWrapper(getActivity()).getSharedPreferences("felhasznalo", Context.MODE_PRIVATE);
        String felhasznalonev = sharedPreferences.getString("felhnev", "");

        Cursor eredmeny = db.selectTeljesNev(felhasznalonev);
        StringBuffer stringBuffer = new StringBuffer();
        if (eredmeny != null && eredmeny.getCount() > 0)
        {
            while (eredmeny.moveToNext())
            {
                stringBuffer.append(eredmeny.getString(0));
            }
            return stringBuffer.toString();
        }
        else
        {
            return null;
        }
    }

}
