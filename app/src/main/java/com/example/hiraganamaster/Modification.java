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

        final String unsuccessful = getString(R.string.unsuccessful);
        final String empty = getString(R.string.emptyquery);
        final String fill = getString(R.string.fill);

        Cursor cursorAdatok = dbhelper.adatLekerdezes();
        if (cursorAdatok == null){
            Toast.makeText(Modification.this,
                    unsuccessful, Toast.LENGTH_SHORT).show();
            return;
        }
        if (cursorAdatok.getCount() == 0){
            Toast.makeText(Modification.this,
                    empty, Toast.LENGTH_SHORT).show();
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
            if(cursorAdatok.isNull(4)) {
                Toast.makeText(this, "no fav/nincs kedvenc", Toast.LENGTH_SHORT).show();
            }else
            {
                stringBuffer.append("favorites: " + cursorAdatok.getString(4) + "\r\n");
            }
            stringBuffer.append("\r\n");
        }
        TextView tw = findViewById(R.id.textAdatok);
        //ezzel lehet tesztelni a felhasználó adatait
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
                            fill, Toast.LENGTH_SHORT).show();
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
        String idno = getString(R.string.id_no_profile);
        String unsuccessful = getString(R.string.unsuccessfull_change);
        String successful = getString(R.string.successfull_change);
        AdatbazisSegito dbHelper = new AdatbazisSegito(this);
        long erintettSorok = dbHelper.adatModositas(id, bejelentkezoneve, bejelentkezoemail ,jelszo);
        switch ((int)erintettSorok){
            case -1: Toast.makeText(this, unsuccessful, Toast.LENGTH_SHORT).show(); break;
            case 0: Toast.makeText(this, idno, Toast.LENGTH_SHORT).show(); break;
            default: Toast.makeText(this, successful, Toast.LENGTH_SHORT).show(); break;
        }
    }

    public void init()
    {
        etName1 = findViewById(R.id.etName1);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnEdit = findViewById(R.id.btnEdit);
        btnBack = findViewById(R.id.btnBack);
    }
}
