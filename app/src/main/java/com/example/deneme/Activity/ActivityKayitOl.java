package com.example.deneme.Activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deneme.Alagan.Alagan;
import com.example.deneme.Alagan.Class.AlaganStringDatabase;
import com.example.deneme.R;

public class ActivityKayitOl extends AppCompatActivity {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    Button kayitOl;
    EditText isim,soyİsim,kullaniciAdi,sifre,sifreDogrulama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);


        // ArkaPlan Animasyonu
        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();


        init();
    }

    public void init()
    {
        kayitOl = findViewById(R.id.btnKayitOl);
        isim = findViewById(R.id.editTextKayitAd);
        kullaniciAdi = findViewById(R.id.editTextKayitUsername);
        sifre = findViewById(R.id.editTextKayitPassword);
        sifreDogrulama = findViewById(R.id.editTextKayitPasswordCheck);
    }

    public void ActivityKayitOlButton(View view) {
        Alagan.Instance.dbString.put("command","createUser").put("username",kullaniciAdi.getText().toString().trim()).
                put("password",sifre.getText().toString().trim()).put("namesurname",isim.getText().toString().trim()).
                read(new AlaganStringDatabase.AlaganListener() {
                    @Override
                    public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(),""+response,Toast.LENGTH_LONG).show();
                    }
                });
        startActivity(new Intent(getApplicationContext(),ActivityLogin.class));
    }
}
