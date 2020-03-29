package com.example.hiraganamaster.ui.favorites;

import androidx.lifecycle.ViewModelProviders;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hiraganamaster.AdatbazisSegito;
import com.example.hiraganamaster.FavoriteHiraganas;
import com.example.hiraganamaster.R;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {

    private FavoritesViewModel mViewModel;

    private ListView lv;

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorites_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FavoritesViewModel.class);
        lv = (ListView) getActivity().findViewById(R.id.idListView);
        this.lv.setEmptyView(getActivity().findViewById(R.id.empty));

        ArrayList<String> arrayList = new ArrayList<>();
        final FavoriteHiraganas f = new FavoriteHiraganas();

        AdatbazisSegito dbhelper = new AdatbazisSegito(getActivity());
        Cursor cursorAdatok = dbhelper.adatLekerdezes();
        if (cursorAdatok == null){
            Toast.makeText(getActivity(),
                    "Sikertlen Adatlekérdezés", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cursorAdatok.getCount() == 0){
            Toast.makeText(getActivity(),
                    "Nincs még felvéve adat", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (cursorAdatok.moveToNext()){
            stringBuffer.append(cursorAdatok.getString(4));
            stringBuffer.append("," + cursorAdatok.getString(0));
        }
        String kedvencek = stringBuffer.toString();
         String[] darabol = kedvencek.split(",");
         int a = Integer.parseInt(darabol[0]);
         int i = Integer.parseInt(darabol[1]);
         int u = Integer.parseInt(darabol[2]);
         int e = Integer.parseInt(darabol[3]);
         int o = Integer.parseInt(darabol[4]);
         int ka = Integer.parseInt(darabol[5]);
         int ki = Integer.parseInt(darabol[6]);
         int ku = Integer.parseInt(darabol[7]);
         int ke = Integer.parseInt(darabol[8]);
         int ko = Integer.parseInt(darabol[9]);
         int sa = Integer.parseInt(darabol[10]);
         int shi = Integer.parseInt(darabol[11]);
         int su = Integer.parseInt(darabol[12]);
         int se = Integer.parseInt(darabol[13]);
         int so = Integer.parseInt(darabol[14]);
         int ta = Integer.parseInt(darabol[15]);
         int chi = Integer.parseInt(darabol[16]);
         int tsu = Integer.parseInt(darabol[17]);
         int te = Integer.parseInt(darabol[18]);
         int to = Integer.parseInt(darabol[19]);
         int na = Integer.parseInt(darabol[20]);
         int ni = Integer.parseInt(darabol[21]);
         int nu = Integer.parseInt(darabol[22]);
         int ne = Integer.parseInt(darabol[23]);
         int no = Integer.parseInt(darabol[24]);
         int ha = Integer.parseInt(darabol[25]);
         int hi = Integer.parseInt(darabol[26]);
         int fu = Integer.parseInt(darabol[27]);
         int he = Integer.parseInt(darabol[28]);
         int ho = Integer.parseInt(darabol[29]);
         int ma = Integer.parseInt(darabol[30]);
         int mi = Integer.parseInt(darabol[31]);
         int mu = Integer.parseInt(darabol[32]);
         int me = Integer.parseInt(darabol[33]);
         int mo = Integer.parseInt(darabol[34]);
         int ya = Integer.parseInt(darabol[35]);
         int yu = Integer.parseInt(darabol[36]);
         int yo = Integer.parseInt(darabol[37]);
         int ra = Integer.parseInt(darabol[38]);
         int ri = Integer.parseInt(darabol[39]);
         int ru = Integer.parseInt(darabol[40]);
         int re = Integer.parseInt(darabol[41]);
         int ro = Integer.parseInt(darabol[42]);
         int wa = Integer.parseInt(darabol[43]);
         int wo = Integer.parseInt(darabol[44]);
         int n = Integer.parseInt(darabol[45]);

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

        if(f.getA() != null && f.getA().equals("1"))
        {
            arrayList.add("Hiragana a");
        }
        if(f.getI() != null && f.getI().equals("1"))
        {
            arrayList.add("Hiragana i");
        }
        if(f.getU() != null && f.getU().equals("1"))
        {
            arrayList.add("Hiragana u");
        }
        if(f.getE() != null && f.getE().equals("1"))
        {
            arrayList.add("Hiragana e");
        }
        if(f.getO() != null && f.getO().equals("1"))
        {
            arrayList.add("Hiragana o");
        }
        if(f.getKa() != null && f.getKa().equals("1"))
        {
            arrayList.add("Hiragana ka");
        }
        if(f.getKi() != null && f.getKi().equals("1"))
        {
            arrayList.add("Hiragana ki");
        }
        if(f.getKu() != null && f.getKu().equals("1"))
        {
            arrayList.add("Hiragana ku");
        }
        if(f.getKe() != null && f.getKe().equals("1"))
        {
            arrayList.add("Hiragana ke");
        }
        if(f.getKo() != null && f.getKo().equals("1"))
        {
            arrayList.add("Hiragana ko");
        }
        if(f.getSa() != null && f.getSa().equals("1"))
        {
            arrayList.add("Hiragana sa");
        }
        if(f.getShi() != null && f.getShi().equals("1"))
        {
            arrayList.add("Hiragana shi");
        }
        if(f.getSu() != null && f.getSu().equals("1"))
        {
            arrayList.add("Hiragana su");
        }
        if(f.getSe() != null && f.getSe().equals("1"))
        {
            arrayList.add("Hiragana se");
        }
        if(f.getSo() != null && f.getSo().equals("1"))
        {
            arrayList.add("Hiragana so");
        }


        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

    }

}
