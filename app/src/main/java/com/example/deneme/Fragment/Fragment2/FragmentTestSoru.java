package com.example.deneme.Fragment.Fragment2;

import android.content.Intent;
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

import com.example.deneme.Activity.ActivityMain;
import com.example.deneme.Alagan.Alagan;
import com.example.deneme.Alagan.Class.AlaganStringDatabase;
import com.example.deneme.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FragmentTestSoru extends Fragment {

    String level;
    TextView soru,ornekCumle,anlam;
    Button btnCevap1,btnCevap2,btnCevap3,btnCevap4,next;
    String rightAnswer,date;
    List<Button> btnList;
    String wordId;
    int i=0 ,sayac=0;
    int gun;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_soru, null);

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
                    WrongAnswer();
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
                    WrongAnswer();
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
                    WrongAnswer();
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
                    WrongAnswer();
                    Toast.makeText(getContext(),"Yalnış Cevap",Toast.LENGTH_SHORT).show();
                }
                butonIptal();
            }
        });






        return view;
    }

    private void soruCek() {
        Alagan.Instance.dbString.put("command","wordList").put("userID","7").put("derece",level).read(new AlaganStringDatabase.AlaganListener() {
            @Override
            public void onResponse(String response) {
                if(response.equals("null")){
                    Toast.makeText(getContext(),"Test Edilecek Kelime yok",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getContext(), ActivityMain.class));
                    return;
                }
                String isim[]=response.split("<");



                    for(i=sayac; i<isim.length; i++){
                        String veriler[]=isim[i].split(">");
                        sayac=sayac+1;
                        wordId=veriler[0];

                        try {
                            gun=Integer.valueOf(veriler[2]);
                        }catch (Exception e){

                        }


                        if(gun<=0){

                            btnList=new ArrayList<>();
                            btnList.add(btnCevap1);
                            btnList.add(btnCevap2);
                            btnList.add(btnCevap3);
                            btnList.add(btnCevap4);
                            soru.setText(veriler[1]);
                            ornekCumle.setText(veriler[4]);
                            Random rand=new Random();
                            int r=rand.nextInt(4);

                            Button btnRightAnswer = btnList.get(r);

                            btnRightAnswer.setText(veriler[5]);
                            rightAnswer=veriler[5];
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

                if(sayac==isim.length){
                    Toast.makeText(getContext(),"Test Edilecek Kelime yok",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getContext(), ActivityMain.class));
                    return;
                }
                }





        });
    }

    public void setData(String i)
    {
        level=i;
    }
    public void init(View view){

        btnCevap1 = view.findViewById(R.id.FragmentTestSoruCevap1Btn);
        btnCevap2 = view.findViewById(R.id.FragmentTestSoruCevap2Btn);
        btnCevap3 = view.findViewById(R.id.FragmentTestSoruCevap3Btn);
        btnCevap4 = view.findViewById(R.id.FragmentTestSoruCevap4Btn);

        next = view.findViewById(R.id.FragmentTestSoruNext);

        soru = view.findViewById(R.id.FragmentTestSoruTextView);
        ornekCumle = view.findViewById(R.id.FragmentTestSoruTxtOrnk);



    }

    private void RightAnswer(){

        Alagan.Instance.dbString.put("command","wordUpdate").put("wordID",wordId)
                .put("status","1").read(new AlaganStringDatabase.AlaganListener() {
            @Override
            public void onResponse(String response) {

            }
        });


    }

    private void WrongAnswer(){

        Alagan.Instance.dbString.put("command","wordUpdate").put("wordID",wordId)
                .put("status","0").read(new AlaganStringDatabase.AlaganListener() {
            @Override
            public void onResponse(String response) {

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
