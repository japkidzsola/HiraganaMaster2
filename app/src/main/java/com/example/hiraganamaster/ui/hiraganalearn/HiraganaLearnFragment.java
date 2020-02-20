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
        final MediaPlayer playKa = MediaPlayer.create(getContext(), R.raw.ka);
        final MediaPlayer playKi = MediaPlayer.create(getContext(), R.raw.ki);
        final MediaPlayer playKu = MediaPlayer.create(getContext(), R.raw.ku);
        final MediaPlayer playKe = MediaPlayer.create(getContext(), R.raw.ke);
        final MediaPlayer playKo = MediaPlayer.create(getContext(), R.raw.ko);
        final MediaPlayer playSa = MediaPlayer.create(getContext(), R.raw.sa);
        final MediaPlayer playShi = MediaPlayer.create(getContext(), R.raw.shi);
        final MediaPlayer playSu = MediaPlayer.create(getContext(), R.raw.su);
        final MediaPlayer playSe = MediaPlayer.create(getContext(), R.raw.se);
        final MediaPlayer playSo = MediaPlayer.create(getContext(), R.raw.so);


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
                seged = "e";
            } else if (betu.equals("o")) {
                ivLearn.setImageResource(R.drawable.o);
                tw.setText("Hiragana "+betu);
                seged = "o";
            } else if (betu.equals("ka")) {
                ivLearn.setImageResource(R.drawable.ka);
                tw.setText("Hiragana "+betu);
                seged = "ka";
            } else if (betu.equals("ki")) {
                ivLearn.setImageResource(R.drawable.ki);
                tw.setText("Hiragana "+betu);
                seged = "ki";
            } else if (betu.equals("ku")) {
                ivLearn.setImageResource(R.drawable.ku);
                tw.setText("Hiragana "+betu);
                seged = "ku";
            } else if (betu.equals("ke")) {
                ivLearn.setImageResource(R.drawable.ke);
                tw.setText("Hiragana "+betu);
                seged = "ke";
            } else if (betu.equals("ko")) {
                ivLearn.setImageResource(R.drawable.ko);
                tw.setText("Hiragana "+betu);
                seged = "ko";
            } else if (betu.equals("sa")) {
                ivLearn.setImageResource(R.drawable.sa);
                tw.setText("Hiragana "+betu);
                seged = "sa";
            } else if (betu.equals("shi")) {
                ivLearn.setImageResource(R.drawable.shi);
                tw.setText("Hiragana "+betu);
                seged = "shi";
            } else if (betu.equals("su")) {
                ivLearn.setImageResource(R.drawable.su);
                tw.setText("Hiragana "+betu);
                seged = "su";
            } else if (betu.equals("se")) {
                ivLearn.setImageResource(R.drawable.se);
                tw.setText("Hiragana "+betu);
                seged = "se";
            } else if (betu.equals("so")) {
                ivLearn.setImageResource(R.drawable.so);
                tw.setText("Hiragana "+betu);
                seged = "so";
            } else if (betu.equals("ta")) {
                ivLearn.setImageResource(R.drawable.ta);
                tw.setText("Hiragana "+betu);
                seged = "ta";
            } else if (betu.equals("chi")) {
                ivLearn.setImageResource(R.drawable.chi);
                tw.setText("Hiragana "+betu);
                seged = "chi";
            } else if (betu.equals("tsu")) {
                ivLearn.setImageResource(R.drawable.tsu);
                tw.setText("Hiragana "+betu);
                seged = "stu";
            } else if (betu.equals("te")) {
                ivLearn.setImageResource(R.drawable.te);
                tw.setText("Hiragana "+betu);
                seged = "te";
            } else if (betu.equals("to")) {
                ivLearn.setImageResource(R.drawable.to);
                tw.setText("Hiragana "+betu);
                seged = "to";
            } else if (betu.equals("na")) {
                ivLearn.setImageResource(R.drawable.na);
                tw.setText("Hiragana "+betu);
                seged = "na";
            } else if (betu.equals("ni")) {
                ivLearn.setImageResource(R.drawable.ni);
                tw.setText("Hiragana "+betu);
                seged = "ni";
            } else if (betu.equals("nu")) {
                ivLearn.setImageResource(R.drawable.nu);
                tw.setText("Hiragana "+betu);
                seged = "nu";
            } else if (betu.equals("ne")) {
                ivLearn.setImageResource(R.drawable.ne);
                tw.setText("Hiragana "+betu);
                seged = "ne";
            } else if (betu.equals("no")) {
                ivLearn.setImageResource(R.drawable.mo);
                tw.setText("Hiragana "+betu);
                seged = "no";
            } else if (betu.equals("ha")) {
                ivLearn.setImageResource(R.drawable.ha);
                tw.setText("Hiragana "+betu);
                seged = "ha";
            } else if (betu.equals("hi")) {
                ivLearn.setImageResource(R.drawable.hi);
                tw.setText("Hiragana "+betu);
                seged = "hi";
            } else if (betu.equals("fu")) {
                ivLearn.setImageResource(R.drawable.fu);
                tw.setText("Hiragana "+betu);
                seged = "fu";
            } else if (betu.equals("he")) {
                ivLearn.setImageResource(R.drawable.he);
                tw.setText("Hiragana "+betu);
                seged = "he";
            } else if (betu.equals("ho")) {
                ivLearn.setImageResource(R.drawable.ho);
                tw.setText("Hiragana "+betu);
                seged = "ho";
            } else if (betu.equals("ma")) {
                ivLearn.setImageResource(R.drawable.ma);
                tw.setText("Hiragana "+betu);
                seged = "ma";
            } else if (betu.equals("mi")) {
                ivLearn.setImageResource(R.drawable.mi);
                tw.setText("Hiragana "+betu);
                seged = "mi";
            } else if (betu.equals("mu")) {
                ivLearn.setImageResource(R.drawable.mu);
                tw.setText("Hiragana "+betu);
                seged = "mu";
            } else if (betu.equals("me")) {
                ivLearn.setImageResource(R.drawable.me);
                tw.setText("Hiragana "+betu);
                seged = "me";
            } else if (betu.equals("mo")) {
                ivLearn.setImageResource(R.drawable.mo);
                tw.setText("Hiragana "+betu);
                seged = "mo";
            } else if (betu.equals("ya")) {
                ivLearn.setImageResource(R.drawable.ya);
                tw.setText("Hiragana "+betu);
                seged = "ya";
            } else if (betu.equals("yu")) {
                ivLearn.setImageResource(R.drawable.yu);
                tw.setText("Hiragana "+betu);
                seged = "yu";
            } else if (betu.equals("yo")) {
                ivLearn.setImageResource(R.drawable.yo);
                tw.setText("Hiragana "+betu);
                seged = "yo";
            } else if (betu.equals("ra")) {
                ivLearn.setImageResource(R.drawable.ra);
                tw.setText("Hiragana "+betu);
                seged = "ra";
            } else if (betu.equals("ri")) {
                ivLearn.setImageResource(R.drawable.ri);
                tw.setText("Hiragana "+betu);
                seged = "ri";
            } else if (betu.equals("ru")) {
                ivLearn.setImageResource(R.drawable.ru);
                tw.setText("Hiragana "+betu);
                seged = "ru";
            } else if (betu.equals("re")) {
                ivLearn.setImageResource(R.drawable.re);
                tw.setText("Hiragana "+betu);
                seged = "re";
            } else if (betu.equals("ro")) {
                ivLearn.setImageResource(R.drawable.ro);
                tw.setText("Hiragana "+betu);
                seged = "ro";
            } else if (betu.equals("wa")) {
                ivLearn.setImageResource(R.drawable.wa);
                tw.setText("Hiragana "+betu);
                seged = "wa";
            } else if (betu.equals("wo")) {
                ivLearn.setImageResource(R.drawable.wo);
                tw.setText("Hiragana "+betu);
                seged = "wo";
            } else if (betu.equals("n")) {
                ivLearn.setImageResource(R.drawable.n);
                tw.setText("Hiragana "+betu);
                seged = "n";
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
                    } else if (betu.equals("ka")) {
                        playKa.start();
                    } else if (betu.equals("ki")) {
                        playKi.start();
                    } else if (betu.equals("ku")) {
                        playKu.start();
                    } else if (betu.equals("ke")) {
                        playKe.start();
                    } else if (betu.equals("ko")) {
                        playKo.start();
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
                }else if(seged.equals("ka"))
                {
                    playKa.start();
                }else if(seged.equals("ki"))
                {
                    playKi.start();
                }else if(seged.equals("ku"))
                {
                    playKu.start();
                }else if(seged.equals("ke"))
                {
                    playKe.start();
                }else if(seged.equals("ko"))
                {
                    playKo.start();
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
                else if(seged.equals("ka"))
                {
                    ivLearn.setImageResource(R.drawable.ki);
                    seged = "ki";
                    tw.setText("Hiaragana ki");
                }
                else if(seged.equals("ki"))
                {
                    ivLearn.setImageResource(R.drawable.ku);
                    seged = "ku";
                    tw.setText("Hiaragana ku");
                }
                else if(seged.equals("ku"))
                {
                    ivLearn.setImageResource(R.drawable.ke);
                    seged = "ke";
                    tw.setText("Hiaragana ke");
                }
                else if(seged.equals("ke"))
                {
                    ivLearn.setImageResource(R.drawable.ko);
                    seged = "ko";
                    tw.setText("Hiaragana ko");
                }
                else if(seged.equals("ko"))
                {
                    ivLearn.setImageResource(R.drawable.sa);
                    seged = "sa";
                    tw.setText("Hiaragana sa");
                }
                else if(seged.equals("sa"))
                {
                    ivLearn.setImageResource(R.drawable.shi);
                    seged = "shi";
                    tw.setText("Hiaragana shi");
                }
                else if(seged.equals("shi"))
                {
                    ivLearn.setImageResource(R.drawable.su);
                    seged = "su";
                    tw.setText("Hiaragana su");
                }
                else if(seged.equals("su"))
                {
                    ivLearn.setImageResource(R.drawable.se);
                    seged = "se";
                    tw.setText("Hiaragana se");
                }
                else if(seged.equals("se"))
                {
                    ivLearn.setImageResource(R.drawable.so);
                    seged = "so";
                    tw.setText("Hiaragana so");
                }
                else if(seged.equals("so"))
                {
                    ivLearn.setImageResource(R.drawable.ta);
                    seged = "ta";
                    tw.setText("Hiaragana ta");
                }
                else if(seged.equals("ta"))
                {
                    ivLearn.setImageResource(R.drawable.chi);
                    seged = "chi";
                    tw.setText("Hiaragana chi");
                }
                else if(seged.equals("chi"))
                {
                    ivLearn.setImageResource(R.drawable.tsu);
                    seged = "tsu";
                    tw.setText("Hiaragana tsu");
                }
                else if(seged.equals("tsu"))
                {
                    ivLearn.setImageResource(R.drawable.te);
                    seged = "te";
                    tw.setText("Hiaragana te");
                }
                else if(seged.equals("te"))
                {
                    ivLearn.setImageResource(R.drawable.to);
                    seged = "to";
                    tw.setText("Hiaragana to");
                }
                else if(seged.equals("to"))
                {
                    ivLearn.setImageResource(R.drawable.na);
                    seged = "na";
                    tw.setText("Hiaragana na");
                }
                else if(seged.equals("na"))
                {
                    ivLearn.setImageResource(R.drawable.ni);
                    seged = "ni";
                    tw.setText("Hiaragana ni");
                }
                else if(seged.equals("ni"))
                {
                    ivLearn.setImageResource(R.drawable.nu);
                    seged = "nu";
                    tw.setText("Hiaragana nu");
                }
                else if(seged.equals("nu"))
                {
                    ivLearn.setImageResource(R.drawable.ne);
                    seged = "ne";
                    tw.setText("Hiaragana ne");
                }
                else if(seged.equals("ne"))
                {
                    ivLearn.setImageResource(R.drawable.no);
                    seged = "no";
                    tw.setText("Hiaragana no");
                }
                else if(seged.equals("no"))
                {
                    ivLearn.setImageResource(R.drawable.ha);
                    seged = "ha";
                    tw.setText("Hiaragana ha");
                }
                else if(seged.equals("ha"))
                {
                    ivLearn.setImageResource(R.drawable.hi);
                    seged = "hi";
                    tw.setText("Hiaragana hi");
                }
                else if(seged.equals("hi"))
                {
                    ivLearn.setImageResource(R.drawable.fu);
                    seged = "fu";
                    tw.setText("Hiaragana fu");
                }
                else if(seged.equals("fu"))
                {
                    ivLearn.setImageResource(R.drawable.he);
                    seged = "he";
                    tw.setText("Hiaragana he");
                }
                else if(seged.equals("he"))
                {
                    ivLearn.setImageResource(R.drawable.ho);
                    seged = "ho";
                    tw.setText("Hiaragana ho");
                }
                else if(seged.equals("ho"))
                {
                    ivLearn.setImageResource(R.drawable.ma);
                    seged = "ma";
                    tw.setText("Hiaragana ma");
                }
                else if(seged.equals("ma"))
                {
                    ivLearn.setImageResource(R.drawable.mi);
                    seged = "mi";
                    tw.setText("Hiaragana mi");
                }
                else if(seged.equals("mi"))
                {
                    ivLearn.setImageResource(R.drawable.mu);
                    seged = "mu";
                    tw.setText("Hiaragana mu");
                }
                else if(seged.equals("mu"))
                {
                    ivLearn.setImageResource(R.drawable.me);
                    seged = "me";
                    tw.setText("Hiaragana me");
                }
                else if(seged.equals("me"))
                {
                    ivLearn.setImageResource(R.drawable.mo);
                    seged = "mo";
                    tw.setText("Hiaragana mo");
                }
                else if(seged.equals("mo"))
                {
                    ivLearn.setImageResource(R.drawable.ya);
                    seged = "ya";
                    tw.setText("Hiaragana ya");
                }
                else if(seged.equals("ya"))
                {
                    ivLearn.setImageResource(R.drawable.yu);
                    seged = "yu";
                    tw.setText("Hiaragana yu");
                }
                else if(seged.equals("yu"))
                {
                    ivLearn.setImageResource(R.drawable.yo);
                    seged = "yo";
                    tw.setText("Hiaragana yo");
                }
                else if(seged.equals("yo"))
                {
                    ivLearn.setImageResource(R.drawable.ra);
                    seged = "ra";
                    tw.setText("Hiaragana ra");
                }
                else if(seged.equals("ra"))
                {
                    ivLearn.setImageResource(R.drawable.ri);
                    seged = "ri";
                    tw.setText("Hiaragana ri");
                }
                else if(seged.equals("ri"))
                {
                    ivLearn.setImageResource(R.drawable.ru);
                    seged = "ru";
                    tw.setText("Hiaragana ru");
                }
                else if(seged.equals("ru"))
                {
                    ivLearn.setImageResource(R.drawable.re);
                    seged = "re";
                    tw.setText("Hiaragana re");
                }
                else if(seged.equals("re"))
                {
                    ivLearn.setImageResource(R.drawable.ro);
                    seged = "ro";
                    tw.setText("Hiaragana ro");
                }
                else if(seged.equals("ro"))
                {
                    ivLearn.setImageResource(R.drawable.wa);
                    seged = "wa";
                    tw.setText("Hiaragana wa");
                }
                else if(seged.equals("wa"))
                {
                    ivLearn.setImageResource(R.drawable.wo);
                    seged = "wo";
                    tw.setText("Hiaragana wo");
                }
                else if(seged.equals("wo"))
                {
                    ivLearn.setImageResource(R.drawable.n);
                    seged = "n";
                    tw.setText("Hiaragana n");
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
                    tw.setText("Hiragana a");
                }
                else if(seged.equals("u"))
                {
                    ivLearn.setImageResource(R.drawable.i);
                    seged = "i";
                    tw.setText("Hiragana i");
                }
                else if(seged.equals("e"))
                {
                    ivLearn.setImageResource(R.drawable.u);
                    seged = "u";
                    tw.setText("Hiragana u");
                }
                else if(seged.equals("o"))
                {
                    ivLearn.setImageResource(R.drawable.e);
                    seged = "e";
                    tw.setText("Hiragana e");
                }
                else if(seged.equals("ka"))
                {
                    ivLearn.setImageResource(R.drawable.o);
                    seged = "o";
                    tw.setText("Hiragana o");
                }
                else if(seged.equals("ki"))
                {
                    ivLearn.setImageResource(R.drawable.ka);
                    seged = "ka";
                    tw.setText("Hiragana ka");
                }
                else if(seged.equals("ku"))
                {
                    ivLearn.setImageResource(R.drawable.ki);
                    seged = "ki";
                    tw.setText("Hiragana ki");
                }
                else if(seged.equals("ke"))
                {
                    ivLearn.setImageResource(R.drawable.ku);
                    seged = "ku";
                    tw.setText("Hiragana ku");
                }
                else if(seged.equals("ko"))
                {
                    ivLearn.setImageResource(R.drawable.ke);
                    seged = "ke";
                    tw.setText("Hiragana ke");
                }
                else if(seged.equals("sa"))
                {
                    ivLearn.setImageResource(R.drawable.ko);
                    seged = "ko";
                    tw.setText("Hiragana ko");
                }
            }
        });
    }
}
