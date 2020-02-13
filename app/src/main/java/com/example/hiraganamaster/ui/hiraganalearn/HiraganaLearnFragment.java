package com.example.hiraganamaster.ui.hiraganalearn;

import androidx.lifecycle.ViewModelProviders;

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

public class HiraganaLearnFragment extends Fragment {

    private HiraganaLearnViewModel mViewModel;
    private static String betu;
    public String betu2 = betu;
    public String seged = betu2;
    private static String balra;
    private static String jobbra;

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
        TextView tw = getView().findViewById(R.id.textviewhiragana);
        tw.setText(seged);

        if(seged.equals("Hiragana a"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.a);
            tw.setText(seged);
        }
        else if(seged.equals("Hiragana i"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.i);
            tw.setText(seged);
        }
        else if(seged.equals("Hiragana u"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.u);
            tw.setText(seged);
        }
        else if(betu.equals("Hiragana e"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.e);
        }
        else if(betu.equals("Hiragana o"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.o);
        }

        else if(betu.equals("Hiragana ka"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ka);
        }
        else if(betu.equals("Hiragana ki"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ki);
        }
        else if(betu.equals("Hiragana ku"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ku);
        }
        else if(betu.equals("Hiragana ke"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ke);
        }
        else if(betu.equals("Hiragana ko"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ko);
        }

        else if(betu.equals("Hiragana sa"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.sa);
        }
        else if(betu.equals("Hiragana shi"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.shi);
        }
        else if(betu.equals("Hiragana su"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.su);
        }
        else if(betu.equals("Hiragana se"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.se);
        }
        else if(betu.equals("Hiragana so"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.so);
        }

        else if(betu.equals("Hiragana ta"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ta);
        }
        else if(betu.equals("Hiragana chi"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.chi);
        }
        else if(betu.equals("Hiragana tsu"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.tsu);
        }
        else if(betu.equals("Hiragana te"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.te);
        }
        else if(betu.equals("Hiragana to"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.to);
        }

        else if(betu.equals("Hiragana na"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.na);
        }
        else if(betu.equals("Hiragana ni"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ni);
        }
        else if(betu.equals("Hiragana nu"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.nu);
        }
        else if(betu.equals("Hiragana ne"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ne);
        }
        else if(betu.equals("Hiragana no"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.mo);
        }

        else if(betu.equals("Hiragana ha"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ha);
        }
        else if(betu.equals("Hiragana hi"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.hi);
        }
        else if(betu.equals("Hiragana hu"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.fu);
        }
        else if(betu.equals("Hiragana he"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.he);
        }
        else if(betu.equals("Hiragana ho"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ho);
        }

        else if(betu.equals("Hiragana ma"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ma);
        }
        else if(betu.equals("Hiragana mi"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.mi);
        }
        else if(betu.equals("Hiragana mu"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.mu);
        }
        else if(betu.equals("Hiragana me"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.me);
        }
        else if(betu.equals("Hiragana mo"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.mo);
        }

        else if(betu.equals("Hiragana ya"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ya);
        }
        else if(betu.equals("Hiragana yu"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.yu);
        }
        else if(betu.equals("Hiragana yo"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.yo);
        }

        else if(betu.equals("Hiragana ra"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ra);
        }
        else if(betu.equals("Hiragana ri"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ri);
        }
        else if(betu.equals("Hiragana ru"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ru);
        }
        else if(betu.equals("Hiragana re"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.re);
        }
        else if(betu.equals("Hiragana ro"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.ro);
        }

        else if(betu.equals("Hiragana wa"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.wa);
        }
        else if(betu.equals("Hiragana wo"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.wo);
        }
        else if(betu.equals("Hiragana n"))
        {
            ImageView ivLearn = getView().findViewById(R.id.ivLearn);
            ivLearn.setImageResource(R.drawable.n);
        }

        Button toLeft = getView().findViewById(R.id.toLeft);
        Button toRight = getView().findViewById(R.id.toRight);

        toRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tw = getView().findViewById(R.id.textviewhiragana);
                if(jobbra.equals("nincs"))
                {
                    Toast.makeText(getContext(), "Hiba", Toast.LENGTH_SHORT).show();
                }
                else if(jobbra.equals("i"))
                {
                    seged=("Hiragana i");
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.i);
                    tw.setText(seged);
                }
                else if(jobbra.equals("u"))
                {
                    seged=("Hiragana u");
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.u);
                    tw.setText(seged);
                }
                else if(jobbra.equals("e"))
                {
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.e);
                }
                else if(jobbra.equals("o"))
                {
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.o);
                }
                else if(jobbra.equals("ka"))
                {
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.ka);
                }
            }
        });

        toLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tw = getView().findViewById(R.id.textviewhiragana);
                if(balra.equals("nincs"))
                {
                    Toast.makeText(getContext(), "Hiba", Toast.LENGTH_SHORT).show();
                }
                else if(balra.equals("a"))
                {
                    seged.replace("Hiragana i","Hiragana a");
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.a);
                    tw.setText(seged);
                }
                else if(balra.equals("i"))
                {
                    betu.replace("Hiragana u","Hiragana i");
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.i);
                }
                else if(balra.equals("u"))
                {
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.u);
                }
                else if(balra.equals("e"))
                {
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.e);
                }
                else if(balra.equals("o"))
                {
                    ImageView ivLearn = getView().findViewById(R.id.ivLearn);
                    ivLearn.setImageResource(R.drawable.o);
                }

            }
        });

    }

}