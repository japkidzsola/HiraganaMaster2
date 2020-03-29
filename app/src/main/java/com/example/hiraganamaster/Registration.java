package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    public EditText etName1, etEmail,etPassword,etPasswordAgain;
    public Button btnRegistrate,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();

        final String fill = getString(R.string.fill);
        final String notsame = getString(R.string.password_not_same);

        btnRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nev = etName1.getText().toString();
                String email = etEmail.getText().toString();
                String jelszo = etPassword.getText().toString();
                String jelszoujra = etPasswordAgain.getText().toString();
                if (nev.isEmpty() || email.isEmpty() || jelszo.isEmpty() || jelszoujra.isEmpty()){
                    Toast.makeText(Registration.this,
                            fill, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!jelszo.equals(jelszoujra))
                {
                    Toast.makeText(Registration.this,
                            notsame, Toast.LENGTH_SHORT).show();
                    return;
                }
                adatFelvetel(nev, email, jelszo);
                Intent vissza =
                        new Intent(Registration.this,Login.class);
                startActivity(vissza);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this,Login.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void adatFelvetel(String bejelentkezoneve, String bejelentkezoemail, String jelszo) {
        String successfull = getString(R.string.successful_data_record);
        String unsuccessfull = getString(R.string.unsuccessful_data_record);

        AdatbazisSegito dbHelper = new AdatbazisSegito(Registration.this);
        if (dbHelper.adatFelvetel(bejelentkezoneve,bejelentkezoemail,jelszo)){
            Toast.makeText(this, successfull, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, unsuccessfull, Toast.LENGTH_SHORT).show();
        }
    }

    public void init()
    {
        etName1 = findViewById(R.id.etName1);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPasswordAgain = findViewById(R.id.etPasswordAgain);
        btnRegistrate = findViewById(R.id.btnRegistrate);
        btnLogin = findViewById(R.id.btnLogin);
    }
}
