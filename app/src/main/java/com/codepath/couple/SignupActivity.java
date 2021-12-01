package com.codepath.couple;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codepath.couple.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";

    EditText etSignUName;
    EditText etSignPassword;
    Button btnSignUpSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        etSignUName = findViewById(R.id.etSignUName);
        etSignPassword = findViewById(R.id.etSignPassword);
        btnSignUpSubmit = findViewById(R.id.btnSignUpSubmit);
        btnSignUpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = etSignPassword.getText().toString();
                String username = etSignUName.getText().toString();

                signup(password, username);
            }
        });

    }

    private void signup(String password, String username) {
        // Make new user
        ParseUser user = new ParseUser();

        //Set values for new user
        user.setUsername(username);
        user.setPassword(password);
        user.put("handle", username);

        Intent i = new Intent(this, LoginActivity.class);
        Toast.makeText(SignupActivity.this, "Sign up successs!", Toast.LENGTH_SHORT).show();
        startActivity(i);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Log.i(TAG, "SIGN UP SUCCESS!!!");
                    //DO STUFF
                } else {
                    e.getStackTrace();
                }
            }
        });
    }
}