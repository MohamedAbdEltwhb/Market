package com.example.dell.market;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DELL on 03/01/2019.
 */

public class Register extends AppCompatActivity {

    private PreferencesStorage preferencesStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        preferencesStorage = new PreferencesStorage(Register.this);

        final EditText userName = findViewById(R.id.etNewName);
        final EditText email = findViewById(R.id.etNewEmail);
        final EditText password = findViewById(R.id.etNewPassword);
        Button btnRegister = findViewById(R.id.btnNewRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUser = userName.getText().toString();
                String newEmail = email.getText().toString();
                String newPassword = password.getText().toString();

                preferencesStorage.putUserName(newUser);
                preferencesStorage.putEmail(newEmail);
                preferencesStorage.putPassword(newPassword);

                Intent displayScreen = new Intent(Register.this,MainActivity.class);

                startActivity(displayScreen);



            }
        });

    }
}
