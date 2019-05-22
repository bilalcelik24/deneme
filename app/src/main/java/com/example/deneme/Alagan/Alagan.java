package com.example.deneme.Alagan;

import android.content.Context;

import com.example.deneme.Alagan.Class.AlaganStringDatabase;
import com.example.deneme.Alagan.Class.AlaganView;


public class Alagan {
    Context main;

    public static Alagan Instance;

    public AlaganStringDatabase dbString;
    public AlaganView View;


    public Alagan(Context main)
    {
        this.main = main;
        Instance = this;
        dbString = new AlaganStringDatabase(main);
        View = new AlaganView(main);
    }



}
