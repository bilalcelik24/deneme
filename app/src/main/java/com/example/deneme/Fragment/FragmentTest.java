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
import com.example.deneme.Fragment.Fragment2.FragmentTestSoru;
import com.example.deneme.R;

public class FragmentTest extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View main = inflater.inflate(R.layout.fragment_test, null);

        // Ogren butonuna basınca ilgili fragmenti yüklüyor
        Button btnSeviye1 = main.findViewById(R.id.FragmentTestButton1);
        btnSeviye1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTestSoru k = new FragmentTestSoru();
                k.setData("1");
                ActivityMain.Instance.loadFragment(k) ;
            }
        });

        Button btnSeviye2 = main.findViewById(R.id.FragmentTestButton2);
        btnSeviye2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTestSoru k = new FragmentTestSoru();
                k.setData("2");
                ActivityMain.Instance.loadFragment(k) ;
            }
        });

        Button btnSeviye3 = main.findViewById(R.id.FragmentTestButton3);
        btnSeviye3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTestSoru k = new FragmentTestSoru();
                k.setData("3");
                ActivityMain.Instance.loadFragment(k) ;
            }
        });

        Button btnSeviye4 = main.findViewById(R.id.FragmentTestButton4);
        btnSeviye4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTestSoru k = new FragmentTestSoru();
                k.setData("4");
                ActivityMain.Instance.loadFragment(k) ;
            }
        });

        return main;
    }
}
