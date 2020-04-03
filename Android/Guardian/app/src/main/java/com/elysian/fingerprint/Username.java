package com.elysian.fingerprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Username extends AppCompatActivity {

    private EditText username , error;
    private Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        username = (EditText) findViewById(R.id.username);
        error = (EditText) findViewById(R.id.error);


        verify = (Button) findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!username.getText().toString().matches("")) {
                    Intent i1 = new Intent(Username.this, QRScanner.class);
                    startActivity(i1);
                }
                else {
                    error.setText("Please enter Username");
                    error.setTextColor(0xFFFF0000);
                }
            }
        });

    }
}
