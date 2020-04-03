package com.elysian.fingerprint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;


@TargetApi(Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

    public Context context;

    public FingerprintHandler(Context context) {

        this.context= context;
    }

    public void startAuth (FingerprintManager fingerprintManager , FingerprintManager.CryptoObject cryptoObject) {

        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject,cancellationSignal,0,this,null);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("You can now access our Application",true);
    }

//    @Override
//    public void onAuthenticationError(int errCode , CharSequence errString) {
//        this.update("There was an Error" + errString,false);
//    }

    @Override
    public void onAuthenticationFailed() {
        this.update("Auth Failed",false);
    }

    private void update(String s, boolean b) {
        TextView paraLabel = (TextView) ((Activity)context).findViewById(R.id.paraLabel);
        ImageView fingerprintImage = (ImageView) ((Activity)context).findViewById(R.id.fingerprintImage);


        paraLabel.setText(s);

        if (b == false) {
            paraLabel.setTextColor(ContextCompat.getColor(context,R.color.errorAccent));
        }
        else {
            paraLabel.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
            fingerprintImage.setImageResource(R.drawable.done);

            
        }
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("Error : " + helpString , false);
    }
}

