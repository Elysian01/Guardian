package com.elysian.fingerprint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Scanner;

public class QRScanner extends AppCompatActivity {



    public static TextView resultTextView, fingertxt;
    Button scan_btn;
    Button btn_next;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_scanner);


        resultTextView = (TextView)findViewById(R.id.result_text);
        scan_btn = (Button)findViewById(R.id.btn_scan);

        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // startActivity(new Intent(getApplicationContext(), Scanner.class));
                Intent i2 = new Intent(QRScanner.this, QRCamera.class);
                startActivity(i2);

            }
        });

        btn_next = (Button)findViewById(R.id.btn_next);

        fingertxt = (TextView)findViewById(R.id.fingertxt);



        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // startActivity(new Intent(getApplicationContext(), Scanner.class));
                if(QRCamera.qrdone == 1) {
                    Intent i3 = new Intent(QRScanner.this, Fingerprint.class);
                    startActivity(i3);

                }
                else {
                    fingertxt.setText("First scan QR Code");
                    fingertxt.setTextColor(0xFFFF0000);
                }


            }
        });

    }
}
