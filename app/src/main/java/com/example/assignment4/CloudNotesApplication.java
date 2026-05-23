package com.example.assignment4;

import android.app.Application;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;

public class CloudNotesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());

            Log.i("CloudNotesApp",
                    "Amplify configured successfully");

        } catch (AmplifyException e) {

            Log.e("CloudNotesApp",
                    "Amplify configuration failed",
                    e);
        }
    }
}
