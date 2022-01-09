package com.example.a182805015;

public class Kullanici_gelirler {
    int id;
    String giderucret,harcama,gideraciklama;

    public int getId() {return id;}

    public String getGiderucret() {return giderucret;}

    public void setGiderucret(String giderucret) { this.giderucret = giderucret;  }

    public void setId(int id) {this.id = id;}

    public String getHarcama() {return harcama;}

    public void setHarcama(String harcama) {this.harcama = harcama; }

    public String getGideraciklama() {return gideraciklama;}

    public void setGideraciklama(String gideraciklama) { this.gideraciklama = gideraciklama; }

    public Kullanici_gelirler() {
        this.giderucret = giderucret;
        this.harcama = harcama;
        this.gideraciklama = gideraciklama;
    }
    public String toString(){
        return ""+id+" - "+harcama+" - "+giderucret+" TL - "+gideraciklama;
    }
}
