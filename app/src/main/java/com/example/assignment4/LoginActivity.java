package com.example.assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class LoginActivity extends AppCompatActivity {

    EditText emailInput, passwordInput, codeInput;
    Button signUpButton, confirmButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        codeInput = findViewById(R.id.codeInput);

        signUpButton = findViewById(R.id.signUpButton);
        confirmButton = findViewById(R.id.confirmButton);
        loginButton = findViewById(R.id.loginButton);

        checkExistingSession();

        signUpButton.setOnClickListener(v -> signUpUser());
        confirmButton.setOnClickListener(v -> confirmUser());
        loginButton.setOnClickListener(v -> signInUser());
    }

    private void checkExistingSession() {
        Amplify.Auth.fetchAuthSession(
                result -> runOnUiThread(() -> {
                    if (result.isSignedIn()) {
                        showToast("Already signed in");
                        openMainActivity();
                    }
                }),
                error -> runOnUiThread(() ->
                        showToast("Session check failed"))
        );
    }

    private void signUpUser() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            showToast("Enter email and password");
            return;
        }

        AuthSignUpOptions options = AuthSignUpOptions.builder()
                .userAttribute(AuthUserAttributeKey.email(), email)
                .build();

        Amplify.Auth.signUp(
                email,
                password,
                options,
                result -> runOnUiThread(() ->
                        showToast("Sign up successful. Check email for code.")),
                error -> runOnUiThread(() ->
                        showToast("Sign up failed: " + error.getLocalizedMessage()))
        );
    }

    private void confirmUser() {
        String email = emailInput.getText().toString().trim();
        String code = codeInput.getText().toString().trim();

        if (email.isEmpty() || code.isEmpty()) {
            showToast("Enter email and confirmation code");
            return;
        }

        Amplify.Auth.confirmSignUp(
                email,
                code,
                result -> runOnUiThread(() ->
                        showToast("Account confirmed. Now sign in.")),
                error -> runOnUiThread(() ->
                        showToast("Confirm failed: " + error.getLocalizedMessage()))
        );
    }

    private void signInUser() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            showToast("Enter email and password");
            return;
        }

        Amplify.Auth.signIn(
                email,
                password,
                result -> runOnUiThread(() -> {
                    if (result.isSignedIn()) {
                        showToast("Login successful");
                        openMainActivity();
                    } else {
                        showToast("Additional login step required");
                    }
                }),
                error -> runOnUiThread(() ->
                        showToast("Login failed: " + error.getLocalizedMessage()))
        );
    }

    private void openMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}