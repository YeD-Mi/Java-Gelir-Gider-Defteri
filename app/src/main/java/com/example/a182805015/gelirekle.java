package com.example.a182805015;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gelirekle extends AppCompatActivity {
    Button geribtn,gelirkayit;
    EditText yenigelir,yenipara,aciklama;
    Veritabanim VT;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelirekle);
        VT=new Veritabanim(this);
        yenigelir=findViewById(R.id.gelirim);
        yenipara=findViewById(R.id.ucretim);
        aciklama=findViewById(R.id.geliraciklama);
        geribtn=findViewById(R.id.geribtn);
        gelirkayit=findViewById(R.id.gelirkaydet);
        gelirkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yenigelirim=yenigelir.getText().toString();
                String yeniucret=yenipara.getText().toString();
                String yeniaciklama=aciklama.getText().toString();
                if(yenigelirim.equals("") ||yeniucret.equals("")||yeniaciklama.equals(""))
                {
                    Toast.makeText(gelirekle.this,"Eksik bilgi girdiniz..",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean insert = VT.gelirekle(yenigelirim,yeniucret,yeniaciklama);
                    if(insert==true)
                    {
                        Toast.makeText(gelirekle.this,"Kayit Basarili.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ResultReceiver.class);
                        intent.setAction(Bildirim_Kanali.ACTION_CLICK);
                        Bildirim.with(getApplicationContext()).showNotification(
                                "Gözün Aydın",
                                "Gelir Sisteme Eklendi.",
                                R.mipmap.ic_launcher,
                                intent);
                    }else
                    {
                        Toast.makeText(gelirekle.this,"Kayit Basarisiz ",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        geribtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gerigit = new Intent(gelirekle.this,anasayfa.class);
                startActivity(gerigit);
            }
        });
    }
}