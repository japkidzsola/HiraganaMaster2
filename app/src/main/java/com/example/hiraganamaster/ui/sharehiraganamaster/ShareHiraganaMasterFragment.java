package com.example.hiraganamaster.ui.sharehiraganamaster;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hiraganamaster.R;

public class ShareHiraganaMasterFragment extends Fragment {

    private ShareHiraganaMasterViewModel mViewModel;

    Button sharefacebook,shareinstagram, sharetwitter, sharewhatsapp,sharegoogleplus;
    String uriString;

    public static ShareHiraganaMasterFragment newInstance() {
        return new ShareHiraganaMasterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.share_hiragana_master_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShareHiraganaMasterViewModel.class);

        sharefacebook = getView().findViewById(R.id.sharefacebook);
        shareinstagram = getView().findViewById(R.id.shareinstagram);
        sharetwitter = getView().findViewById(R.id.sharetwitter);
        sharewhatsapp = getView().findViewById(R.id.sharewhatsapp);
        sharegoogleplus = getView().findViewById(R.id.sharegoogleplus);


        sharefacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                uriString = "https://www.facebook.com/suzuki.zsolt";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, uriString);
                sharingIntent.setPackage("com.facebook.katana");
                startActivity(sharingIntent);
            }
        });

        shareinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "This is the best App for Learning Hiragana" + "\n"/*link to google play*/);
                sharingIntent.setPackage("com.instagram.android");
                startActivity(sharingIntent);
            }
        });

        final String twitterdownload = getString(R.string.twittersharefail);
        shareinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "This is the best App for Learning Hiragana" + "\n"/*link to google play*/);
                    sharingIntent.setPackage("advanced.twitter.android");
                    startActivity(sharingIntent);
                }catch(Exception e)
                {
                    Toast.makeText(getContext(), twitterdownload, Toast.LENGTH_SHORT).show();
                }
            }
        });

        final String whatsappdownload = getString(R.string.whatsappsharefail);
        shareinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "This is the best App for Learning Hiragana" + "\n"/*link to google play*/);
                    sharingIntent.setPackage("com.whatsapp");
                    startActivity(sharingIntent);
                }catch(Exception e)
                {
                    Toast.makeText(getContext(), whatsappdownload, Toast.LENGTH_SHORT).show();
                }
            }
        });

        final String googleplusdownload = getString(R.string.googleplussharefail);
        shareinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "This is the best App for Learning Hiragana" + "\n"/*link to google play*/);
                    sharingIntent.setPackage("com.google.android.apps.plus");
                    startActivity(sharingIntent);
                }catch(Exception e)
                {
                    Toast.makeText(getContext(), googleplusdownload, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
