package com.example.hiraganamaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiraganamaster.ui.hiraganamasterhome.HiraganaMasterHomeFragment;
import com.example.hiraganamaster.ui.hiraganamasterhome.HiraganaMasterHomeViewModel;

public class Login extends AppCompatActivity {

    public EditText etName, etPassword;
    public Button btnLogin,btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdatbazisSegito dbhelper = new AdatbazisSegito(Login.this);
                Cursor cursorAdatok = dbhelper.Bejelentkezes();
                if (cursorAdatok == null){
                    Toast.makeText(Login.this,
                            "Sikertlen Adatlekérdezés", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (cursorAdatok.getCount() == 0){
                    Toast.makeText(Login.this,
                            "Nincs még felvéve adat", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                String bejelentkezoneve = etName.getText().toString();
                String bejelentkezojelszava = etPassword.getText().toString();
                boolean felhaszjo = false;
                boolean jelszojo = false;


                while (cursorAdatok.moveToNext()){
                    stringBuffer.append("ID: "+cursorAdatok.getString(0));
                    if (bejelentkezoneve.equals(cursorAdatok.getString(1)))
                    {
                        felhaszjo = true;
                    }
                    if (bejelentkezoneve.equals(cursorAdatok.getString(2)))
                    {
                        felhaszjo = true;
                    }
                    if (bejelentkezojelszava.equals(cursorAdatok.getString(3)))
                    {
                        jelszojo = true;
                    }
                }

                if(felhaszjo == true && jelszojo == true)
                {
                    String bejelentkezofelhasz = dbhelper.Bejelentkezoneve(bejelentkezoneve);
                    /*Intent intent = new Intent(Login.this, HiraganaMasterHomeFragment.class);
                    startActivity(intent);*/
                    finish();
                }
                else
                {
                    Toast.makeText(Login.this, "Hiba történt", Toast.LENGTH_SHORT).show();
                }
            }
            }
        );

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Registration.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init()
    {
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistration = findViewById(R.id.btnRegistration);
    }
}
