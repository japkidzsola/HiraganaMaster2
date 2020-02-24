package com.example.hiraganamaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdatbazisSegito extends SQLiteOpenHelper {

    public static User loggedinuser;
    private static final int DBversion = 2;
    private static final String DBname = "tanulok.db";

    private static final String TABLE_NAME = "tanulok";

    private static final String COL_ID = "id";
    private static final String COL_NEV = "nev";
    private static final String COL_EMAIL = "email";
    private static final String COL_JELSZO = "jelszo";
    private static final String COL_KEDVENCEK = "kedvencek";

    public AdatbazisSegito(Context context) {super(context,DBname,null,DBversion); }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTables = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(" +
                COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NEV+" VARCHAR(30)," +
                COL_EMAIL+ " VARCHAR(30)," +
                COL_JELSZO+ " VARCHAR(30)," +
                COL_KEDVENCEK+ " VARCHAR(30))";
        db.execSQL(createTables);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean adatFelvetel(String nev, String email, String jelszo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NEV, nev);
        values.put(COL_EMAIL, email);
        values.put(COL_JELSZO, jelszo);

        //return db.insert(TABLE_NAME, null, values) != -1;
        long erintettSorok = db.insert(TABLE_NAME, null, values);
        if (erintettSorok == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor adatLekerdezes(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

    public Cursor idLekerdez()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT id FROM " + TABLE_NAME, null);
    }

    public long adatModositas(String id, String nev, String email, String jelszo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NEV, nev);
        values.put(COL_EMAIL, email);
        values.put(COL_JELSZO, jelszo);


        return db.update(TABLE_NAME,values,COL_ID+" = ?",new String[]{id});
    }

    public boolean Bejelentkezes(String felhasznalonev,String jelszo){
        SQLiteDatabase db = this.getReadableDatabase();
        User u= new User();
        Cursor Adat = this.getFelhasznaloAdat(felhasznalonev);
        if (Adat.getCount()==0)
        {
            return false;
        }
        while(Adat.moveToNext())
        {
            if (Adat.getString(1).equals(jelszo))
            {
                loggedinuser=new User();
                loggedinuser.setFelhasznalonev(felhasznalonev);
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    public Cursor selectTeljesNev(String felhasznalonev)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor eredmeny = db.rawQuery("SELECT nev FROM " + TABLE_NAME + " WHERE nev = '" + felhasznalonev + "'", null);
        return eredmeny;
    }

    public boolean bejelentkezett(boolean sikeres)
    {
        return true;
    }

    public Cursor getFelhasznaloAdat(String felhasznalonev)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT felhasz,jelszo FROM "+TABLE_NAME +" WHERE felhasz ='"+felhasznalonev+"'", null);
    }

    public Cursor Bejelentkezes(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

    String nev;
    public String Bejelentkezoneve(String s) {
        nev+= s;
        return s;
    }

    public boolean insertFavorite(/*int id, */String favorite)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_KEDVENCEK,favorite);

        //return db.insert(TABLE_NAME, null, values) != -1;
        long erintettSorok = db.insert(TABLE_NAME, null, contentValues);
        if (erintettSorok == -1){
            return false;
        }else{
            return true;
        }
    }
}
