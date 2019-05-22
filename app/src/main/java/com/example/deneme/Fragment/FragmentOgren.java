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
import com.example.deneme.R;

public class FragmentOgren extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View main= inflater.inflate(R.layout.fragment_ogren,null);

        // Ogren butonuna basınca ilgili fragmenti yüklüyor
        Button btn= main.findViewById(R.id.FragmentOgrenButtonBasla);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.Instance.loadFragment(new FragmentOgrenSoru()) ;
            }
        });
        return main;
    }


}
