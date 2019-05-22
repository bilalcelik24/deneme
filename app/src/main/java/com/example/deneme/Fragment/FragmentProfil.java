package com.example.deneme.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.deneme.Activity.ActivityMain;
import com.example.deneme.Fragment.Fragment2.FragmentOgrenSoru;
import com.example.deneme.Fragment.Fragment2.FragmentProfilIstatistik;
import com.example.deneme.Fragment.Fragment2.FragmentProfilKelimeEkle;
import com.example.deneme.R;

public class FragmentProfil extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View main= inflater.inflate(R.layout.fragment_profil,null);

        //Kelime Ekle Butonuna basınca ilgili fragmenti yüklüyor
        Button btn= main.findViewById(R.id.FragmentProfilKelimeEkleButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.Instance.loadFragment(new FragmentProfilKelimeEkle()) ;
            }
        });

        //İstatistik Butonuna basınca ilgili fragmenti yüklüyor
        Button btn2 = main.findViewById(R.id.FragmentProfilIstatistikBtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.Instance.loadFragment(new FragmentProfilIstatistik());
            }
        });
        return main;
    }
}
