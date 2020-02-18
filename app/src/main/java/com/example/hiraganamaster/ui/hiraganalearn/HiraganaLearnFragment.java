package com.example.hiraganamaster.ui.hiraganalearn;

import androidx.lifecycle.ViewModelProviders;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiraganamaster.R;

import java.util.HashMap;

public class HiraganaLearnFragment extends Fragment {

    private HiraganaLearnViewModel mViewModel;
    private static String betu;

    private Button btnplay;

    MediaPlayer mp;

    public String seged = "";

    private static String balra;
    private static String jobbra;
    public String[] aiueo = {"nincs","a","i","u","e","o","ka","ki","ku","ke","ko","sa","shi","su","se","so","ta","chi","tsu","te","to"};

    public int[] aiueoindex = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};


    public static HiraganaLearnFragment newInstance(String betu, String balra, String jobbra) {
        HiraganaLearnFragment.betu = betu;
        HiraganaLearnFragment.balra = balra;
        HiraganaLearnFragment.jobbra = jobbra;
        return new HiraganaLearnFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.hiragana_learn_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HiraganaLearnViewModel.class);
        // TODO: Use the ViewModel

        final MediaPlayer playA = MediaPlayer.create(getContext(), R.raw.a);
        final MediaPlayer playI = MediaPlayer.create(getContext(), R.raw.i);
        final MediaPlayer playU = MediaPlayer.create(getContext(), R.raw.u);
        final MediaPlayer playE = MediaPlayer.create(getContext(), R.raw.e);
        final MediaPlayer playO = MediaPlayer.create(getContext(), R.raw.o);


        TextView tw = getView().findViewById(R.id.textviewhiragana);
        ImageView ivLearn = getView().findViewById(R.id.ivLearn);
        tw.setText("Hiragana");
        if(seged.isEmpty()) {

            if (betu.equals("a")) {
                ivLearn.setImageResource(R.drawable.a);
                tw.setText("Hiragana "+betu);
                seged = "a";
            } else if (betu.equals("i")) {
                ivLearn.setImageResource(R.drawable.i);
                tw.setText("Hiragana "+betu);
                seged = "i";
            } else if (betu.equals("u")) {
                ivLearn.setImageResource(R.drawable.u);
                tw.setText("Hiragana "+betu);
                seged = "u";
            } else if (betu.equals("e")) {
                ivLearn.setImageResource(R.drawable.e);
                tw.setText("Hiragana "+betu);
            } else if (betu.equals("o")) {
                ivLearn.setImageResource(R.drawable.o);
                tw.setText("Hiragana "+betu);
            } else if (betu.equals("Hiragana ka")) {
                ivLearn.setImageResource(R.drawable.ka);
                tw.setText("Hiragana "+betu);
            } else if (betu.equals("Hiragana ki")) {
                ivLearn.setImageResource(R.drawable.ki);
                tw.setText("Hiragana "+betu);
            } else if (betu.equals("Hiragana ku")) {
                ivLearn.setImageResource(R.drawable.ku);
                tw.setText("Hiragana "+betu);
            } else if (betu.equals("Hiragana ke")) {
                ivLearn.setImageResource(R.drawable.ke);
                tw.setText("Hiragana "+betu);
            } else if (betu.equals("Hiragana ko")) {
                ivLearn.setImageResource(R.drawable.ko);
                tw.setText("Hiragana "+betu);
            } else if (betu.equals("Hiragana sa")) {
                ivLearn.setImageResource(R.drawable.sa);
            } else if (betu.equals("Hiragana shi")) {
                ivLearn.setImageResource(R.drawable.shi);
            } else if (betu.equals("Hiragana su")) {
                ivLearn.setImageResource(R.drawable.su);
            } else if (betu.equals("Hiragana se")) {
                ivLearn.setImageResource(R.drawable.se);
            } else if (betu.equals("Hiragana so")) {
                ivLearn.setImageResource(R.drawable.so);
            } else if (betu.equals("Hiragana ta")) {
                ivLearn.setImageResource(R.drawable.ta);
            } else if (betu.equals("Hiragana chi")) {
                ivLearn.setImageResource(R.drawable.chi);
            } else if (betu.equals("Hiragana tsu")) {
                ivLearn.setImageResource(R.drawable.tsu);
            } else if (betu.equals("Hiragana te")) {
                ivLearn.setImageResource(R.drawable.te);
            } else if (betu.equals("Hiragana to")) {
                ivLearn.setImageResource(R.drawable.to);
            } else if (betu.equals("Hiragana na")) {
                ivLearn.setImageResource(R.drawable.na);
            } else if (betu.equals("Hiragana ni")) {
                ivLearn.setImageResource(R.drawable.ni);
            } else if (betu.equals("Hiragana nu")) {
                ivLearn.setImageResource(R.drawable.nu);
            } else if (betu.equals("Hiragana ne")) {
                ivLearn.setImageResource(R.drawable.ne);
            } else if (betu.equals("Hiragana no")) {
                ivLearn.setImageResource(R.drawable.mo);
            } else if (betu.equals("Hiragana ha")) {
                ivLearn.setImageResource(R.drawable.ha);
            } else if (betu.equals("Hiragana hi")) {
                ivLearn.setImageResource(R.drawable.hi);
            } else if (betu.equals("Hiragana hu")) {
                ivLearn.setImageResource(R.drawable.fu);
            } else if (betu.equals("Hiragana he")) {
                ivLearn.setImageResource(R.drawable.he);
            } else if (betu.equals("Hiragana ho")) {
                ivLearn.setImageResource(R.drawable.ho);
            } else if (betu.equals("Hiragana ma")) {
                ivLearn.setImageResource(R.drawable.ma);
            } else if (betu.equals("Hiragana mi")) {
                ivLearn.setImageResource(R.drawable.mi);
            } else if (betu.equals("Hiragana mu")) {
                ivLearn.setImageResource(R.drawable.mu);
            } else if (betu.equals("Hiragana me")) {
                ivLearn.setImageResource(R.drawable.me);
            } else if (betu.equals("Hiragana mo")) {
                ivLearn.setImageResource(R.drawable.mo);
            } else if (betu.equals("Hiragana ya")) {
                ivLearn.setImageResource(R.drawable.ya);
            } else if (betu.equals("Hiragana yu")) {
                ivLearn.setImageResource(R.drawable.yu);
            } else if (betu.equals("Hiragana yo")) {
                ivLearn.setImageResource(R.drawable.yo);
            } else if (betu.equals("Hiragana ra")) {
                ivLearn.setImageResource(R.drawable.ra);
            } else if (betu.equals("Hiragana ri")) {
                ivLearn.setImageResource(R.drawable.ri);
            } else if (betu.equals("Hiragana ru")) {
                ivLearn.setImageResource(R.drawable.ru);
            } else if (betu.equals("Hiragana re")) {
                ivLearn.setImageResource(R.drawable.re);
            } else if (betu.equals("Hiragana ro")) {
                ivLearn.setImageResource(R.drawable.ro);
            } else if (betu.equals("Hiragana wa")) {
                ivLearn.setImageResource(R.drawable.wa);
            } else if (betu.equals("Hiragana wo")) {
                ivLearn.setImageResource(R.drawable.wo);
            } else if (betu.equals("Hiragana n")) {
                ivLearn.setImageResource(R.drawable.n);
            }
        }

        Button btnplay = getView().findViewById(R.id.btnplay);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seged == "") {
                    if (betu.equals("a")) {
                        playA.start();
                    } else if (betu.equals("i")) {
                        playI.start();
                    } else if (betu.equals("u")) {
                        playU.start();
                    } else if (betu.equals("e")) {
                        playE.start();
                    } else if (betu.equals("o")) {
                        playO.start();
                    }
                }else if(seged.equals("a"))
                {
                    playA.start();
                }else if(seged.equals("i"))
                {
                    playI.start();
                }else if(seged.equals("u"))
                {
                    playU.start();
                }else if(seged.equals("e"))
                {
                    playE.start();
                }else if(seged.equals("o"))
                {
                    playO.start();
                }
            }
        });


        Button toLeft = getView().findViewById(R.id.toLeft);
        final Button toRight = getView().findViewById(R.id.toRight);


        toRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tw = getView().findViewById(R.id.textviewhiragana);
                ImageView ivLearn = getView().findViewById(R.id.ivLearn);

                if(seged.equals("a"))
                {
                    ivLearn.setImageResource(R.drawable.i);
                    seged = "i";
                    tw.setText("Hiragana i");
                }
                else if(seged.equals("i"))
                {
                    ivLearn.setImageResource(R.drawable.u);
                    seged = "u";
                    tw.setText("Hiragana u");
                }
                else if(seged.equals("i"))
                {
                    ivLearn.setImageResource(R.drawable.u);
                    seged = "u";
                    tw.setText("Hiragana u");
                }
                else if(seged.equals("u"))
                {
                    ivLearn.setImageResource(R.drawable.e);
                    seged = "e";
                    tw.setText("Hiragana e");
                }
                else if(seged.equals("e"))
                {
                    ivLearn.setImageResource(R.drawable.o);
                    seged = "o";
                    tw.setText("Hiaragana o");
                }
                else if(seged.equals("o"))
                {
                    ivLearn.setImageResource(R.drawable.ka);
                    seged = "ka";
                    tw.setText("Hiaragana ka");
                }
                else if(seged.equals("n"))
                {
                    Toast.makeText(getContext(), "Hiba", Toast.LENGTH_SHORT).show();
                }
            }

        });

        toLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tw = getView().findViewById(R.id.textviewhiragana);
                ImageView ivLearn = getView().findViewById(R.id.ivLearn);

                if(seged.equals("a"))
                {
                    Toast.makeText(getContext(), "Hiba", Toast.LENGTH_SHORT).show();
                }
                else if(seged.equals("i"))
                {
                    ivLearn.setImageResource(R.drawable.a);
                    seged = "a";
                    tw.setText("a");
                }
                else if(seged.equals("u"))
                {
                    ivLearn.setImageResource(R.drawable.i);
                    seged = "i";
                    tw.setText("i");
                }
                else if(seged.equals("e"))
                {
                    ivLearn.setImageResource(R.drawable.u);
                    seged = "u";
                    tw.setText("u");
                }
                else if(seged.equals("o"))
                {
                    ivLearn.setImageResource(R.drawable.e);
                    seged = "e";
                    tw.setText("e");
                }
            }
        });
    }
}