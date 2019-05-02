package com.example.ge62.diplomahotelreserv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ge62.diplomahotelreserv.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;
    Button loginBtn,registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        loginBtn=(Button)findViewById(R.id.loginBtn);

        final TextInputLayout emailWrapper = (TextInputLayout) findViewById(R.id.emailWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAllFields();


            }
            public void validateAllFields()
            {
                String email=emailWrapper.getEditText().getText().toString();
                String pass=passwordWrapper.getEditText().getText().toString();

                if(!validateEmail(email)&&!validatePassword(pass)) {
                    emailWrapper.setError("invalid email address!");
                    passwordWrapper.setError("password will consist from 6 symbols!");
                }
                else if(!validateEmail(email)&&validatePassword(pass)){
                    emailWrapper.setError("invalid email address!");
                    passwordWrapper.setErrorEnabled(false);
                }
                else if(validateEmail(email)&&!validatePassword(pass)){
                    emailWrapper.setErrorEnabled(false);
                    passwordWrapper.setError("password will consist from 6 symbols!");
                }
                else {
                    //signIn(emailWrapper.getEditText().getText().toString(),passwordWrapper.getEditText().getText().toString(),grant_type);
                    doLogin();
                }
            }

        });

    }




    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 6;
    }

    public void doLogin() {
        Intent intent=new Intent(MainActivity.this,UserEnteredActivity.class);
        startActivity(intent);
    }



}
