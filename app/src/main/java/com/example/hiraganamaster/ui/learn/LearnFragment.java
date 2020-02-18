package com.example.hiraganamaster.ui.learn;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hiraganamaster.HiraganaLearn;
import com.example.hiraganamaster.R;
import com.example.hiraganamaster.ui.hiraganalearn.HiraganaLearnFragment;

public class LearnFragment extends Fragment {

    private LearnViewModel mViewModel;

    private ImageView a, i, u, e, o, ka, ki, ku, ke, ko, sa, shi, su, se, so, ta, chi, tsu, te, to, na ,ni, nu, ne, no, ha, hi, fu, he, ho, ma,mi, mu, me, mo, ya, yu, yo, ra, ri, ru, re, ro, wa, wo, n;

    public static LearnFragment newInstance() {
        return new LearnFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.learn_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LearnViewModel.class);

        a = getView().findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "a");
                intent.putExtra("balra", "nincs");
                intent.putExtra("jobbra", "i");
                startActivity(intent);
            }
        });
        i = getView().findViewById(R.id.i);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "i");
                intent.putExtra("balra", "a");
                intent.putExtra("jobbra", "u");
                startActivity(intent);
            }
        });
        u = getView().findViewById(R.id.u);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "u");
                intent.putExtra("balra", "i");
                intent.putExtra("jobbra", "e");
                startActivity(intent);
            }
        });
        e = getView().findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "e");
                intent.putExtra("balra", "u");
                intent.putExtra("jobbra", "o");
                startActivity(intent);
            }
        });
        o = getView().findViewById(R.id.o);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "o");
                intent.putExtra("balra", "e");
                intent.putExtra("jobbra", "nincs");
                startActivity(intent);
            }
        });

        ka = getView().findViewById(R.id.ka);
        ka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ka");
                startActivity(intent);
            }
        });
        ki = getView().findViewById(R.id.ki);
        ki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ki");
                startActivity(intent);
            }
        });
        ku = getView().findViewById(R.id.ku);
        ku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ku");
                startActivity(intent);
            }
        });
        ke = getView().findViewById(R.id.ke);
        ke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ke");
                startActivity(intent);
            }
        });
        ko = getView().findViewById(R.id.ko);
        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ko");
                startActivity(intent);
            }
        });

        sa = getView().findViewById(R.id.sa);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "sa");
                startActivity(intent);
            }
        });
        shi = getView().findViewById(R.id.shi);
        shi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "shi");
                startActivity(intent);
            }
        });
        su = getView().findViewById(R.id.su);
        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "su");
                startActivity(intent);
            }
        });
        se = getView().findViewById(R.id.se);
        se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "se");
                startActivity(intent);
            }
        });
        so = getView().findViewById(R.id.so);
        so.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "so");
                startActivity(intent);
            }
        });

        ta = getView().findViewById(R.id.ta);
        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ta");
                startActivity(intent);
            }
        });
        chi = getView().findViewById(R.id.chi);
        chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "chi");
                startActivity(intent);
            }
        });
        tsu = getView().findViewById(R.id.tsu);
        tsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "tsu");
                startActivity(intent);
            }
        });
        te = getView().findViewById(R.id.te);
        te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "te");
                startActivity(intent);
            }
        });
        to = getView().findViewById(R.id.to);
        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "to");
                startActivity(intent);
            }
        });

        na = getView().findViewById(R.id.na);
        na.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "na");
                startActivity(intent);
            }
        });
        ni = getView().findViewById(R.id.ni);
        ni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ni");
                startActivity(intent);
            }
        });
        nu = getView().findViewById(R.id.nu);
        nu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "nu");
                startActivity(intent);
            }
        });
        ne = getView().findViewById(R.id.ne);
        ne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ne");
                startActivity(intent);
            }
        });
        no = getView().findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "no");
                startActivity(intent);
            }
        });

        ha = getView().findViewById(R.id.ha);
        ha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ha");
                startActivity(intent);
            }
        });
        hi = getView().findViewById(R.id.hi);
        hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "hi");
                startActivity(intent);
            }
        });
        fu = getView().findViewById(R.id.fu);
        fu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "fu");
                startActivity(intent);
            }
        });
        he = getView().findViewById(R.id.he);
        he.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "he");
                startActivity(intent);
            }
        });
        ho = getView().findViewById(R.id.ho);
        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ho");
                startActivity(intent);
            }
        });

        ma = getView().findViewById(R.id.ma);
        ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ma");
                startActivity(intent);
            }
        });
        mi = getView().findViewById(R.id.mi);
        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "mi");
                startActivity(intent);
            }
        });
        mu = getView().findViewById(R.id.mu);
        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "mu");
                startActivity(intent);
            }
        });
        me = getView().findViewById(R.id.me);
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "me");
                startActivity(intent);
            }
        });
        mo = getView().findViewById(R.id.mo);
        mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "mo");
                startActivity(intent);
            }
        });

        ya = getView().findViewById(R.id.ya);
        ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ya");
                startActivity(intent);
            }
        });
        yu = getView().findViewById(R.id.yu);
        yu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "yu");
                startActivity(intent);
            }
        });
        yo = getView().findViewById(R.id.yo);
        yo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "yo");
                startActivity(intent);
            }
        });

        ra = getView().findViewById(R.id.ra);
        ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ra");
                startActivity(intent);
            }
        });
        ri = getView().findViewById(R.id.ri);
        ri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ri");
                startActivity(intent);
            }
        });
        ru = getView().findViewById(R.id.ru);
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ru");
                startActivity(intent);
            }
        });
        re = getView().findViewById(R.id.re);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "re");
                startActivity(intent);
            }
        });
        ro = getView().findViewById(R.id.ro);
        ro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "ro");
                startActivity(intent);
            }
        });

        wa = getView().findViewById(R.id.wa);
        wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "wa");
                startActivity(intent);
            }
        });
        wo = getView().findViewById(R.id.wo);
        wo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "wo");
                startActivity(intent);
            }
        });
        n = getView().findViewById(R.id.n);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HiraganaLearn.class);
                intent.putExtra("betu", "n");
                startActivity(intent);
            }
        });

    }

}
