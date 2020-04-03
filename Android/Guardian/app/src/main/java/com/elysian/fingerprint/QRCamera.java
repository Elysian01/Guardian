package com.elysian.fingerprint;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCamera extends AppCompatActivity implements ZXingScannerView.ResultHandler {



    public static int qrdone =0;

    ZXingScannerView ScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView = new ZXingScannerView(this);

        setContentView(ScannerView);
    }

    @Override
    public void handleResult(Result result) {

        QRScanner.resultTextView.setText(result.getText());
        onBackPressed();

    }

    @Override
    protected void onPause() {
        super.onPause();
        qrdone = 1;
        ScannerView.stopCamera();
    }

    @Override
    protected void onResume(){
        super.onResume();
        qrdone = 0;


        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }
}
