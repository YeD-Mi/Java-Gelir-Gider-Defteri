package com.example.a182805015;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class giderekle extends AppCompatActivity {

    Button geribtn,giderkayit;
    EditText harcama,ucret,aciklama;
    Veritabanim VT;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giderekle);
        VT=new Veritabanim(this);
        harcama=findViewById(R.id.harcama);
        ucret=findViewById(R.id.ucret);
        aciklama=findViewById(R.id.aciklama);
        geribtn=findViewById(R.id.geribtn);
        giderkayit=findViewById(R.id.giderkaydet);
        giderkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yeniharcama=harcama.getText().toString();
                String yeniucret=ucret.getText().toString();
                String yeniaciklama=aciklama.getText().toString();
                if(yeniharcama.equals("") ||yeniucret.equals("")||yeniaciklama.equals(""))
                {
                    Toast.makeText(giderekle.this,"Eksik bilgi girdiniz..",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean insert = VT.giderekle(yeniharcama,yeniucret,yeniaciklama);
                    if(insert==true)
                    {
                        Toast.makeText(giderekle.this,"Kayit Basarili.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ResultReceiver.class);
                        intent.setAction(Bildirim_Kanali.ACTION_CLICK);
                        Bildirim.with(getApplicationContext()).showNotification(
                                "Dikkat Et",
                                "Harcamalarına Dikkat Et",
                                R.mipmap.ic_launcher,
                                intent);
                    }else
                        {
                                Toast.makeText(giderekle.this,"Kayit Basarisiz ",Toast.LENGTH_SHORT).show();
                         }

                }
            }
        });

        geribtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gerigit = new Intent(giderekle.this,anasayfa.class);
                startActivity(gerigit);
            }
        });
    }
}