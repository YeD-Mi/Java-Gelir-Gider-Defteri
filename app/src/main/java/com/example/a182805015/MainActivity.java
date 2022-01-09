package com.example.a182805015;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText kullaniciadi,sifre;
    private Button giris,uyeol;
    Veritabanim VT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VT=new Veritabanim(this);
        kullaniciadi=findViewById(R.id.username);
        sifre=findViewById(R.id.password);
        giris=findViewById(R.id.girisyap);
        uyeol=findViewById(R.id.uyeol);
        Intent verial=getIntent();
        String user=verial.getStringExtra("kullaniciadi");
        kullaniciadi.setText(user);
        uyeol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,kayitol.class));
            }
        });
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=kullaniciadi.getText().toString();
                String password=sifre.getText().toString();
                    if(user.equals("") || password.equals(""))
                    {
                        Toast.makeText(MainActivity.this, "Kullanici adi ve sifre gir.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Boolean checkuserpass=VT.kullanicisifrekontrol(user,password);
                        if(checkuserpass==true)
                        {
                            Toast.makeText(MainActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,anasayfa.class));
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Bilgileriniz Yanlis", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });
    }
}