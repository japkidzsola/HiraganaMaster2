package com.example.hiraganamaster.ui.hiraganalearn;

import androidx.lifecycle.ViewModelProviders;

import android.database.Cursor;
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

import com.example.hiraganamaster.AdatbazisSegito;
import com.example.hiraganamaster.Modification;
import com.example.hiraganamaster.R;
import com.example.hiraganamaster.ui.hiraganamasterhome.HiraganaMasterHomeFragment;

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
        TextView tn = getView().findViewById(R.id.textviewname);
        tw.setText("Hiragana");
        if(seged.isEmpty()) {

            if (betu.equals("a")) {
                ivLearn.setImageResource(R.drawable.qa);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "a";
            } else if (betu.equals("i")) {
                ivLearn.setImageResource(R.drawable.qi);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "i";
            } else if (betu.equals("u")) {
                ivLearn.setImageResource(R.drawable.qu);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "u";
            } else if (betu.equals("e")) {
                ivLearn.setImageResource(R.drawable.qe);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "e";
            } else if (betu.equals("o")) {
                ivLearn.setImageResource(R.drawable.qo);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "o";
            } else if (betu.equals("ka")) {
                ivLearn.setImageResource(R.drawable.qka);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ka";
            } else if (betu.equals("ki")) {
                ivLearn.setImageResource(R.drawable.qki);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ki";
            } else if (betu.equals("ku")) {
                ivLearn.setImageResource(R.drawable.qku);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ku";
            } else if (betu.equals("ke")) {
                ivLearn.setImageResource(R.drawable.qke);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ke";
            } else if (betu.equals("ko")) {
                ivLearn.setImageResource(R.drawable.qko);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ko";
            } else if (betu.equals("sa")) {
                ivLearn.setImageResource(R.drawable.qsa);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "sa";
            } else if (betu.equals("shi")) {
                ivLearn.setImageResource(R.drawable.qshi);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "shi";
            } else if (betu.equals("su")) {
                ivLearn.setImageResource(R.drawable.qsu);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "su";
            } else if (betu.equals("se")) {
                ivLearn.setImageResource(R.drawable.qse);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "se";
            } else if (betu.equals("so")) {
                ivLearn.setImageResource(R.drawable.qso);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "so";
            } else if (betu.equals("ta")) {
                ivLearn.setImageResource(R.drawable.qta);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ta";
            } else if (betu.equals("chi")) {
                ivLearn.setImageResource(R.drawable.qchi);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "chi";
            } else if (betu.equals("tsu")) {
                ivLearn.setImageResource(R.drawable.qtsu);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "stu";
            } else if (betu.equals("te")) {
                ivLearn.setImageResource(R.drawable.qte);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "te";
            } else if (betu.equals("to")) {
                ivLearn.setImageResource(R.drawable.qto);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "to";
            } else if (betu.equals("na")) {
                ivLearn.setImageResource(R.drawable.qna);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "na";
            } else if (betu.equals("ni")) {
                ivLearn.setImageResource(R.drawable.qni);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ni";
            } else if (betu.equals("nu")) {
                ivLearn.setImageResource(R.drawable.qnu);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "nu";
            } else if (betu.equals("ne")) {
                ivLearn.setImageResource(R.drawable.qne);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ne";
            } else if (betu.equals("no")) {
                ivLearn.setImageResource(R.drawable.qno);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "no";
            } else if (betu.equals("ha")) {
                ivLearn.setImageResource(R.drawable.qha);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ha";
            } else if (betu.equals("hi")) {
                ivLearn.setImageResource(R.drawable.qhi);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "hi";
            } else if (betu.equals("fu")) {
                ivLearn.setImageResource(R.drawable.qfu);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "fu";
            } else if (betu.equals("he")) {
                ivLearn.setImageResource(R.drawable.qhe);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "he";
            } else if (betu.equals("ho")) {
                ivLearn.setImageResource(R.drawable.qho);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ho";
            } else if (betu.equals("ma")) {
                ivLearn.setImageResource(R.drawable.qma);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ma";
            } else if (betu.equals("mi")) {
                ivLearn.setImageResource(R.drawable.qmi);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "mi";
            } else if (betu.equals("mu")) {
                ivLearn.setImageResource(R.drawable.qmu);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "mu";
            } else if (betu.equals("me")) {
                ivLearn.setImageResource(R.drawable.qme);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "me";
            } else if (betu.equals("mo")) {
                ivLearn.setImageResource(R.drawable.qmo);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "mo";
            } else if (betu.equals("ya")) {
                ivLearn.setImageResource(R.drawable.qya);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ya";
            } else if (betu.equals("yu")) {
                ivLearn.setImageResource(R.drawable.qyu);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "yu";
            } else if (betu.equals("yo")) {
                ivLearn.setImageResource(R.drawable.qyo);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "yo";
            } else if (betu.equals("ra")) {
                ivLearn.setImageResource(R.drawable.qra);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ra";
            } else if (betu.equals("ri")) {
                ivLearn.setImageResource(R.drawable.qri);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ri";
            } else if (betu.equals("ru")) {
                ivLearn.setImageResource(R.drawable.qru);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ru";
            } else if (betu.equals("re")) {
                ivLearn.setImageResource(R.drawable.qre);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "re";
            } else if (betu.equals("ro")) {
                ivLearn.setImageResource(R.drawable.qro);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "ro";
            } else if (betu.equals("wa")) {
                ivLearn.setImageResource(R.drawable.qwa);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "wa";
            } else if (betu.equals("wo")) {
                ivLearn.setImageResource(R.drawable.qwo);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "wo";
            } else if (betu.equals("n")) {
                ivLearn.setImageResource(R.drawable.qn);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
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
                    } else if (betu.equals("sa")) {
                        playSa.start();
                    } else if (betu.equals("si")) {
                        playShi.start();
                    } else if (betu.equals("su")) {
                        playSu.start();
                    } else if (betu.equals("se")) {
                        playSe.start();
                    } else if (betu.equals("so")) {
                        playSo.start();
                    }
                }else if (seged.equals("a")) {
                    playA.start();
                } else if (seged.equals("i")) {
                    playI.start();
                } else if (seged.equals("u")) {
                    playU.start();
                } else if (seged.equals("e")) {
                    playE.start();
                } else if (seged.equals("o")) {
                    playO.start();
                } else if (seged.equals("ka")) {
                    playKa.start();
                } else if (seged.equals("ki")) {
                    playKi.start();
                } else if (seged.equals("ku")) {
                    playKu.start();
                } else if (seged.equals("ke")) {
                    playKe.start();
                } else if (seged.equals("ko")) {
                    playKo.start();
                } else if (seged.equals("sa")) {
                    playSa.start();
                } else if (seged.equals("si")) {
                    playShi.start();
                } else if (seged.equals("su")) {
                    playSu.start();
                } else if (seged.equals("se")) {
                    playSe.start();
                } else if (seged.equals("so")) {
                    playSo.start();
                }
            }
        });

        final Button fav = getView().findViewById(R.id.btnfavorite);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seged == "") {
                    if (betu.equals("a")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        Favorite();
                    } else if(betu.equals("i")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        Favorite();
                    }
                }
                else if(seged.equals("a"))
                {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                    Favorite();
                }
            }
        });

        Button toLeft = getView().findViewById(R.id.toLeft);
        final Button toRight = getView().findViewById(R.id.toRight);

        toRight.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                 Toast.makeText(getContext(), "To rigth", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        toLeft.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                 Toast.makeText(getContext(), "To left", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        toRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tw = getView().findViewById(R.id.textviewhiragana);
                ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                TextView tn = getView().findViewById(R.id.textviewname);

                if(seged.equals("a"))
                {
                    ivLearn.setImageResource(R.drawable.qi);
                    seged = "i";
                    tw.setText("Hiragana i");
                    tn.setText("i");
                }
                else if(seged.equals("i"))
                {
                    ivLearn.setImageResource(R.drawable.qu);
                    seged = "u";
                    tw.setText("Hiragana u");
                    tn.setText("u");
                }
                else if(seged.equals("i"))
                {
                    ivLearn.setImageResource(R.drawable.qu);
                    seged = "u";
                    tw.setText("Hiragana u");
                    tn.setText("u");
                }
                else if(seged.equals("u"))
                {
                    ivLearn.setImageResource(R.drawable.qe);
                    seged = "e";
                    tw.setText("Hiragana e");
                    tn.setText("e");
                }
                else if(seged.equals("e"))
                {
                    ivLearn.setImageResource(R.drawable.qo);
                    seged = "o";
                    tw.setText("Hiaragana o");
                    tn.setText("o");
                }
                else if(seged.equals("o"))
                {
                    ivLearn.setImageResource(R.drawable.qka);
                    seged = "ka";
                    tw.setText("Hiaragana ka");
                    tn.setText("ka");
                }
                else if(seged.equals("ka"))
                {
                    ivLearn.setImageResource(R.drawable.qki);
                    seged = "ki";
                    tw.setText("Hiaragana ki");
                    tn.setText("ki");
                }
                else if(seged.equals("ki"))
                {
                    ivLearn.setImageResource(R.drawable.qku);
                    seged = "ku";
                    tw.setText("Hiaragana ku");
                    tn.setText("ku");
                }
                else if(seged.equals("ku"))
                {
                    ivLearn.setImageResource(R.drawable.qke);
                    seged = "ke";
                    tw.setText("Hiaragana ke");
                    tn.setText("ke");
                }
                else if(seged.equals("ke"))
                {
                    ivLearn.setImageResource(R.drawable.qko);
                    seged = "ko";
                    tw.setText("Hiaragana ko");
                    tn.setText("ko");
                }
                else if(seged.equals("ko"))
                {
                    ivLearn.setImageResource(R.drawable.qsa);
                    seged = "sa";
                    tw.setText("Hiaragana sa");
                    tn.setText("sa");
                }
                else if(seged.equals("sa"))
                {
                    ivLearn.setImageResource(R.drawable.qshi);
                    seged = "shi";
                    tw.setText("Hiaragana shi");
                    tn.setText("shi");
                }
                else if(seged.equals("shi"))
                {
                    ivLearn.setImageResource(R.drawable.qsu);
                    seged = "su";
                    tw.setText("Hiaragana su");
                    tn.setText("su");
                }
                else if(seged.equals("su"))
                {
                    ivLearn.setImageResource(R.drawable.qse);
                    seged = "se";
                    tw.setText("Hiaragana se");
                    tn.setText("se");
                }
                else if(seged.equals("se"))
                {
                    ivLearn.setImageResource(R.drawable.qso);
                    seged = "so";
                    tw.setText("Hiaragana so");
                    tn.setText("so");
                }
                else if(seged.equals("so"))
                {
                    ivLearn.setImageResource(R.drawable.qta);
                    seged = "ta";
                    tw.setText("Hiaragana ta");
                    tn.setText("ta");
                }
                else if(seged.equals("ta"))
                {
                    ivLearn.setImageResource(R.drawable.qchi);
                    seged = "chi";
                    tw.setText("Hiaragana chi");
                    tn.setText("chi");
                }
                else if(seged.equals("chi"))
                {
                    ivLearn.setImageResource(R.drawable.qtsu);
                    seged = "tsu";
                    tw.setText("Hiaragana tsu");
                    tn.setText("tsu");
                }
                else if(seged.equals("tsu"))
                {
                    ivLearn.setImageResource(R.drawable.qte);
                    seged = "te";
                    tw.setText("Hiaragana te");
                    tn.setText("te");
                }
                else if(seged.equals("te"))
                {
                    ivLearn.setImageResource(R.drawable.qto);
                    seged = "to";
                    tw.setText("Hiaragana to");
                    tn.setText("to");
                }
                else if(seged.equals("to"))
                {
                    ivLearn.setImageResource(R.drawable.qna);
                    seged = "na";
                    tw.setText("Hiaragana na");
                    tn.setText("na");
                }
                else if(seged.equals("na"))
                {
                    ivLearn.setImageResource(R.drawable.qni);
                    seged = "ni";
                    tw.setText("Hiaragana ni");
                    tn.setText("ni");
                }
                else if(seged.equals("ni"))
                {
                    ivLearn.setImageResource(R.drawable.qnu);
                    seged = "nu";
                    tw.setText("Hiaragana nu");
                    tn.setText("nu");
                }
                else if(seged.equals("nu"))
                {
                    ivLearn.setImageResource(R.drawable.qne);
                    seged = "ne";
                    tw.setText("Hiaragana ne");
                    tn.setText("ne");
                }
                else if(seged.equals("ne"))
                {
                    ivLearn.setImageResource(R.drawable.qno);
                    seged = "no";
                    tw.setText("Hiaragana no");
                    tn.setText("no");
                }
                else if(seged.equals("no"))
                {
                    ivLearn.setImageResource(R.drawable.qha);
                    seged = "ha";
                    tw.setText("Hiaragana ha");
                    tn.setText("ha");
                }
                else if(seged.equals("ha"))
                {
                    ivLearn.setImageResource(R.drawable.qhi);
                    seged = "hi";
                    tw.setText("Hiaragana hi");
                    tn.setText("hi");
                }
                else if(seged.equals("hi"))
                {
                    ivLearn.setImageResource(R.drawable.qfu);
                    seged = "fu";
                    tw.setText("Hiaragana fu");
                    tn.setText("fu");
                }
                else if(seged.equals("fu"))
                {
                    ivLearn.setImageResource(R.drawable.qhe);
                    seged = "he";
                    tw.setText("Hiaragana he");
                    tn.setText("he");
                }
                else if(seged.equals("he"))
                {
                    ivLearn.setImageResource(R.drawable.qho);
                    seged = "ho";
                    tw.setText("Hiaragana ho");
                    tn.setText("ho");
                }
                else if(seged.equals("ho"))
                {
                    ivLearn.setImageResource(R.drawable.qma);
                    seged = "ma";
                    tw.setText("Hiaragana ma");
                    tn.setText("ma");
                }
                else if(seged.equals("ma"))
                {
                    ivLearn.setImageResource(R.drawable.qmi);
                    seged = "mi";
                    tw.setText("Hiaragana mi");
                    tn.setText("mi");
                }
                else if(seged.equals("mi"))
                {
                    ivLearn.setImageResource(R.drawable.qmu);
                    seged = "mu";
                    tw.setText("Hiaragana mu");
                    tn.setText("mu");
                }
                else if(seged.equals("mu"))
                {
                    ivLearn.setImageResource(R.drawable.qme);
                    seged = "me";
                    tw.setText("Hiaragana me");
                    tn.setText("me");
                }
                else if(seged.equals("me"))
                {
                    ivLearn.setImageResource(R.drawable.qmo);
                    seged = "mo";
                    tw.setText("Hiaragana mo");
                    tn.setText("mo");
                }
                else if(seged.equals("mo"))
                {
                    ivLearn.setImageResource(R.drawable.qya);
                    seged = "ya";
                    tw.setText("Hiaragana ya");
                    tn.setText("ya");
                }
                else if(seged.equals("ya"))
                {
                    ivLearn.setImageResource(R.drawable.qyu);
                    seged = "yu";
                    tw.setText("Hiaragana yu");
                    tn.setText("yu");
                }
                else if(seged.equals("yu"))
                {
                    ivLearn.setImageResource(R.drawable.qyo);
                    seged = "yo";
                    tw.setText("Hiaragana yo");
                    tn.setText("yo");
                }
                else if(seged.equals("yo"))
                {
                    ivLearn.setImageResource(R.drawable.qra);
                    seged = "ra";
                    tw.setText("Hiaragana ra");
                    tn.setText("ra");
                }
                else if(seged.equals("ra"))
                {
                    ivLearn.setImageResource(R.drawable.qri);
                    seged = "ri";
                    tw.setText("Hiaragana ri");
                    tn.setText("ri");
                }
                else if(seged.equals("ri"))
                {
                    ivLearn.setImageResource(R.drawable.qru);
                    seged = "ru";
                    tw.setText("Hiaragana ru");
                    tn.setText("ru");
                }
                else if(seged.equals("ru"))
                {
                    ivLearn.setImageResource(R.drawable.qre);
                    seged = "re";
                    tw.setText("Hiaragana re");
                    tn.setText("re");
                }
                else if(seged.equals("re"))
                {
                    ivLearn.setImageResource(R.drawable.qro);
                    seged = "ro";
                    tw.setText("Hiaragana ro");
                    tn.setText("ro");
                }
                else if(seged.equals("ro"))
                {
                    ivLearn.setImageResource(R.drawable.qwa);
                    seged = "wa";
                    tw.setText("Hiaragana wa");
                    tn.setText("wa");
                }
                else if(seged.equals("wa"))
                {
                    ivLearn.setImageResource(R.drawable.qwo);
                    seged = "wo";
                    tw.setText("Hiaragana wo");
                    tn.setText("wo");
                }
                else if(seged.equals("wo"))
                {
                    ivLearn.setImageResource(R.drawable.qn);
                    seged = "n";
                    tw.setText("Hiaragana n");
                    tn.setText("n");
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
                TextView tn = getView().findViewById(R.id.textviewname);

                if(seged.equals("a"))
                {
                    Toast.makeText(getContext(), "Hiba", Toast.LENGTH_SHORT).show();
                }
                else if(seged.equals("i"))
                {
                    ivLearn.setImageResource(R.drawable.qa);
                    seged = "a";
                    tw.setText("Hiragana a");
                    tn.setText("a");
                }
                else if(seged.equals("u"))
                {
                    ivLearn.setImageResource(R.drawable.qi);
                    seged = "i";
                    tw.setText("Hiragana i");
                }
                else if(seged.equals("e"))
                {
                    ivLearn.setImageResource(R.drawable.qu);
                    seged = "u";
                    tw.setText("Hiragana u");
                }
                else if(seged.equals("o"))
                {
                    ivLearn.setImageResource(R.drawable.qe);
                    seged = "e";
                    tw.setText("Hiragana e");
                }
                else if(seged.equals("ka"))
                {
                    ivLearn.setImageResource(R.drawable.qo);
                    seged = "o";
                    tw.setText("Hiragana o");
                }
                else if(seged.equals("ki"))
                {
                    ivLearn.setImageResource(R.drawable.qka);
                    seged = "ka";
                    tw.setText("Hiragana ka");
                }
                else if(seged.equals("ku"))
                {
                    ivLearn.setImageResource(R.drawable.qki);
                    seged = "ki";
                    tw.setText("Hiragana ki");
                }
                else if(seged.equals("ke"))
                {
                    ivLearn.setImageResource(R.drawable.qku);
                    seged = "ku";
                    tw.setText("Hiragana ku");
                }
                else if(seged.equals("ko"))
                {
                    ivLearn.setImageResource(R.drawable.qke);
                    seged = "ke";
                    tw.setText("Hiragana ke");
                }
                else if(seged.equals("sa"))
                {
                    ivLearn.setImageResource(R.drawable.qko);
                    seged = "ko";
                    tw.setText("Hiragana ko");
                }
            }
        });
    }
    final AdatbazisSegito dbhelper = new AdatbazisSegito(getContext());
    private void Favorite()
    {
        final AdatbazisSegito db = new AdatbazisSegito(getContext());
        Cursor cursorAdatok = dbhelper.idLekerdez();
        StringBuffer stringBuffer = new StringBuffer();
        int id = 0;
        while (cursorAdatok.moveToNext()) {
            stringBuffer.append(cursorAdatok.getInt(0));
            id = cursorAdatok.getInt(0);
        }
        TextView tw = getView().findViewById(R.id.textviewname);
        String felvetel = tw.getText().toString();

        tw.setText("proba"+felvetel);

        boolean eredmeny = db.insertFavorite(id,felvetel);
        if (eredmeny)
        {
            Toast.makeText(getActivity(), "Successfully added to favorites!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getActivity(), "Unsuccessful via server error", Toast.LENGTH_SHORT).show();
        }

    }
}
