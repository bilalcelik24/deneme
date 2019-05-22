package com.example.deneme.Fragment.Fragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deneme.Alagan.Alagan;
import com.example.deneme.Alagan.Class.AlaganStringDatabase;
import com.example.deneme.Alagan.Class.AlaganView;
import com.example.deneme.R;

public class FragmentProfilIstatistik extends Fragment {


    ProgressBar progressBar;
    EditText edtYear;
    Spinner spinner;
    Button btnYearQuery;
    CheckBox checkBox;
    TextView sayac;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profil_istatistik,null);

        progressBar=view.findViewById(R.id.Fragment_Profil_Progres);
        edtYear=view.findViewById(R.id.Fragment_Profil_Year);
        spinner=view.findViewById(R.id.Fragment_Profil_Spinner);
        btnYearQuery=view.findViewById(R.id.Fragment_Profil_Btn);
        checkBox=view.findViewById(R.id.Fragment_Profil_Check);
        sayac=view.findViewById(R.id.Fragment_profil_sayac);


        Alagan.Instance.View.InitalizeSpinner(spinner,"Ocak","Şubat","Mart","Nisan","Mayıs","Haziran","Temmuz",
                "Ağustos","Eylül","Ekim","Kasım","Aralık").ListeneSpinner(new AlaganView.AlaganSpinnerInterface() {
            @Override
            public void onSelectedItem(String data) {

            }
        });



        btnYearQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String degisken= "-1";
                if(checkBox.isChecked()){
                    degisken=""+(spinner.getSelectedItemPosition()+1);

                }

                Alagan.Instance.dbString.put("command","statistics").put("userID","7").
                        put("months",""+degisken).
                        put("year",edtYear.getText().toString().trim()).read(new AlaganStringDatabase.AlaganListener() {
                    @Override
                    public void onResponse(String response) {
                        int deger=Integer.valueOf(response);
                        sayac.setText(""+response);
                        progressBar.setProgress(deger);
                    }
                });
            }
        });


        return view;
    }
}
