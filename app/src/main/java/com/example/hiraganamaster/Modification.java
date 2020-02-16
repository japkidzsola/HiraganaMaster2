package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiraganamaster.ui.settings.SettingsFragment;

public class Modification extends AppCompatActivity {

    EditText etName1, etEmail,etPassword;
    Button btnEdit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        init();

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nev = etName1.getText().toString();
                String email = etEmail.getText().toString();
                String jelszo = etPassword.getText().toString();
                if (nev.isEmpty() || email.isEmpty() || jelszo.isEmpty()){
                    Toast.makeText(Modification.this,
                            "Minden mezőt ki kell tölteni", Toast.LENGTH_SHORT).show();
                    return;
                }
                /*adatModosit(nev, email, jelszo);*/
                Intent vissza =
                        new Intent(Modification.this,SettingsFragment.class);
                startActivity(vissza);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Modification.this, SettingsFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
/*
    private void adatModosit(String bejelentkezoneve, String bejelentkezoemail, String jelszo) {
        AdatbazisSegito dbHelper = new AdatbazisSegito(this);
        long erintettSorok = dbHelper.adatModositas(bejelentkezoneve, bejelentkezoemail ,jelszo);
        switch ((int)erintettSorok){
            case -1: Toast.makeText(this, "Sikertelen Módosítás", Toast.LENGTH_SHORT).show(); break;
            case 0: Toast.makeText(this, "Az adott id-val nem szerepel rekord", Toast.LENGTH_SHORT).show(); break;
            default: Toast.makeText(this, "Sikeres Módosítás", Toast.LENGTH_SHORT).show(); break;
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
