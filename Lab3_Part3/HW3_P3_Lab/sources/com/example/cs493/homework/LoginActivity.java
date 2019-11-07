package com.example.cs493.homework;

import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView Result;
    /* access modifiers changed from: private */
    public EditText mPasswordView;
    /* access modifiers changed from: private */
    public AutoCompleteTextView mUsernameView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0436R.layout.activity_login);
        this.mUsernameView = (AutoCompleteTextView) findViewById(C0436R.C0438id.username);
        this.mPasswordView = (EditText) findViewById(C0436R.C0438id.password);
        this.Result = (TextView) findViewById(C0436R.C0438id.Result);
        ((Button) findViewById(C0436R.C0438id.sign_in_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LoginActivity.this.attemptLogin(LoginActivity.this.mUsernameView.getText().toString(), LoginActivity.this.mPasswordView.getText().toString());
            }
        });
    }

    /* access modifiers changed from: private */
    public Boolean attemptLogin(String Username, String Password) {
        int X = 1;
        String Username2 = Username + "@CS493";
        for (int i = 0; i < Username2.length(); i++) {
            X = (Username2.charAt(i) * X) % 12345678;
        }
        if (Password.equals(Integer.valueOf(X).toString())) {
            this.Result.setText("Success!");
        } else {
            this.Result.setText("Wrong Password!");
        }
        return Boolean.valueOf(false);
    }
}
