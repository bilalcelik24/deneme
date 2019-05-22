package com.example.deneme.Fragment.Fragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deneme.Alagan.Alagan;
import com.example.deneme.Alagan.Class.AlaganStringDatabase;
import com.example.deneme.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FragmentOgrenSoru extends Fragment {

    TextView soru,ornekCumle;
    Button btnCevap1,btnCevap2,btnCevap3,btnCevap4,next;
    String rightAnswer,date;


    List<Button> btnList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ogren_soru,null);

        init(view);


        soruCek();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butonAktif();
                soruCek();
            }
        });


        btnCevap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnCevap1.getText().toString().equals(rightAnswer)){
                    RightAnswer();
                    Toast.makeText(getContext(),"Doğru Cevap",Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(getContext(),"Yalnış Cevap",Toast.LENGTH_SHORT).show();
                }
                butonIptal();

            }
        });
        btnCevap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnCevap2.getText().toString().equals(rightAnswer)){
                    RightAnswer();
                    Toast.makeText(getContext(),"Doğru Cevap",Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(getContext(),"Yalnış Cevap",Toast.LENGTH_SHORT).show();
                }
                butonIptal();
            }
        });
        btnCevap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnCevap3.getText().toString().equals(rightAnswer)){
                    RightAnswer();
                    Toast.makeText(getContext(),"Doğru Cevap",Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(getContext(),"Yalnış Cevap",Toast.LENGTH_SHORT).show();
                }
                butonIptal();
            }
        });
        btnCevap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnCevap4.getText().toString().equals(rightAnswer)){
                    RightAnswer();
                    Toast.makeText(getContext(),"Doğru Cevap",Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(getContext(),"Yalnış Cevap",Toast.LENGTH_SHORT).show();
                }
                butonIptal();
            }
        });


        return view;
    }

    private void soruCek() {
        Alagan.Instance.dbString.put("command","kelimeogren").read(new AlaganStringDatabase.AlaganListener() {
            @Override
            public void onResponse(String response) {
                String isim[]=response.split("<");
                for(int i=0;  i<isim.length; i++){
                    String veriler[]=isim[i].split(">");


                    btnList=new ArrayList<>();
                    btnList.add(btnCevap1);
                    btnList.add(btnCevap2);
                    btnList.add(btnCevap3);
                    btnList.add(btnCevap4);

                    soru.setText(veriler[0]);
                    ornekCumle.setText(veriler[2]);
                    Random rand=new Random();
                    int r=rand.nextInt(4);

                    Button btnRightAnswer = btnList.get(r);

                    btnRightAnswer.setText(veriler[1]);
                    rightAnswer=veriler[1];
                    btnList.remove(r);
                    Alagan.Instance.dbString.put("command","cevapHavuzu").read(new AlaganStringDatabase.AlaganListener() {
                        @Override
                        public void onResponse(String response) {

                            String randomWord[]=response.split(">");
                            Button randomAnswer1=btnList.get(0);
                            Button randomAnswer2=btnList.get(1);
                            Button randomAnswer3=btnList.get(2);

                            randomAnswer1.setText(randomWord[0]);
                            randomAnswer2.setText(randomWord[1]);
                            randomAnswer3.setText(randomWord[2]);




                        }
                    });
                    break;



                }
            }
        });
    }

    public void init(View view){
        btnCevap1 = view.findViewById(R.id.FragmentOgrenSoruCevap1Button);
        btnCevap2 = view.findViewById(R.id.FragmentOgrenSoruCevap2Button);
        btnCevap3 = view.findViewById(R.id.FragmentOgrenSoruCevap3Button);
        btnCevap4 = view.findViewById(R.id.FragmentOgrenSoruCevap4Button);
        next = view.findViewById(R.id.FragmentOgrenSoruNext);

        soru = view.findViewById(R.id.FragmentOgrenSoruTextView);
        ornekCumle = view.findViewById(R.id.FragmentOgrenSoruTxtOrnk);




    }
    private void RightAnswer(){
        long oneDayLongValue = 1000 * 60 * 60 * 24;
        Date now = new Date();
        Date after15Day = new Date(now.getTime() + (5 * oneDayLongValue));
        SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");

        Alagan.Instance.dbString.put("command","createWord").put("userID","7").put("sentence",ornekCumle.getText().toString().trim()).put("word",soru.getText().toString().trim())
                .put("date",today.format(after15Day)).put("status","1").put("wordMean",rightAnswer).read(new AlaganStringDatabase.AlaganListener() {
            @Override
            public void onResponse(String response) {
                if(response.equals("1")){

                }
                else if(response.equals("-1")){


                }
            }
        });


    }

    private void butonIptal(){
        btnCevap1.setClickable(false);
        btnCevap2.setClickable(false);
        btnCevap3.setClickable(false);
        btnCevap4.setClickable(false);
    }
    private void butonAktif(){
        btnCevap1.setClickable(true);
        btnCevap2.setClickable(true);
        btnCevap3.setClickable(true);
        btnCevap4.setClickable(true);
    }

}

