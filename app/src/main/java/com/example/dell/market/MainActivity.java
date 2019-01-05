package com.example.dell.market;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private PreferencesStorage preferencesStorage;

    @Override
    protected void onStart() {
        super.onStart();

        preferencesStorage = new PreferencesStorage(MainActivity.this);
        if (preferencesStorage.getEmail() != null){
            Intent intent = new Intent(this, DisplayScreen.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesStorage = new PreferencesStorage(MainActivity.this);

        final EditText etName = findViewById(R.id.etName);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (user != preferencesStorage.getEmail() && password != preferencesStorage.getPassword()){
                    Toast.makeText(MainActivity.this, "Error",Toast.LENGTH_SHORT).show();
                    
                }else {
                    Intent displayScreen = new Intent(MainActivity.this,DisplayScreen.class);

                    displayScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    displayScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(displayScreen);
                }

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registScreen = new Intent(MainActivity.this, Register.class);
                startActivity(registScreen);
            }
        });


    }

    public void forgotClick(View view) {
        Intent intent = new Intent(MainActivity.this,forgot.class);
        startActivity(intent);
    }
}
