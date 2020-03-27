package com.example.hiraganamaster.ui.hiraganamasterhome;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
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

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiraganamaster.AdatbazisSegito;
import com.example.hiraganamaster.Beginner;
import com.example.hiraganamaster.EndingFail;
import com.example.hiraganamaster.Hardcore;
import com.example.hiraganamaster.Login;
import com.example.hiraganamaster.Medium;
import com.example.hiraganamaster.R;
import com.example.hiraganamaster.ui.learn.LearnFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import maes.tech.intentanim.CustomIntent;

public class HiraganaMasterHomeFragment extends Fragment {

    private Button login,beginnerbtn,mediumbtn,hardcorebtn;
    private AdatbazisSegito db;
    private TextView apptimer;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 600000;
    private boolean timerRunning;

    private HiraganaMasterHomeViewModel mViewModel;

    public HiraganaMasterHomeFragment() {
    }

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

        final LearnFragment learnFragment = new LearnFragment();
        HiraganaMasterHomeFragment homeFragment = new HiraganaMasterHomeFragment();

        final TextView tw = getView().findViewById(R.id.welcome);

        CoordinatorLayout linearLayout = getView().findViewById(R.id.hiraganamasterhome);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        @SuppressLint("ResourceType") final String welcomename = getString(R.string.welcome_name);
            tw.setText(welcomename +" "+ getTeljesNev());

        @SuppressLint("ResourceType") final String welcome = getString(R.string.welcome);

        final String logout = getString(R.string.logout_from_profile_here);

        final String logintext = getString(R.string.login);

        if (tw.getText().toString().equals("Welcome null"))
        {
            tw.setText(welcome);
        }
        if(tw.getText().toString().equals("Welcome "))
        {
            tw.setText(welcome);
        }
        login = getView().findViewById(R.id.login);

        if(tw.getText().toString().equals(welcomename + " " +getTeljesNev()))
        {
            login.setText(logout);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tw.getText().toString().equals(welcomename + " " +getTeljesNev()))
                {
                    SharedPreferences preferences = new ContextWrapper(getActivity()).getSharedPreferences("felhasznalo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();
                    Toast.makeText(getActivity(), logout, Toast.LENGTH_SHORT).show();
                    tw.setText(welcome);
                    login.setText(logintext);
                }else
                {
                    Intent intent = new Intent(getContext(), Login.class);
                    startActivity(intent);
                }
            }
        });

        beginnerbtn = getView().findViewById(R.id.beginnerhomebtn);
        mediumbtn = getView().findViewById(R.id.mediumhomebtn);
        hardcorebtn = getView().findViewById(R.id.hardcorehomebtn);

        beginnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Beginner.class);
                String tovabbad = "46";
                intent.putExtra("Value",tovabbad);
                startActivity(intent);
                CustomIntent.customType(getContext(),"bottom-to-up");
            }
        });
        mediumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Medium.class);
                String tovabbad = "46";
                intent.putExtra("Value",tovabbad);
                startActivity(intent);
                CustomIntent.customType(getContext(),"fadein-to-fadeout");
            }
        });
        hardcorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Hardcore.class);
                String tovabbad = "46";
                intent.putExtra("Value",tovabbad);
                startActivity(intent);
                CustomIntent.customType(getContext(),"up-to-bottom");
            }
        });

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

        //return felhasznalonev;
    }

}
