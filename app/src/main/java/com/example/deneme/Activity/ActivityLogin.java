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

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    EditText kullaniciAdi,sifre;
    Button girisYap,kayitOl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new Alagan(getApplication());

        // ArkaPlan Animasyonu
        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();


        init();

        girisYap.setOnClickListener(this);
        kayitOl.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnGiris){
            Alagan.Instance.dbString.put("command","userLogin").put("data",kullaniciAdi.getText().toString().trim()).
                    put("password",sifre.getText().toString().trim()).read(new AlaganStringDatabase.AlaganListener() {
                @Override
                public void onResponse(String response) {
                    if(!response.equals("-1")){


                        startActivity(new Intent(getApplicationContext(),ActivityMain.class));

                    }
                }
            });
        }
        else if(v.getId()==R.id.btnKayit){
            Intent intent=new Intent(ActivityLogin.this,ActivityKayitOl.class);
            startActivity(intent);
        }

    }


    public void init()
    {
        kullaniciAdi=findViewById(R.id.editTextUsername);
        sifre=findViewById(R.id.editTextPassword);
        girisYap=findViewById(R.id.btnGiris);
        kayitOl=findViewById(R.id.btnKayit);
    }

}
