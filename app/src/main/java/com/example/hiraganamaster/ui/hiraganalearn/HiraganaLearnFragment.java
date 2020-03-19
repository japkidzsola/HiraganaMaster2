package com.example.hiraganamaster.ui.hiraganalearn;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
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

import java.util.ArrayList;
import java.util.Objects;

import static java.util.Objects.*;

public class HiraganaLearnFragment extends Fragment {

    private HiraganaLearnViewModel mViewModel;
    private static String betu;

    private Button btnplay;

    private final AdatbazisSegito dbhelper = new AdatbazisSegito(getContext());

    MediaPlayer mp;

    public String seged = "";

    private static String balra;
    private static String jobbra;

    private static String regikedvenc;

    public String[] aiueo = {"nincs","a","i","u","e","o","ka","ki","ku","ke","ko","sa","shi","su","se","so","ta","chi","tsu","te","to"};

    public int[] aiueoindex = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};


    public static HiraganaLearnFragment newInstance(String betu, String balra, String jobbra, String adatb) {
        HiraganaLearnFragment.betu = betu;
        HiraganaLearnFragment.balra = balra;
        HiraganaLearnFragment.jobbra = jobbra;
        HiraganaLearnFragment.regikedvenc = adatb;
        return new HiraganaLearnFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.hiragana_learn_fragment, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("SetTextI18n")
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

        final MediaPlayer playTa = MediaPlayer.create(getContext(), R.raw.ta);
        final MediaPlayer playChi = MediaPlayer.create(getContext(), R.raw.chi);
        final MediaPlayer playTsu = MediaPlayer.create(getContext(), R.raw.tsu);
        final MediaPlayer playTe = MediaPlayer.create(getContext(), R.raw.te);
        final MediaPlayer playTo = MediaPlayer.create(getContext(), R.raw.to);

        final MediaPlayer playNa = MediaPlayer.create(getContext(), R.raw.na);
        final MediaPlayer playNi = MediaPlayer.create(getContext(), R.raw.ni);
        final MediaPlayer playNu = MediaPlayer.create(getContext(), R.raw.nu);
        final MediaPlayer playNe = MediaPlayer.create(getContext(), R.raw.ne);
        final MediaPlayer playNo = MediaPlayer.create(getContext(), R.raw.no);

        final MediaPlayer playHa = MediaPlayer.create(getContext(), R.raw.ha);
        final MediaPlayer playHi = MediaPlayer.create(getContext(), R.raw.hi);
        final MediaPlayer playFu = MediaPlayer.create(getContext(), R.raw.fu);
        final MediaPlayer playHe = MediaPlayer.create(getContext(), R.raw.he);
        final MediaPlayer playHo = MediaPlayer.create(getContext(), R.raw.ho);

        final MediaPlayer playMa = MediaPlayer.create(getContext(), R.raw.ma);
        final MediaPlayer playMi = MediaPlayer.create(getContext(), R.raw.mi);
        final MediaPlayer playMu = MediaPlayer.create(getContext(), R.raw.mu);
        final MediaPlayer playMe = MediaPlayer.create(getContext(), R.raw.me);
        final MediaPlayer playMo = MediaPlayer.create(getContext(), R.raw.mo);

        final MediaPlayer playYa = MediaPlayer.create(getContext(), R.raw.ya);
        final MediaPlayer playYu = MediaPlayer.create(getContext(), R.raw.yu);
        final MediaPlayer playYo = MediaPlayer.create(getContext(), R.raw.yo);

        final MediaPlayer playRa = MediaPlayer.create(getContext(), R.raw.ra);
        final MediaPlayer playRi = MediaPlayer.create(getContext(), R.raw.ri);
        final MediaPlayer playRu = MediaPlayer.create(getContext(), R.raw.ru);
        final MediaPlayer playRe = MediaPlayer.create(getContext(), R.raw.re);
        final MediaPlayer playRo = MediaPlayer.create(getContext(), R.raw.ro);

        final MediaPlayer playWa = MediaPlayer.create(getContext(), R.raw.wa);
        final MediaPlayer playWo = MediaPlayer.create(getContext(), R.raw.wo);
        final MediaPlayer playN = MediaPlayer.create(getContext(), R.raw.n);


        TextView tw;
        tw = requireNonNull(getView()).findViewById(R.id.textviewhiragana);
        ImageView ivLearn = getView().findViewById(R.id.ivLearn);
        TextView tn = getView().findViewById(R.id.textviewname);
        tw.setText("Hiragana");

        tw.setText(regikedvenc);

        ArrayList<String> regikedvencek = new ArrayList<String>();
        String [] regi ;
        String [] uj ;

        /*Cursor cursorAdatok = dbhelper.adatLekerdezes();
        if (cursorAdatok == null){
            Toast.makeText(getContext(),
                    "Sikertlen Adatlekérdezés", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cursorAdatok.getCount() == 0){
            Toast.makeText(getContext(),
                    "Nincs még felvéve adat", Toast.LENGTH_SHORT).show();
            return;
        }*/
        /*StringBuffer stringBuffer = new StringBuffer();
        while (cursorAdatok.moveToNext()){
                stringBuffer.append(cursorAdatok.getString(4));
        }
        String adatbaziskedvenc = stringBuffer.toString();

        String[] sor = adatbaziskedvenc.split(",");
        String kedvenc = sor[0];
        regikedvencek.add(kedvenc);
        Toast.makeText(getContext(), "sikeres", Toast.LENGTH_SHORT).show();*/

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
                if(seged.equals("")) {
                    switch (betu) {
                        case "a":
                            playA.start();
                            break;
                        case "i":
                            playI.start();
                            break;
                        case "u":
                            playU.start();
                            break;
                        case "e":
                            playE.start();
                            break;
                        case "o":
                            playO.start();
                            break;
                        case "ka":
                            playKa.start();
                            break;
                        case "ki":
                            playKi.start();
                            break;
                        case "ku":
                            playKu.start();
                            break;
                        case "ke":
                            playKe.start();
                            break;
                        case "ko":
                            playKo.start();
                            break;
                        case "sa":
                            playSa.start();
                            break;
                        case "si":
                            playShi.start();
                            break;
                        case "su":
                            playSu.start();
                            break;
                        case "se":
                            playSe.start();
                            break;
                        case "so":
                            playSo.start();
                            break;
                        case "ta":
                            playTa.start();
                            break;
                        case "chi":
                            playChi.start();
                            break;
                        case "tsu":
                            playTsu.start();
                            break;
                        case "te":
                            playTe.start();
                            break;
                        case "to":
                            playTo.start();
                            break;
                        case "na":
                            playNa.start();
                            break;
                        case "ni":
                            playNi.start();
                            break;
                        case "nu":
                            playNu.start();
                            break;
                        case "ne":
                            playNe.start();
                            break;
                        case "no":
                            playNo.start();
                            break;
                        case "ha":
                            playHa.start();
                            break;
                        case "hi":
                            playHi.start();
                            break;
                        case "fu":
                            playFu.start();
                            break;
                        case "he":
                            playHe.start();
                            break;
                        case "ho":
                            playHo.start();
                            break;
                        case "ma":
                            playMa.start();
                            break;
                        case "mi":
                            playMi.start();
                            break;
                        case "mu":
                            playMu.start();
                            break;
                        case "me":
                            playMe.start();
                            break;
                        case "mo":
                            playMo.start();
                            break;
                        case "ya":
                            playYa.start();
                            break;
                        case "yu":
                            playYu.start();
                            break;
                        case "yo":
                            playYo.start();
                            break;
                        case "ra":
                            playRa.start();
                            break;
                        case "ri":
                            playRi.start();
                            break;
                        case "ru":
                            playRu.start();
                            break;
                        case "re":
                            playRe.start();
                            break;
                        case "ro":
                            playRo.start();
                            break;
                        case "wa":
                            playWa.start();
                            break;
                        case "wo":
                            playWo.start();
                            break;
                        case "n":
                            playN.start();
                            break;
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
                } else if (betu.equals("ta")) {
                    playTa.start();
                } else if (betu.equals("chi")) {
                    playChi.start();
                } else if (betu.equals("tsu")) {
                    playTsu.start();
                } else if (betu.equals("te")) {
                    playTe.start();
                } else if (betu.equals("to")) {
                    playTo.start();
                } else if (betu.equals("na")) {
                    playNa.start();
                } else if (betu.equals("ni")) {
                    playNi.start();
                } else if (betu.equals("nu")) {
                    playNu.start();
                } else if (betu.equals("ne")) {
                    playNe.start();
                } else if (betu.equals("no")) {
                    playNo.start();
                } else if (betu.equals("ha")) {
                    playHa.start();
                } else if (betu.equals("hi")) {
                    playHi.start();
                } else if (betu.equals("fu")) {
                    playFu.start();
                } else if (betu.equals("he")) {
                    playHe.start();
                } else if (betu.equals("ho")) {
                    playHo.start();
                } else if (betu.equals("ma")) {
                    playMa.start();
                } else if (betu.equals("mi")) {
                    playMi.start();
                } else if (betu.equals("mu")) {
                    playMu.start();
                } else if (betu.equals("me")) {
                    playMe.start();
                } else if (betu.equals("mo")) {
                    playMo.start();
                } else if (betu.equals("ya")) {
                    playYa.start();
                } else if (betu.equals("yu")) {
                    playYu.start();
                } else if (betu.equals("yo")) {
                    playYo.start();
                } else if (betu.equals("ra")) {
                    playRa.start();
                } else if (betu.equals("ri")) {
                    playRi.start();
                } else if (betu.equals("ru")) {
                    playRu.start();
                } else if (betu.equals("re")) {
                    playRe.start();
                } else if (betu.equals("ro")) {
                    playRo.start();
                } else if (betu.equals("wa")) {
                    playWa.start();
                } else if (betu.equals("wo")) {
                    playWo.start();
                } else if (betu.equals("n")) {
                    playN.start();
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
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                TextView tw;
                tw = Objects.<View>requireNonNull(getView()).findViewById(R.id.textviewhiragana);
                ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                TextView tn = getView().findViewById(R.id.textviewname);

                switch (seged) {
                    case "a":
                        ivLearn.setImageResource(R.drawable.qi);
                        seged = "i";
                        tw.setText("Hiragana i");
                        tn.setText("i");
                        break;
                    case "i":
                        ivLearn.setImageResource(R.drawable.qu);
                        seged = "u";
                        tw.setText("Hiragana u");
                        tn.setText("u");
                        break;
                    case "u":
                        ivLearn.setImageResource(R.drawable.qe);
                        seged = "e";
                        tw.setText("Hiragana e");
                        tn.setText("e");
                        break;
                    case "e":
                        ivLearn.setImageResource(R.drawable.qo);
                        seged = "o";
                        tw.setText("Hiaragana o");
                        tn.setText("o");
                        break;
                    case "o":
                        ivLearn.setImageResource(R.drawable.qka);
                        seged = "ka";
                        tw.setText("Hiaragana ka");
                        tn.setText("ka");
                        break;
                    case "ka":
                        ivLearn.setImageResource(R.drawable.qki);
                        seged = "ki";
                        tw.setText("Hiaragana ki");
                        tn.setText("ki");
                        break;
                    case "ki":
                        ivLearn.setImageResource(R.drawable.qku);
                        seged = "ku";
                        tw.setText("Hiaragana ku");
                        tn.setText("ku");
                        break;
                    case "ku":
                        ivLearn.setImageResource(R.drawable.qke);
                        seged = "ke";
                        tw.setText("Hiaragana ke");
                        tn.setText("ke");
                        break;
                    case "ke":
                        ivLearn.setImageResource(R.drawable.qko);
                        seged = "ko";
                        tw.setText("Hiaragana ko");
                        tn.setText("ko");
                        break;
                    case "ko":
                        ivLearn.setImageResource(R.drawable.qsa);
                        seged = "sa";
                        tw.setText("Hiaragana sa");
                        tn.setText("sa");
                        break;
                    case "sa":
                        ivLearn.setImageResource(R.drawable.qshi);
                        seged = "shi";
                        tw.setText("Hiaragana shi");
                        tn.setText("shi");
                        break;
                    case "shi":
                        ivLearn.setImageResource(R.drawable.qsu);
                        seged = "su";
                        tw.setText("Hiaragana su");
                        tn.setText("su");
                        break;
                    case "su":
                        ivLearn.setImageResource(R.drawable.qse);
                        seged = "se";
                        tw.setText("Hiaragana se");
                        tn.setText("se");
                        break;
                    case "se":
                        ivLearn.setImageResource(R.drawable.qso);
                        seged = "so";
                        tw.setText("Hiaragana so");
                        tn.setText("so");
                        break;
                    case "so":
                        ivLearn.setImageResource(R.drawable.qta);
                        seged = "ta";
                        tw.setText("Hiaragana ta");
                        tn.setText("ta");
                        break;
                    case "ta":
                        ivLearn.setImageResource(R.drawable.qchi);
                        seged = "chi";
                        tw.setText("Hiaragana chi");
                        tn.setText("chi");
                        break;
                    case "chi":
                        ivLearn.setImageResource(R.drawable.qtsu);
                        seged = "tsu";
                        tw.setText("Hiaragana tsu");
                        tn.setText("tsu");
                        break;
                    case "tsu":
                        ivLearn.setImageResource(R.drawable.qte);
                        seged = "te";
                        tw.setText("Hiaragana te");
                        tn.setText("te");
                        break;
                    case "te":
                        ivLearn.setImageResource(R.drawable.qto);
                        seged = "to";
                        tw.setText("Hiaragana to");
                        tn.setText("to");
                        break;
                    case "to":
                        ivLearn.setImageResource(R.drawable.qna);
                        seged = "na";
                        tw.setText("Hiaragana na");
                        tn.setText("na");
                        break;
                    case "na":
                        ivLearn.setImageResource(R.drawable.qni);
                        seged = "ni";
                        tw.setText("Hiaragana ni");
                        tn.setText("ni");
                        break;
                    case "ni":
                        ivLearn.setImageResource(R.drawable.qnu);
                        seged = "nu";
                        tw.setText("Hiaragana nu");
                        tn.setText("nu");
                        break;
                    case "nu":
                        ivLearn.setImageResource(R.drawable.qne);
                        seged = "ne";
                        tw.setText("Hiaragana ne");
                        tn.setText("ne");
                        break;
                    case "ne":
                        ivLearn.setImageResource(R.drawable.qno);
                        seged = "no";
                        tw.setText("Hiaragana no");
                        tn.setText("no");
                        break;
                    case "no":
                        ivLearn.setImageResource(R.drawable.qha);
                        seged = "ha";
                        tw.setText("Hiaragana ha");
                        tn.setText("ha");
                        break;
                    case "ha":
                        ivLearn.setImageResource(R.drawable.qhi);
                        seged = "hi";
                        tw.setText("Hiaragana hi");
                        tn.setText("hi");
                        break;
                    case "hi":
                        ivLearn.setImageResource(R.drawable.qfu);
                        seged = "fu";
                        tw.setText("Hiaragana fu");
                        tn.setText("fu");
                        break;
                    case "fu":
                        ivLearn.setImageResource(R.drawable.qhe);
                        seged = "he";
                        tw.setText("Hiaragana he");
                        tn.setText("he");
                        break;
                    case "he":
                        ivLearn.setImageResource(R.drawable.qho);
                        seged = "ho";
                        tw.setText("Hiaragana ho");
                        tn.setText("ho");
                        break;
                    case "ho":
                        ivLearn.setImageResource(R.drawable.qma);
                        seged = "ma";
                        tw.setText("Hiaragana ma");
                        tn.setText("ma");
                        break;
                    case "ma":
                        ivLearn.setImageResource(R.drawable.qmi);
                        seged = "mi";
                        tw.setText("Hiaragana mi");
                        tn.setText("mi");
                        break;
                    case "mi":
                        ivLearn.setImageResource(R.drawable.qmu);
                        seged = "mu";
                        tw.setText("Hiaragana mu");
                        tn.setText("mu");
                        break;
                    case "mu":
                        ivLearn.setImageResource(R.drawable.qme);
                        seged = "me";
                        tw.setText("Hiaragana me");
                        tn.setText("me");
                        break;
                    case "me":
                        ivLearn.setImageResource(R.drawable.qmo);
                        seged = "mo";
                        tw.setText("Hiaragana mo");
                        tn.setText("mo");
                        break;
                    case "mo":
                        ivLearn.setImageResource(R.drawable.qya);
                        seged = "ya";
                        tw.setText("Hiaragana ya");
                        tn.setText("ya");
                        break;
                    case "ya":
                        ivLearn.setImageResource(R.drawable.qyu);
                        seged = "yu";
                        tw.setText("Hiaragana yu");
                        tn.setText("yu");
                        break;
                    case "yu":
                        ivLearn.setImageResource(R.drawable.qyo);
                        seged = "yo";
                        tw.setText("Hiaragana yo");
                        tn.setText("yo");
                        break;
                    case "yo":
                        ivLearn.setImageResource(R.drawable.qra);
                        seged = "ra";
                        tw.setText("Hiaragana ra");
                        tn.setText("ra");
                        break;
                    case "ra":
                        ivLearn.setImageResource(R.drawable.qri);
                        seged = "ri";
                        tw.setText("Hiaragana ri");
                        tn.setText("ri");
                        break;
                    case "ri":
                        ivLearn.setImageResource(R.drawable.qru);
                        seged = "ru";
                        tw.setText("Hiaragana ru");
                        tn.setText("ru");
                        break;
                    case "ru":
                        ivLearn.setImageResource(R.drawable.qre);
                        seged = "re";
                        tw.setText("Hiaragana re");
                        tn.setText("re");
                        break;
                    case "re":
                        ivLearn.setImageResource(R.drawable.qro);
                        seged = "ro";
                        tw.setText("Hiaragana ro");
                        tn.setText("ro");
                        break;
                    case "ro":
                        ivLearn.setImageResource(R.drawable.qwa);
                        seged = "wa";
                        tw.setText("Hiaragana wa");
                        tn.setText("wa");
                        break;
                    case "wa":
                        ivLearn.setImageResource(R.drawable.qwo);
                        seged = "wo";
                        tw.setText("Hiaragana wo");
                        tn.setText("wo");
                        break;
                    case "wo":
                        ivLearn.setImageResource(R.drawable.qn);
                        seged = "n";
                        tw.setText("Hiaragana n");
                        tn.setText("n");
                        break;
                    case "n":
                        Toast.makeText(getContext(), "Hiba", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

        });

        toLeft.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                TextView tw;
                tw = requireNonNull(requireNonNull(getView())).<TextView>findViewById(R.id.textviewhiragana);
                ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                TextView tn = getView().findViewById(R.id.textviewname);

                switch (seged) {
                    case "a":
                        Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                        break;
                    case "i":
                        ivLearn.setImageResource(R.drawable.qa);
                        seged = "a";
                        tw.setText("Hiragana a");
                        tn.setText("a");
                        break;
                    case "u":
                        ivLearn.setImageResource(R.drawable.qi);
                        seged = "i";
                        tw.setText("Hiragana i");
                        break;
                    case "e":
                        ivLearn.setImageResource(R.drawable.qu);
                        seged = "u";
                        tw.setText("Hiragana u");
                        break;
                    case "o":
                        ivLearn.setImageResource(R.drawable.qe);
                        seged = "e";
                        tw.setText("Hiragana e");
                        break;
                    case "ka":
                        ivLearn.setImageResource(R.drawable.qo);
                        seged = "o";
                        tw.setText("Hiragana o");
                        break;
                    case "ki":
                        ivLearn.setImageResource(R.drawable.qka);
                        seged = "ka";
                        tw.setText("Hiragana ka");
                        break;
                    case "ku":
                        ivLearn.setImageResource(R.drawable.qki);
                        seged = "ki";
                        tw.setText("Hiragana ki");
                        break;
                    case "ke":
                        ivLearn.setImageResource(R.drawable.qku);
                        seged = "ku";
                        tw.setText("Hiragana ku");
                        break;
                    case "ko":
                        ivLearn.setImageResource(R.drawable.qke);
                        seged = "ke";
                        tw.setText("Hiragana ke");
                        break;
                    case "sa":
                        ivLearn.setImageResource(R.drawable.qko);
                        seged = "ko";
                        tw.setText("Hiragana ko");
                        break;
                    case "shi":
                        ivLearn.setImageResource(R.drawable.qsa);
                        seged = "sa";
                        tw.setText("Hiragana sa");
                        break;
                    case "su":
                        ivLearn.setImageResource(R.drawable.qshi);
                        seged = "shi";
                        tw.setText("Hiragana shi");
                        break;
                    case "se":
                        ivLearn.setImageResource(R.drawable.qsu);
                        seged = "su";
                        tw.setText("Hiragana su");
                        break;
                    case "so":
                        ivLearn.setImageResource(R.drawable.qse);
                        seged = "se";
                        tw.setText("Hiragana se");
                        break;
                    case "ta":
                        ivLearn.setImageResource(R.drawable.qso);
                        seged = "so";
                        tw.setText("Hiragana so");
                        break;
                    case "chi":
                        ivLearn.setImageResource(R.drawable.qta);
                        seged = "ta";
                        tw.setText("Hiragana ta");
                        break;
                    case "tsu":
                        ivLearn.setImageResource(R.drawable.qchi);
                        seged = "chi";
                        tw.setText("Hiragana chi");
                        break;
                    case "te":
                        ivLearn.setImageResource(R.drawable.qtsu);
                        seged = "tsu";
                        tw.setText("Hiragana tsu");
                        break;
                    case "to":
                        ivLearn.setImageResource(R.drawable.qte);
                        seged = "te";
                        tw.setText("Hiragana te");
                        break;
                    case "na":
                        ivLearn.setImageResource(R.drawable.qte);
                        seged = "te";
                        tw.setText("Hiragana te");
                        break;
                    case "ni":
                        ivLearn.setImageResource(R.drawable.qna);
                        seged = "na";
                        tw.setText("Hiragana na");
                        break;
                    case "nu":
                        ivLearn.setImageResource(R.drawable.qni);
                        seged = "ni";
                        tw.setText("Hiragana ni");
                        break;
                    case "ne":
                        ivLearn.setImageResource(R.drawable.qnu);
                        seged = "nu";
                        tw.setText("Hiragana nu");
                        break;
                    case "no":
                        ivLearn.setImageResource(R.drawable.qne);
                        seged = "ne";
                        tw.setText("Hiragana ne");
                        break;
                    case "ha":
                        ivLearn.setImageResource(R.drawable.qno);
                        seged = "no";
                        tw.setText("Hiragana no");
                        break;
                    case "hi":
                        ivLearn.setImageResource(R.drawable.qha);
                        seged = "ha";
                        tw.setText("Hiragana ha");
                        break;
                    case "fu":
                        ivLearn.setImageResource(R.drawable.qhi);
                        seged = "hi";
                        tw.setText("Hiragana hi");
                        break;
                    case "he":
                        ivLearn.setImageResource(R.drawable.qfu);
                        seged = "fu";
                        tw.setText("Hiragana fu");
                        break;
                    case "ho":
                        ivLearn.setImageResource(R.drawable.qhe);
                        seged = "he";
                        tw.setText("Hiragana he");
                        break;
                    case "ma":
                        ivLearn.setImageResource(R.drawable.qho);
                        seged = "ho";
                        tw.setText("Hiragana ho");
                        break;
                    case "mi":
                        ivLearn.setImageResource(R.drawable.qma);
                        seged = "ma";
                        tw.setText("Hiaragana ma");
                        tn.setText("ma");
                        break;
                    case "mu":
                        ivLearn.setImageResource(R.drawable.qmi);
                        seged = "mi";
                        tw.setText("Hiaragana mi");
                        tn.setText("mi");
                        break;
                    case "me":
                        ivLearn.setImageResource(R.drawable.qmu);
                        seged = "mu";
                        tw.setText("Hiaragana mu");
                        tn.setText("mu");
                        break;
                    case "mo":
                        ivLearn.setImageResource(R.drawable.qme);
                        seged = "me";
                        tw.setText("Hiaragana me");
                        tn.setText("me");
                        break;
                    case "ya":
                        ivLearn.setImageResource(R.drawable.qmo);
                        seged = "mo";
                        tw.setText("Hiaragana mo");
                        tn.setText("mo");
                        break;
                    case "yu":
                        ivLearn.setImageResource(R.drawable.qya);
                        seged = "ya";
                        tw.setText("Hiaragana ya");
                        tn.setText("ya");
                        break;
                    case "yo":
                        ivLearn.setImageResource(R.drawable.qyu);
                        seged = "yu";
                        tw.setText("Hiaragana yu");
                        tn.setText("yu");
                        break;
                    case "ra":
                        ivLearn.setImageResource(R.drawable.qyo);
                        seged = "yo";
                        tw.setText("Hiaragana yo");
                        tn.setText("yo");
                        break;
                    case "ri":
                        ivLearn.setImageResource(R.drawable.qra);
                        seged = "ra";
                        tw.setText("Hiaragana ra");
                        tn.setText("ra");
                        break;
                    case "ru":
                        ivLearn.setImageResource(R.drawable.qri);
                        seged = "ri";
                        tw.setText("Hiaragana ri");
                        tn.setText("ri");
                        break;
                    case "re":
                        ivLearn.setImageResource(R.drawable.qru);
                        seged = "ru";
                        tw.setText("Hiaragana ru");
                        tn.setText("ru");
                        break;
                    case "ro":
                        ivLearn.setImageResource(R.drawable.qre);
                        seged = "re";
                        tw.setText("Hiaragana re");
                        tn.setText("re");
                        break;
                    case "wa":
                        ivLearn.setImageResource(R.drawable.qro);
                        seged = "ro";
                        tw.setText("Hiaragana ro");
                        tn.setText("ro");
                        break;
                    case "wo":
                        ivLearn.setImageResource(R.drawable.qwa);
                        seged = "wa";
                        tw.setText("Hiaragana wa");
                        tn.setText("wa");
                        break;
                    case "n":
                        ivLearn.setImageResource(R.drawable.qwo);
                        seged = "wo";
                        tw.setText("Hiaragana wo");
                        tn.setText("wo");
                        break;
                }

            }
        });
    }

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
