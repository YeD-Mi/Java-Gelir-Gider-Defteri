package com.example.a182805015;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class anasayfa extends AppCompatActivity {
    Button cikis,giderekle,gelirekle;
    Veritabanim VT;
    ArrayAdapter<Kullanici_harcamalar> arrayAdapter;
    ListView giderlistem;
    ArrayAdapter<Kullanici_gelirler> arrayAdapter1;
    ListView gelirlistem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        final Veritabanim VT=new Veritabanim(this);
        giderekle=findViewById(R.id.add);
        gelirekle=findViewById(R.id.add1);
        cikis=findViewById(R.id.cikisbtn);
        List<Kullanici_harcamalar> giderlist = VT.giderlerlistele();
        giderlistem = (ListView) findViewById(R.id.giderlist);
        arrayAdapter = new ArrayAdapter<Kullanici_harcamalar>(this, android.R.layout.simple_list_item_1, giderlist);
        giderlistem.setAdapter(arrayAdapter);
        List<Kullanici_gelirler> gelirlist = VT.gelirlerlistele();
        gelirlistem = (ListView) findViewById(R.id.gelirlist);
        arrayAdapter1 = new ArrayAdapter<Kullanici_gelirler>(this, android.R.layout.simple_list_item_1, gelirlist);
        gelirlistem.setAdapter(arrayAdapter1);
        cikis.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(anasayfa.this, "Nereye Aslanim?", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(anasayfa.this,MainActivity.class));
            }
        });
        giderekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(anasayfa.this,giderekle.class));
            }
        });
        gelirekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(anasayfa.this,gelirekle.class));
            }
        });
    }
}