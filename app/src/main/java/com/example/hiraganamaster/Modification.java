package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiraganamaster.ui.hiraganamasterhome.HiraganaMasterHomeFragment;
import com.example.hiraganamaster.ui.settings.SettingsFragment;

public class Modification extends AppCompatActivity {

    EditText etName1, etEmail,etPassword;
    Button btnEdit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        init();
        final AdatbazisSegito dbhelper = new AdatbazisSegito(Modification.this);

        Cursor cursorAdatok = dbhelper.adatLekerdezes();
        if (cursorAdatok == null){
            Toast.makeText(Modification.this,
                    "Sikertlen Adatlekérdezés", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cursorAdatok.getCount() == 0){
            Toast.makeText(Modification.this,
                    "Nincs még felvéve adat", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (cursorAdatok.moveToNext()){
            stringBuffer.append("ID: "+cursorAdatok.getString(0) + "\r\n");
            stringBuffer.append(cursorAdatok.getString(1));
            etName1.setText(cursorAdatok.getString(1));
            stringBuffer.append(cursorAdatok.getString(2));
            etEmail.setText(cursorAdatok.getString(2));
            stringBuffer.append("password: "+cursorAdatok.getString(3) + "\r\n");
            stringBuffer.append("\r\n");
        }
        TextView tw = findViewById(R.id.textAdatok);
        //tw.setText(stringBuffer.toString());


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursorAdatok = dbhelper.idLekerdez();
                StringBuffer stringBuffer = new StringBuffer();
                String id = null;
                while (cursorAdatok.moveToNext()) {
                    //stringBuffer.append(cursorAdatok.getString(0));
                    id = cursorAdatok.getString(0);
                }

                String nev = etName1.getText().toString();
                String email = etEmail.getText().toString();
                String jelszo = etPassword.getText().toString();
                if (nev.isEmpty() || email.isEmpty() || jelszo.isEmpty()){
                    Toast.makeText(Modification.this,
                            "Minden mezőt ki kell tölteni", Toast.LENGTH_SHORT).show();
                    return;
                }
                //idLekerdez(nev);
                adatModosit(id, nev, email, jelszo);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void adatModosit(String id, String bejelentkezoneve, String bejelentkezoemail, String jelszo) {
        AdatbazisSegito dbHelper = new AdatbazisSegito(this);
        long erintettSorok = dbHelper.adatModositas(id, bejelentkezoneve, bejelentkezoemail ,jelszo);
        switch ((int)erintettSorok){
            case -1: Toast.makeText(this, "Sikertelen Módosítás", Toast.LENGTH_SHORT).show(); break;
            case 0: Toast.makeText(this, "Az adott id-val nem szerepel rekord", Toast.LENGTH_SHORT).show(); break;
            default: Toast.makeText(this, "Sikeres Módosítás", Toast.LENGTH_SHORT).show(); break;
        }
    }

    /*private void idLekerdez(String nev)
    {
        AdatbazisSegito dbHelper = new AdatbazisSegito(this);
        if (dbHelper.idLekerdez(nev)) {
            Toast.makeText(this, "Sikeres Adatfelvétel", Toast.LENGTH_SHORT).show();
        }
    }*/

    public void init()
    {
        etName1 = findViewById(R.id.etName1);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnEdit = findViewById(R.id.btnEdit);
        btnBack = findViewById(R.id.btnBack);
    }
}
