package com.example.a182805015;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kayitol extends AppCompatActivity {
    EditText kullaniciadi,sifre,sifrekontrol;
    Button geri,uyeol;
    Veritabanim VT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);
        VT=new Veritabanim(this);
        kullaniciadi=findViewById(R.id.yenikullaniciadi);
        sifre=findViewById(R.id.yenisifre);
        sifrekontrol=findViewById(R.id.sifrekontrol);
        geri=findViewById(R.id.btngeri);
        uyeol=findViewById(R.id.btnkayitol);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(kayitol.this,MainActivity.class));
            }
        });
        uyeol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String user=kullaniciadi.getText().toString();
                String password=sifre.getText().toString();
                String repassword=sifrekontrol.getText().toString();
                if(user.equals("") || password.equals("")||repassword.equals(""))
                {
                    Toast.makeText(kayitol.this,"Lutfen bilgilerinizi girin.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.equals(repassword))
                    {
                        Boolean checkuser=VT.kullanicikontrol(user);
                        if(checkuser==false)
                        {
                            Boolean insert = VT.kullaniciolustur(user,password);
                            if(insert==true)
                            {
                                Toast.makeText(kayitol.this,"Kayit Basarili.",Toast.LENGTH_SHORT).show();
                                Intent basariligiris = new Intent(kayitol.this,MainActivity.class);
                                basariligiris.putExtra("kullaniciadi",user);
                                startActivity(basariligiris);;
                            }else {
                                Toast.makeText(kayitol.this,"Kayit Basarisiz ",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(kayitol.this,"Bu kullanici adi alinmis",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(kayitol.this,"Sifreler Uyusmuyor.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}