package com.example.a182805015;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Veritabanim extends SQLiteOpenHelper
{
    //private static final String LOG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    // Veritabanı
    private static final String DATABASE_NAME = "veritabani";
    // Tablolar
    private static final String DBKULLANICI = "kullanici";
    private static final String DBGIDER = "giderler";
    private static final String DBGELIR = "gelirler";
    // Tablo Sutun
    private static final String KEY_ID = "id";
    private static final String TUTAR = "tutar";
    private static final String ACIKLAMA = "aciklama";
    private static final String KULLANICIADI = "kullaniciadi";
    private static final String SIFRE = "sifre";
    private static final String HARCAMA = "harcama";
    //Tablolar olusturulur
    private static final String VTKULLANICI = "CREATE TABLE "
            + DBKULLANICI + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KULLANICIADI
            + " TEXT," + SIFRE + " TEXT" + ")";

    private static final String VTGIDER = "CREATE TABLE " + DBGIDER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + HARCAMA
            + " TEXT," + TUTAR + " TEXT," + ACIKLAMA + " TEXT" + ")";

    private static final String VTGELIR = "CREATE TABLE "
            + DBGELIR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + HARCAMA
            + " TEXT," + TUTAR + " TEXT," + ACIKLAMA + " TEXT" + ")";

    public Veritabanim(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // creating required tables
        db.execSQL(VTKULLANICI);
        db.execSQL(VTGIDER);
        db.execSQL(VTGELIR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + DBKULLANICI);
        db.execSQL("DROP TABLE IF EXISTS " + DBGIDER);
        db.execSQL("DROP TABLE IF EXISTS " + DBGELIR);

        onCreate(db);
    }
    public Boolean kullaniciolustur(String kullaniciadi,String sifre){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put("kullaniciadi",kullaniciadi);
        val.put("sifre",sifre);
        long result=db.insert("kullanici",null,val);
        if(result==0) return false;
        else
            return true;
    }
    public Boolean kullanicikontrol(String kullaniciadi){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from kullanici where kullaniciadi = ?",new String[]{kullaniciadi});
        if(cursor.getCount()>0)
            return true;
        else
            return  false;
    }
    public Boolean kullanicisifrekontrol(String kullaniciadi,String sifre){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from kullanici where kullaniciadi = ? and sifre = ?",new String[]{kullaniciadi,sifre});
        if(cursor.getCount()>0)
            return true;
        else
            return  false;
    }
    public Boolean giderekle(String harcama, String ucret, String aciklama){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put("harcama",harcama);
        val.put("tutar", ucret);
        val.put("aciklama",aciklama);
        long result=db.insert("giderler",null,val);
        if(result==0) return false;
        else
            return true;
    }
    public Boolean gelirekle(String harcama, String ucret, String aciklama){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put("harcama",harcama);
        val.put("tutar", ucret);
        val.put("aciklama",aciklama);
        long result=db.insert("gelirler",null,val);
        if(result==0) return false;
        else
            return true;
    }
    public List<Kullanici_harcamalar> giderlerlistele() {
        List<Kullanici_harcamalar> giderlist = new ArrayList<Kullanici_harcamalar>();
        SQLiteDatabase db=this.getReadableDatabase();
        String[] allColumns = {"id","harcama","tutar","aciklama"};
        Cursor cursor = db.query("giderler",allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Kullanici_harcamalar listele = harcamalistele(cursor);
            giderlist.add(listele);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return giderlist;
    }
    private Kullanici_harcamalar harcamalistele(Cursor cursor) {
        Kullanici_harcamalar giderlist = new Kullanici_harcamalar();
        giderlist.setId(cursor.getInt(0));
        giderlist.setHarcama(cursor.getString(1));
        giderlist.setGiderucret(cursor.getString(2));
        giderlist.setGideraciklama(cursor.getString(3));
        return giderlist;
    }
    public List<Kullanici_gelirler> gelirlerlistele() {
        List<Kullanici_gelirler> gelirlist = new ArrayList<Kullanici_gelirler>();
        SQLiteDatabase db=this.getReadableDatabase();
        String[] allColumns = {"id","harcama","tutar","aciklama"};
        Cursor cursor1 = db.query("gelirler",allColumns, null, null, null, null, null);
        cursor1.moveToFirst();
        while (!cursor1.isAfterLast()) {
            Kullanici_gelirler listele1 = gelirlistele(cursor1);
            gelirlist.add(listele1);
            cursor1.moveToNext();
        }
        cursor1.close();
        return gelirlist;
    }
    private Kullanici_gelirler gelirlistele(Cursor cursor1) {
        Kullanici_gelirler gelirlist = new Kullanici_gelirler();
        gelirlist.setId(cursor1.getInt(0));
        gelirlist.setHarcama(cursor1.getString(1));
        gelirlist.setGiderucret(cursor1.getString(2));
        gelirlist.setGideraciklama(cursor1.getString(3));
        return gelirlist;
    }
}
