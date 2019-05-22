package com.example.deneme.Fragment.Fragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deneme.Alagan.Alagan;
import com.example.deneme.Alagan.Class.AlaganStringDatabase;
import com.example.deneme.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentProfilKelimeEkle extends Fragment {


    EditText Kelime,OrnkCumle,Anlami;
    Button Ekle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil_kelime_ekle,null);

        init(view);

        Ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long oneDayLongValue = 1000 * 60 * 60 * 24;
                Date now = new Date();
                Date after15Day = new Date(now.getTime() + (5 * oneDayLongValue));
                SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");

                Alagan.Instance.dbString.put("command","createWord").put("userID","7").put("sentence",OrnkCumle.getText().toString().trim()).put("word",Kelime.getText().toString().trim())
                        .put("date",today.format(after15Day)).put("status","1").put("wordMean",Anlami.getText().toString().trim()).read(new AlaganStringDatabase.AlaganListener() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("1")){
                            Toast.makeText(getContext(),"Kelime Eklendi",Toast.LENGTH_SHORT).show();
                        }
                        else if(response.equals("-1")){
                            Toast.makeText(getContext(),"Kelime Eklenmedi",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
        return view ;
    }

    public void init(View view){
        Kelime = view.findViewById(R.id.FragmentProfilKelimeEkleTxtKelime);
        OrnkCumle = view.findViewById(R.id.FragmentProfilKelimeEkleTxtOrnk);
        Anlami = view.findViewById(R.id.FragmentProfilKelimeEkleAnlam);
        Ekle = view.findViewById(R.id.FragmentProfilKelimeEkleBtnEkle);

    }
}
