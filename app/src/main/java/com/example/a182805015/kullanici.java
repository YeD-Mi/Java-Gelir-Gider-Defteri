package com.example.a182805015;

public class kullanici {
    String kullaniciadi;
    String sifre;

    public String getKullaniciadi() { return kullaniciadi;  }

    public void setKullaniciadi(String kullaniciadi) { this.kullaniciadi = kullaniciadi; }

    public String getSifre() { return sifre; }

    public void setSifre(String sifre) { this.sifre = sifre;  }

    public kullanici(String kullaniciadi, String sifre) {
        this.kullaniciadi = kullaniciadi;
        this.sifre = sifre;
    }
    public String toString(){
        return ""+kullaniciadi+"-"+sifre;
    }
}
