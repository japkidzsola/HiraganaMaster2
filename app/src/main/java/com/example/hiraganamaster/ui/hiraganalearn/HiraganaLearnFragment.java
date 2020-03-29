package com.example.hiraganamaster.ui.hiraganalearn;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.hiraganamaster.FavoriteHiraganas;
import com.example.hiraganamaster.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.*;

public class HiraganaLearnFragment extends Fragment {

    private HiraganaLearnViewModel mViewModel;
    private static String betu;

    MediaPlayer mp;

    public String seged = "";

    private static String balra;
    private static String jobbra;

    private static String regikedvenc;


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

        final FavoriteHiraganas f = new FavoriteHiraganas();
        final AdatbazisSegito dbhelper = new AdatbazisSegito(getActivity());
        final Cursor cursorAdatok = dbhelper.adatLekerdezes();
        if (cursorAdatok == null) {
            Toast.makeText(getActivity(),
                    "Sikertlen Adatlekérdezés", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cursorAdatok.getCount() == 0) {
            Toast.makeText(getActivity(),
                    "Nincs még felvéve adat", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (cursorAdatok.moveToNext()) {
            stringBuffer.append(cursorAdatok.getString(4));
            stringBuffer.append("," + cursorAdatok.getString(0));
        }
        String kedvencek = stringBuffer.toString();
        final String[] darabol = kedvencek.split(",");
        final int a = Integer.parseInt(darabol[0]);
        final int i = Integer.parseInt(darabol[1]);
        final int u = Integer.parseInt(darabol[2]);
        final int e = Integer.parseInt(darabol[3]);
        final int o = Integer.parseInt(darabol[4]);
        final int ka = Integer.parseInt(darabol[5]);
        final int ki = Integer.parseInt(darabol[6]);
        final int ku = Integer.parseInt(darabol[7]);
        final int ke = Integer.parseInt(darabol[8]);
        final int ko = Integer.parseInt(darabol[9]);
        final int sa = Integer.parseInt(darabol[10]);
        final int shi = Integer.parseInt(darabol[11]);
        final int su = Integer.parseInt(darabol[12]);
        final int se = Integer.parseInt(darabol[13]);
        final int so = Integer.parseInt(darabol[14]);
        final int ta = Integer.parseInt(darabol[15]);
        final int chi = Integer.parseInt(darabol[16]);
        final int tsu = Integer.parseInt(darabol[17]);
        final int te = Integer.parseInt(darabol[18]);
        final int to = Integer.parseInt(darabol[19]);
        final int na = Integer.parseInt(darabol[20]);
        final int ni = Integer.parseInt(darabol[21]);
        final int nu = Integer.parseInt(darabol[22]);
        final int ne = Integer.parseInt(darabol[23]);
        final int no = Integer.parseInt(darabol[24]);
        final int ha = Integer.parseInt(darabol[25]);
        final int hi = Integer.parseInt(darabol[26]);
        final int fu = Integer.parseInt(darabol[27]);
        final int he = Integer.parseInt(darabol[28]);
        final int ho = Integer.parseInt(darabol[29]);
        final int ma = Integer.parseInt(darabol[30]);
        final int mi = Integer.parseInt(darabol[31]);
        final int mu = Integer.parseInt(darabol[32]);
        final int me = Integer.parseInt(darabol[33]);
        final int mo = Integer.parseInt(darabol[34]);
        final int ya = Integer.parseInt(darabol[35]);
        final int yu = Integer.parseInt(darabol[36]);
        final int yo = Integer.parseInt(darabol[37]);
        final int ra = Integer.parseInt(darabol[38]);
        final int ri = Integer.parseInt(darabol[39]);
        final int ru = Integer.parseInt(darabol[40]);
        final int re = Integer.parseInt(darabol[41]);
        final int ro = Integer.parseInt(darabol[42]);
        final int wa = Integer.parseInt(darabol[43]);
        final int wo = Integer.parseInt(darabol[44]);
        final int n = Integer.parseInt(darabol[45]);

        StringBuffer stringBuffer1 = new StringBuffer();
        while (cursorAdatok.moveToNext()) {
            stringBuffer1.append(cursorAdatok.getString(0));
        }

        f.setA(Integer.toString(a));
        f.setI(Integer.toString(i));
        f.setU(Integer.toString(u));
        f.setE(Integer.toString(e));
        f.setO(Integer.toString(o));
        f.setKa(Integer.toString(ka));
        f.setKi(Integer.toString(ki));
        f.setKu(Integer.toString(ku));
        f.setKe(Integer.toString(ke));
        f.setKo(Integer.toString(ko));
        f.setSa(Integer.toString(sa));
        f.setShi(Integer.toString(shi));
        f.setSu(Integer.toString(su));
        f.setSe(Integer.toString(se));
        f.setSo(Integer.toString(so));
        f.setTa(Integer.toString(ta));
        f.setChi(Integer.toString(chi));
        f.setTsu(Integer.toString(tsu));
        f.setTe(Integer.toString(te));
        f.setTo(Integer.toString(to));
        f.setNa(Integer.toString(na));
        f.setNi(Integer.toString(ni));
        f.setNu(Integer.toString(nu));
        f.setNe(Integer.toString(ne));
        f.setNo(Integer.toString(no));
        f.setHa(Integer.toString(ha));
        f.setHi(Integer.toString(hi));
        f.setFu(Integer.toString(fu));
        f.setHe(Integer.toString(he));
        f.setHo(Integer.toString(ho));
        f.setMa(Integer.toString(ma));
        f.setMi(Integer.toString(mi));
        f.setMu(Integer.toString(mu));
        f.setMe(Integer.toString(me));
        f.setMo(Integer.toString(mo));
        f.setYa(Integer.toString(ya));
        f.setYu(Integer.toString(yu));
        f.setYo(Integer.toString(yo));
        f.setRa(Integer.toString(ra));
        f.setRi(Integer.toString(ri));
        f.setRu(Integer.toString(ru));
        f.setRe(Integer.toString(re));
        f.setRo(Integer.toString(ro));
        f.setWa(Integer.toString(wa));
        f.setWo(Integer.toString(wo));
        f.setN(Integer.toString(n));


        final Button fav = getView().findViewById(R.id.btnfavorite);

        Button btnplay = getView().findViewById(R.id.btnplay);

        if (tw.getText().toString().equals("[]"))
        {
            onStop();
        }

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seged.equals("")) {
                    switch (betu) {
                        case "a":
                            playA.start();
                            Toast.makeText(getContext(), "asdasd", Toast.LENGTH_SHORT).show();
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

                } else if (seged.equals("a")) {
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
                } else if (seged.equals("shi")) {
                    playShi.start();
                } else if (seged.equals("su")) {
                    playSu.start();
                } else if (seged.equals("se")) {
                    playSe.start();
                } else if (seged.equals("so")) {
                    playSo.start();
                } else if (seged.equals("ta")) {
                    playTa.start();
                } else if (seged.equals("chi")) {
                    playChi.start();
                } else if (seged.equals("tsu")) {
                    playTsu.start();
                } else if (seged.equals("te")) {
                    playTe.start();
                } else if (seged.equals("to")) {
                    playTo.start();
                } else if (seged.equals("na")) {
                    playNa.start();
                } else if (seged.equals("ni")) {
                    playNi.start();
                } else if (seged.equals("nu")) {
                    playNu.start();
                } else if (seged.equals("ne")) {
                    playNe.start();
                } else if (seged.equals("no")) {
                    playNo.start();
                } else if (seged.equals("ha")) {
                    playHa.start();
                } else if (seged.equals("hi")) {
                    playHi.start();
                } else if (seged.equals("fu")) {
                    playFu.start();
                } else if (seged.equals("he")) {
                    playHe.start();
                } else if (seged.equals("ho")) {
                    playHo.start();
                } else if (seged.equals("ma")) {
                    playMa.start();
                } else if (seged.equals("mi")) {
                    playMi.start();
                } else if (seged.equals("mu")) {
                    playMu.start();
                } else if (seged.equals("me")) {
                    playMe.start();
                } else if (seged.equals("mo")) {
                    playMo.start();
                } else if (seged.equals("ya")) {
                    playYa.start();
                } else if (seged.equals("yu")) {
                    playYu.start();
                } else if (seged.equals("yo")) {
                    playYo.start();
                } else if (seged.equals("ra")) {
                    playRa.start();
                } else if (seged.equals("ri")) {
                    playRi.start();
                } else if (seged.equals("ru")) {
                    playRu.start();
                } else if (seged.equals("re")) {
                    playRe.start();
                } else if (seged.equals("ro")) {
                    playRo.start();
                } else if (seged.equals("wa")) {
                    playWa.start();
                } else if (seged.equals("wo")) {
                    playWo.start();
                } else if (seged.equals("n")) {
                    playN.start();
                }
            }
        });


        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdatbazisSegito dbhelper = new AdatbazisSegito(getActivity());
                Cursor cursorAdatok = dbhelper.adatLekerdezes();
                StringBuffer stringBuffer = new StringBuffer();
                while (cursorAdatok.moveToNext()) { stringBuffer.append(cursorAdatok.getString(0)); }
                String id = stringBuffer.toString();
                if (seged == "") {
                    if (betu.equals("a")) {
                    }
                } else if (seged.equals("a")) {
                    if (f.getA() != null && f.getA().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setA("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setA("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                        dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("i")) {
                    if (f.getI() != null && f.getI().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setI("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setI("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("u")) {
                    if (f.getU() != null && f.getU().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setU("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setU("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("e")) {
                    if (f.getE() != null && f.getE().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setE("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setE("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("o")) {
                    if (f.getO() != null && f.getO().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setO("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setO("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ka")) {
                    if (f.getKa() != null && f.getKa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setKa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setKa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ki")) {
                    if (f.getKi() != null && f.getKi().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setKi("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setKi("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ku")) {
                    if (f.getKu() != null && f.getKu().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setKu("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setKu("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ke")) {
                    if (f.getKe() != null && f.getKe().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setKe("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setKe("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ko")) {
                    if (f.getKo() != null && f.getKo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setKo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setKo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("sa")) {
                    if (f.getSa() != null && f.getSa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setSa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setSa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("shi")) {
                    if (f.getShi() != null && f.getShi().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setShi("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setShi("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("su")) {
                    if (f.getSu() != null && f.getSu().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setSu("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setSu("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("se")) {
                    if (f.getSe() != null && f.getSe().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setSe("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setSe("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("so")) {
                    if (f.getSo() != null && f.getSo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setSo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setSo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ta")) {
                    if (f.getTa() != null && f.getTa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setTa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setTa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("chi")) {
                    if (f.getChi() != null && f.getChi().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setChi("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setChi("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("tsu")) {
                    if (f.getTsu() != null && f.getTsu().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setTsu("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setTsu("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("te")) {
                    if (f.getTe() != null && f.getTe().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setTe("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setTe("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("to")) {
                    if (f.getTo() != null && f.getTo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setTo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setTo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("na")) {
                    if (f.getNa() != null && f.getNa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setNa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setNa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ni")) {
                    if (f.getNi() != null && f.getNi().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setNi("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setNi("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("nu")) {
                    if (f.getNu() != null && f.getNu().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setNu("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setNu("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ne")) {
                    if (f.getNe() != null && f.getNe().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setNe("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setNe("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("no")) {
                    if (f.getNo() != null && f.getNo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setNo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setNo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ha")) {
                    if (f.getHa() != null && f.getHa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setHa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setHa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("hi")) {
                    if (f.getHi() != null && f.getHi().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setHi("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setHi("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("fu")) {
                    if (f.getFu() != null && f.getFu().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setFu("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setFu("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("he")) {
                    if (f.getHe() != null && f.getHe().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setHe("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setHe("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ho")) {
                    if (f.getHo() != null && f.getHo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setHo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setHo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ma")) {
                    if (f.getMa() != null && f.getMa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setMa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setMa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("mi")) {
                    if (f.getMi() != null && f.getMi().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setMi("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setMi("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("mu")) {
                    if (f.getMu() != null && f.getMu().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setMu("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setMu("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("me")) {
                    if (f.getMe() != null && f.getMe().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setMe("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setMe("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("mo")) {
                    if (f.getMo() != null && f.getMo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setMo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setMo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ya")) {
                    if (f.getYa() != null && f.getYa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setYa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setYa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("yu")) {
                    if (f.getYu() != null && f.getYu().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setYu("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setYu("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("yo")) {
                    if (f.getYo() != null && f.getYo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setYo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setYo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ra")) {
                    if (f.getRa() != null && f.getRa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setRa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setRa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ri")) {
                    if (f.getRi() != null && f.getRi().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setRi("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setRi("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ru")) {
                    if (f.getRu() != null && f.getRu().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setRu("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setRu("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("re")) {
                    if (f.getRe() != null && f.getRe().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setRe("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setRe("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("ro")) {
                    if (f.getRo() != null && f.getRo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setRo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setRo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("wa")) {
                    if (f.getWa() != null && f.getWa().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setWa("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setWa("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("wo")) {
                    if (f.getWo() != null && f.getWo().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setWo("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setWo("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
                } else if (seged.equals("n")) {
                    if (f.getN() != null && f.getN().equals("1")) {
                        fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        f.setN("0");
                    } else {
                        fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        f.setN("1");
                    }
                    String updatefav = f.getA() + "," + f.getI() + "," + f.getU() + "," + f.getE() + "," + f.getO() + "," + f.getKa() + "," + f.getKi() + "," + f.getKu() + "," + f.getKe() + "," + f.getKo() + "," + f.getSa() + "," + f.getShi() + "," + f.getSu() + "," + f.getSe() + "," + f.getSo() + "," + f.getTa() + "," + f.getChi() + "," + f.getTsu() + "," + f.getTe() + "," + f.getTo() + "," + f.getNa() + "," + f.getNi() + "," + f.getNu() + "," + f.getNe() + "," + f.getNo() + "," + f.getHa() + "," + f.getHi() + "," + f.getFu() + "," + f.getHe() + "," + f.getHo() + "," + f.getMa() + "," + f.getMi() + "," + f.getMu() + "," + f.getMe() + "," + f.getMo() + "," + f.getYa() + "," + f.getYu() + "," + f.getYo() + "," + f.getRa() + "," + f.getRi() + "," + f.getRu() + "," + f.getRe() + "," + f.getRo() + "," + f.getWa() + "," + f.getWo() + "," + f.getN();
                    dbhelper.kedvencmodosit(id, updatefav);
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
                        if (f.getI().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "i":
                        ivLearn.setImageResource(R.drawable.qu);
                        seged = "u";
                        tw.setText("Hiragana u");
                        tn.setText("u");
                        if (f.getU().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "u":
                        ivLearn.setImageResource(R.drawable.qe);
                        seged = "e";
                        tw.setText("Hiragana e");
                        tn.setText("e");
                        if (f.getE().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "e":
                        ivLearn.setImageResource(R.drawable.qo);
                        seged = "o";
                        tw.setText("Hiaragana o");
                        tn.setText("o");
                        if (f.getO().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "o":
                        ivLearn.setImageResource(R.drawable.qka);
                        seged = "ka";
                        tw.setText("Hiaragana ka");
                        tn.setText("ka");
                        if (f.getKa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ka":
                        ivLearn.setImageResource(R.drawable.qki);
                        seged = "ki";
                        tw.setText("Hiaragana ki");
                        tn.setText("ki");
                        if (f.getKi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ki":
                        ivLearn.setImageResource(R.drawable.qku);
                        seged = "ku";
                        tw.setText("Hiaragana ku");
                        tn.setText("ku");
                        if (f.getKu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ku":
                        ivLearn.setImageResource(R.drawable.qke);
                        seged = "ke";
                        tw.setText("Hiaragana ke");
                        tn.setText("ke");
                        if (f.getKe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ke":
                        ivLearn.setImageResource(R.drawable.qko);
                        seged = "ko";
                        tw.setText("Hiaragana ko");
                        tn.setText("ko");
                        if (f.getKo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ko":
                        ivLearn.setImageResource(R.drawable.qsa);
                        seged = "sa";
                        tw.setText("Hiaragana sa");
                        tn.setText("sa");
                        if (f.getSa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "sa":
                        ivLearn.setImageResource(R.drawable.qshi);
                        seged = "shi";
                        tw.setText("Hiaragana shi");
                        tn.setText("shi");
                        if (f.getShi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "shi":
                        ivLearn.setImageResource(R.drawable.qsu);
                        seged = "su";
                        tw.setText("Hiaragana su");
                        tn.setText("su");
                        if (f.getSu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "su":
                        ivLearn.setImageResource(R.drawable.qse);
                        seged = "se";
                        tw.setText("Hiaragana se");
                        tn.setText("se");
                        if (f.getSe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "se":
                        ivLearn.setImageResource(R.drawable.qso);
                        seged = "so";
                        tw.setText("Hiaragana so");
                        tn.setText("so");
                        if (f.getSo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "so":
                        ivLearn.setImageResource(R.drawable.qta);
                        seged = "ta";
                        tw.setText("Hiaragana ta");
                        tn.setText("ta");
                        if (f.getTa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ta":
                        ivLearn.setImageResource(R.drawable.qchi);
                        seged = "chi";
                        tw.setText("Hiaragana chi");
                        tn.setText("chi");
                        if (f.getChi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "chi":
                        ivLearn.setImageResource(R.drawable.qtsu);
                        seged = "tsu";
                        tw.setText("Hiaragana tsu");
                        tn.setText("tsu");
                        if (f.getTsu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "tsu":
                        ivLearn.setImageResource(R.drawable.qte);
                        seged = "te";
                        tw.setText("Hiaragana te");
                        tn.setText("te");
                        if (f.getTe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "te":
                        ivLearn.setImageResource(R.drawable.qto);
                        seged = "to";
                        tw.setText("Hiaragana to");
                        tn.setText("to");
                        if (f.getTo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "to":
                        ivLearn.setImageResource(R.drawable.qna);
                        seged = "na";
                        tw.setText("Hiaragana na");
                        tn.setText("na");
                        if (f.getNa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "na":
                        ivLearn.setImageResource(R.drawable.qni);
                        seged = "ni";
                        tw.setText("Hiaragana ni");
                        tn.setText("ni");
                        if (f.getNi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ni":
                        ivLearn.setImageResource(R.drawable.qnu);
                        seged = "nu";
                        tw.setText("Hiaragana nu");
                        tn.setText("nu");
                        if (f.getNu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "nu":
                        ivLearn.setImageResource(R.drawable.qne);
                        seged = "ne";
                        tw.setText("Hiaragana ne");
                        tn.setText("ne");
                        if (f.getNe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ne":
                        ivLearn.setImageResource(R.drawable.qno);
                        seged = "no";
                        tw.setText("Hiaragana no");
                        tn.setText("no");
                        if (f.getNo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "no":
                        ivLearn.setImageResource(R.drawable.qha);
                        seged = "ha";
                        tw.setText("Hiaragana ha");
                        tn.setText("ha");
                        if (f.getHa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ha":
                        ivLearn.setImageResource(R.drawable.qhi);
                        seged = "hi";
                        tw.setText("Hiaragana hi");
                        tn.setText("hi");
                        if (f.getHi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "hi":
                        ivLearn.setImageResource(R.drawable.qfu);
                        seged = "fu";
                        tw.setText("Hiaragana fu");
                        tn.setText("fu");
                        if (f.getFu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "fu":
                        ivLearn.setImageResource(R.drawable.qhe);
                        seged = "he";
                        tw.setText("Hiaragana he");
                        tn.setText("he");
                        if (f.getHe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "he":
                        ivLearn.setImageResource(R.drawable.qho);
                        seged = "ho";
                        tw.setText("Hiaragana ho");
                        tn.setText("ho");
                        if (f.getHo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ho":
                        ivLearn.setImageResource(R.drawable.qma);
                        seged = "ma";
                        tw.setText("Hiaragana ma");
                        tn.setText("ma");
                        if (f.getMa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ma":
                        ivLearn.setImageResource(R.drawable.qmi);
                        seged = "mi";
                        tw.setText("Hiaragana mi");
                        tn.setText("mi");
                        if (f.getMi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "mi":
                        ivLearn.setImageResource(R.drawable.qmu);
                        seged = "mu";
                        tw.setText("Hiaragana mu");
                        tn.setText("mu");
                        if (f.getMu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "mu":
                        ivLearn.setImageResource(R.drawable.qme);
                        seged = "me";
                        tw.setText("Hiaragana me");
                        tn.setText("me");
                        if (f.getMe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "me":
                        ivLearn.setImageResource(R.drawable.qmo);
                        seged = "mo";
                        tw.setText("Hiaragana mo");
                        tn.setText("mo");
                        if (f.getMo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "mo":
                        ivLearn.setImageResource(R.drawable.qya);
                        seged = "ya";
                        tw.setText("Hiaragana ya");
                        tn.setText("ya");
                        if (f.getYa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ya":
                        ivLearn.setImageResource(R.drawable.qyu);
                        seged = "yu";
                        tw.setText("Hiaragana yu");
                        tn.setText("yu");
                        if (f.getYu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "yu":
                        ivLearn.setImageResource(R.drawable.qyo);
                        seged = "yo";
                        tw.setText("Hiaragana yo");
                        tn.setText("yo");
                        if (f.getYo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "yo":
                        ivLearn.setImageResource(R.drawable.qra);
                        seged = "ra";
                        tw.setText("Hiaragana ra");
                        tn.setText("ra");
                        if (f.getRa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ra":
                        ivLearn.setImageResource(R.drawable.qri);
                        seged = "ri";
                        tw.setText("Hiaragana ri");
                        tn.setText("ri");
                        if (f.getRi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ri":
                        ivLearn.setImageResource(R.drawable.qru);
                        seged = "ru";
                        tw.setText("Hiaragana ru");
                        tn.setText("ru");
                        if (f.getRu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ru":
                        ivLearn.setImageResource(R.drawable.qre);
                        seged = "re";
                        tw.setText("Hiaragana re");
                        tn.setText("re");
                        if (f.getRe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "re":
                        ivLearn.setImageResource(R.drawable.qro);
                        seged = "ro";
                        tw.setText("Hiaragana ro");
                        tn.setText("ro");
                        if (f.getRo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ro":
                        ivLearn.setImageResource(R.drawable.qwa);
                        seged = "wa";
                        tw.setText("Hiaragana wa");
                        tn.setText("wa");
                        if (f.getWa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "wa":
                        ivLearn.setImageResource(R.drawable.qwo);
                        seged = "wo";
                        tw.setText("Hiaragana wo");
                        tn.setText("wo");
                        if (f.getWo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "wo":
                        ivLearn.setImageResource(R.drawable.qn);
                        seged = "n";
                        tw.setText("Hiaragana n");
                        tn.setText("n");
                        if (f.getN().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
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
                        if (f.getA().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "u":
                        ivLearn.setImageResource(R.drawable.qi);
                        seged = "i";
                        tw.setText("Hiragana i");
                        tn.setText("i");
                        if (f.getI().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "e":
                        ivLearn.setImageResource(R.drawable.qu);
                        seged = "u";
                        tw.setText("Hiragana u");
                        tn.setText("u");
                        if (f.getU().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "o":
                        ivLearn.setImageResource(R.drawable.qe);
                        seged = "e";
                        tw.setText("Hiragana e");
                        tn.setText("e");
                        if (f.getE().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ka":
                        ivLearn.setImageResource(R.drawable.qo);
                        seged = "o";
                        tw.setText("Hiragana o");
                        tn.setText("o");
                        if (f.getO().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ki":
                        ivLearn.setImageResource(R.drawable.qka);
                        seged = "ka";
                        tw.setText("Hiragana ka");
                        tn.setText("ka");
                        if (f.getKa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ku":
                        ivLearn.setImageResource(R.drawable.qki);
                        seged = "ki";
                        tw.setText("Hiragana ki");
                        tn.setText("ki");
                        if (f.getKi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ke":
                        ivLearn.setImageResource(R.drawable.qku);
                        seged = "ku";
                        tw.setText("Hiragana ku");
                        tn.setText("ku");
                        if (f.getKu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ko":
                        ivLearn.setImageResource(R.drawable.qke);
                        seged = "ke";
                        tw.setText("Hiragana ke");
                        tn.setText("ke");
                        if (f.getKe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "sa":
                        ivLearn.setImageResource(R.drawable.qko);
                        seged = "ko";
                        tw.setText("Hiragana ko");
                        tn.setText("ko");
                        if (f.getKo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "shi":
                        ivLearn.setImageResource(R.drawable.qsa);
                        seged = "sa";
                        tw.setText("Hiragana sa");
                        tn.setText("sa");
                        if (f.getSa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "su":
                        ivLearn.setImageResource(R.drawable.qshi);
                        seged = "shi";
                        tw.setText("Hiragana shi");
                        tn.setText("shi");
                        if (f.getShi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "se":
                        ivLearn.setImageResource(R.drawable.qsu);
                        seged = "su";
                        tw.setText("Hiragana su");
                        tn.setText("su");
                        if (f.getSu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "so":
                        ivLearn.setImageResource(R.drawable.qse);
                        seged = "se";
                        tw.setText("Hiragana se");
                        tn.setText("se");
                        if (f.getSe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ta":
                        ivLearn.setImageResource(R.drawable.qso);
                        seged = "so";
                        tw.setText("Hiragana so");
                        tn.setText("so");
                        if (f.getSo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "chi":
                        ivLearn.setImageResource(R.drawable.qta);
                        seged = "ta";
                        tw.setText("Hiragana ta");
                        tn.setText("ta");
                        if (f.getTa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "tsu":
                        ivLearn.setImageResource(R.drawable.qchi);
                        seged = "chi";
                        tw.setText("Hiragana chi");
                        tn.setText("chi");
                        if (f.getChi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "te":
                        ivLearn.setImageResource(R.drawable.qtsu);
                        seged = "tsu";
                        tw.setText("Hiragana tsu");
                        tn.setText("tsu");
                        if (f.getTsu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "to":
                        ivLearn.setImageResource(R.drawable.qte);
                        seged = "te";
                        tw.setText("Hiragana te");
                        if (f.getTe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "na":
                        ivLearn.setImageResource(R.drawable.qte);
                        seged = "to";
                        tw.setText("Hiragana to");
                        tn.setText("to");
                        if (f.getTo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ni":
                        ivLearn.setImageResource(R.drawable.qna);
                        seged = "na";
                        tw.setText("Hiragana na");
                        tn.setText("na");
                        if (f.getNa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "nu":
                        ivLearn.setImageResource(R.drawable.qni);
                        seged = "ni";
                        tw.setText("Hiragana ni");
                        tn.setText("ni");
                        if (f.getNi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ne":
                        ivLearn.setImageResource(R.drawable.qnu);
                        seged = "nu";
                        tw.setText("Hiragana nu");
                        tn.setText("nu");
                        if (f.getNu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "no":
                        ivLearn.setImageResource(R.drawable.qne);
                        seged = "ne";
                        tw.setText("Hiragana ne");
                        tn.setText("ne");
                        if (f.getNe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ha":
                        ivLearn.setImageResource(R.drawable.qno);
                        seged = "no";
                        tw.setText("Hiragana no");
                        tn.setText("no");
                        if (f.getNo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "hi":
                        ivLearn.setImageResource(R.drawable.qha);
                        seged = "ha";
                        tw.setText("Hiragana ha");
                        tn.setText("ha");
                        if (f.getHa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "fu":
                        ivLearn.setImageResource(R.drawable.qhi);
                        seged = "hi";
                        tw.setText("Hiragana hi");
                        tn.setText("hi");
                        if (f.getHi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "he":
                        ivLearn.setImageResource(R.drawable.qfu);
                        seged = "fu";
                        tw.setText("Hiragana fu");
                        tn.setText("fu");
                        if (f.getFu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ho":
                        ivLearn.setImageResource(R.drawable.qhe);
                        seged = "he";
                        tw.setText("Hiragana he");
                        tn.setText("he");
                        if (f.getHe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ma":
                        ivLearn.setImageResource(R.drawable.qho);
                        seged = "ho";
                        tw.setText("Hiragana ho");
                        tn.setText("ho");
                        if (f.getHo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "mi":
                        ivLearn.setImageResource(R.drawable.qma);
                        seged = "ma";
                        tw.setText("Hiaragana ma");
                        tn.setText("ma");
                        if (f.getMa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "mu":
                        ivLearn.setImageResource(R.drawable.qmi);
                        seged = "mi";
                        tw.setText("Hiaragana mi");
                        tn.setText("mi");
                        if (f.getMi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "me":
                        ivLearn.setImageResource(R.drawable.qmu);
                        seged = "mu";
                        tw.setText("Hiaragana mu");
                        tn.setText("mu");
                        if (f.getMu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "mo":
                        ivLearn.setImageResource(R.drawable.qme);
                        seged = "me";
                        tw.setText("Hiaragana me");
                        tn.setText("me");
                        if (f.getMe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ya":
                        ivLearn.setImageResource(R.drawable.qmo);
                        seged = "mo";
                        tw.setText("Hiaragana mo");
                        tn.setText("mo");
                        if (f.getMo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "yu":
                        ivLearn.setImageResource(R.drawable.qya);
                        seged = "ya";
                        tw.setText("Hiaragana ya");
                        tn.setText("ya");
                        if (f.getYa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "yo":
                        ivLearn.setImageResource(R.drawable.qyu);
                        seged = "yu";
                        tw.setText("Hiaragana yu");
                        tn.setText("yu");
                        if (f.getYu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ra":
                        ivLearn.setImageResource(R.drawable.qyo);
                        seged = "yo";
                        tw.setText("Hiaragana yo");
                        tn.setText("yo");
                        if (f.getYo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ri":
                        ivLearn.setImageResource(R.drawable.qra);
                        seged = "ra";
                        tw.setText("Hiaragana ra");
                        tn.setText("ra");
                        if (f.getRa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ru":
                        ivLearn.setImageResource(R.drawable.qri);
                        seged = "ri";
                        tw.setText("Hiaragana ri");
                        tn.setText("ri");
                        if (f.getRi().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "re":
                        ivLearn.setImageResource(R.drawable.qru);
                        seged = "ru";
                        tw.setText("Hiaragana ru");
                        tn.setText("ru");
                        if (f.getRu().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "ro":
                        ivLearn.setImageResource(R.drawable.qre);
                        seged = "re";
                        tw.setText("Hiaragana re");
                        tn.setText("re");
                        if (f.getRe().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "wa":
                        ivLearn.setImageResource(R.drawable.qro);
                        seged = "ro";
                        tw.setText("Hiaragana ro");
                        tn.setText("ro");
                        if (f.getRo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "wo":
                        ivLearn.setImageResource(R.drawable.qwa);
                        seged = "wa";
                        tw.setText("Hiaragana wa");
                        tn.setText("wa");
                        if (f.getWa().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                    case "n":
                        ivLearn.setImageResource(R.drawable.qwo);
                        seged = "wo";
                        tw.setText("Hiaragana wo");
                        tn.setText("wo");
                        if (f.getWo().equals("0")) {
                            fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                        } else {
                            fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                        }
                        break;
                }

            }
        });

        if (seged.isEmpty()) {

            if (betu.equals("a")) {
                ivLearn.setImageResource(R.drawable.qa);
                tw.setText("Hiragana "+betu);
                tn.setText(betu);
                seged = "a";

                if (f.getA() != null && f.getA().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }

            } else if (betu.equals("i")) {
                ivLearn.setImageResource(R.drawable.qi);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "i";

                if (f.getI() != null && f.getI().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("u")) {
                ivLearn.setImageResource(R.drawable.qu);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "u";
                if (f.getU() != null && f.getU().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("e")) {
                ivLearn.setImageResource(R.drawable.qe);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "e";
                if (f.getE() != null && f.getE().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("o")) {
                ivLearn.setImageResource(R.drawable.qo);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "o";
                if (f.getO() != null && f.getO().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ka")) {
                ivLearn.setImageResource(R.drawable.qka);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ka";
                if (f.getKa() != null && f.getKa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ki")) {
                ivLearn.setImageResource(R.drawable.qki);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ki";
                if (f.getKi() != null && f.getKi().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ku")) {
                ivLearn.setImageResource(R.drawable.qku);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ku";
                if (f.getKu() != null && f.getKu().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ke")) {
                ivLearn.setImageResource(R.drawable.qke);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ke";
                if (f.getKe() != null && f.getKe().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ko")) {
                ivLearn.setImageResource(R.drawable.qko);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ko";
                if (f.getKo() != null && f.getKo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("sa")) {
                ivLearn.setImageResource(R.drawable.qsa);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "sa";
                if (f.getSa() != null && f.getSa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("shi")) {
                ivLearn.setImageResource(R.drawable.qshi);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "shi";
                if (f.getShi() != null && f.getShi().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("su")) {
                ivLearn.setImageResource(R.drawable.qsu);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "su";
                if (f.getSu() != null && f.getSu().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("se")) {
                ivLearn.setImageResource(R.drawable.qse);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "se";
                if (f.getSe() != null && f.getSe().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("so")) {
                ivLearn.setImageResource(R.drawable.qso);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "so";
                if (f.getSo() != null && f.getSo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ta")) {
                ivLearn.setImageResource(R.drawable.qta);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ta";
                if (f.getTa() != null && f.getTa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("chi")) {
                ivLearn.setImageResource(R.drawable.qchi);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "chi";
                if (f.getChi() != null && f.getChi().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("tsu")) {
                ivLearn.setImageResource(R.drawable.qtsu);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "tsu";
                if (f.getTsu() != null && f.getTsu().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("te")) {
                ivLearn.setImageResource(R.drawable.qte);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "te";
                if (f.getTe() != null && f.getTe().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("to")) {
                ivLearn.setImageResource(R.drawable.qto);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "to";
                if (f.getTo() != null && f.getTo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("na")) {
                ivLearn.setImageResource(R.drawable.qna);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "na";
                if (f.getNa() != null && f.getNa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ni")) {
                ivLearn.setImageResource(R.drawable.qni);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ni";
                if (f.getNi() != null && f.getNi().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("nu")) {
                ivLearn.setImageResource(R.drawable.qnu);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "nu";
                if (f.getNu() != null && f.getNu().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ne")) {
                ivLearn.setImageResource(R.drawable.qne);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ne";
                if (f.getNe() != null && f.getNe().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("no")) {
                ivLearn.setImageResource(R.drawable.qno);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "no";
                if (f.getNo() != null && f.getNo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ha")) {
                ivLearn.setImageResource(R.drawable.qha);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ha";
                if (f.getHa() != null && f.getHa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("hi")) {
                ivLearn.setImageResource(R.drawable.qhi);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "hi";
                if (f.getHi() != null && f.getHi().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("fu")) {
                ivLearn.setImageResource(R.drawable.qfu);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "fu";
                if (f.getFu() != null && f.getFu().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("he")) {
                ivLearn.setImageResource(R.drawable.qhe);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "he";
                if (f.getHe() != null && f.getHe().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ho")) {
                ivLearn.setImageResource(R.drawable.qho);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ho";
                if (f.getHo() != null && f.getHo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ma")) {
                ivLearn.setImageResource(R.drawable.qma);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ma";
                if (f.getMa() != null && f.getMa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("mi")) {
                ivLearn.setImageResource(R.drawable.qmi);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "mi";
                if (f.getMi() != null && f.getMi().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("mu")) {
                ivLearn.setImageResource(R.drawable.qmu);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "mu";
                if (f.getMu() != null && f.getMu().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("me")) {
                ivLearn.setImageResource(R.drawable.qme);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "me";
                if (f.getMe() != null && f.getMe().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("mo")) {
                ivLearn.setImageResource(R.drawable.qmo);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "mo";
                if (f.getMo() != null && f.getMo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ya")) {
                ivLearn.setImageResource(R.drawable.qya);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ya";
                if (f.getYa() != null && f.getYa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("yu")) {
                ivLearn.setImageResource(R.drawable.qyu);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "yu";
                if (f.getYu() != null && f.getYu().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("yo")) {
                ivLearn.setImageResource(R.drawable.qyo);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "yo";
                if (f.getYo() != null && f.getYo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ra")) {
                ivLearn.setImageResource(R.drawable.qra);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ra";
                if (f.getRa() != null && f.getRa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ri")) {
                ivLearn.setImageResource(R.drawable.qri);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ri";
                if (f.getRi() != null && f.getRi().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ru")) {
                ivLearn.setImageResource(R.drawable.qru);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ru";
                if (f.getRu() != null && f.getRu().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("re")) {
                ivLearn.setImageResource(R.drawable.qre);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "re";
                if (f.getRe() != null && f.getRe().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("ro")) {
                ivLearn.setImageResource(R.drawable.qro);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "ro";
                if (f.getRo() != null && f.getRo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("wa")) {
                ivLearn.setImageResource(R.drawable.qwa);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "wa";
                if (f.getWa() != null && f.getWa().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("wo")) {
                ivLearn.setImageResource(R.drawable.qwo);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "wo";
                if (f.getWo() != null && f.getWo().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            } else if (betu.equals("n")) {
                ivLearn.setImageResource(R.drawable.qn);
                tw.setText("Hiragana " + betu);
                tn.setText(betu);
                seged = "n";
                if (f.getN() != null && f.getN().equals("0")) {
                    fav.setBackgroundResource(R.drawable.ic_favorite_border_black);
                } else {
                    fav.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
