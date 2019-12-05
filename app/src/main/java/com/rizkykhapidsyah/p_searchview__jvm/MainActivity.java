package com.rizkykhapidsyah.p_searchview__jvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView SV_SearchView_IDJAVA;
    ListView LV_ListView_IDJAVA;

    ArrayAdapter<String> Pencocok;

    String[] ListNamaAlat = {
            "Gunting",
            "Pisau",
            "Parang",
            "Gergaji",
            "Palu/Martil",
            "Mur",
            "Obeng",
            "Tang",
            "Cutter",
            "Timah Kawat",
            "Soder",
            "Multitester"
    };

    int X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SV_SearchView_IDJAVA = findViewById(R.id.SV_SearchView_IDXML);
        LV_ListView_IDJAVA = findViewById(R.id.LV_ListView_IDXML);

        final ArrayList<String> Alat = new ArrayList<>();
        for (X = 0; X <= 11; X++) {
            Alat.add(ListNamaAlat[X]);
        }

        Pencocok = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Alat);

        LV_ListView_IDJAVA.setAdapter(Pencocok);
        SV_SearchView_IDJAVA.setOnQueryTextListener(this);


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Pencocok.getFilter().filter(newText);
        return false;
    }
}
