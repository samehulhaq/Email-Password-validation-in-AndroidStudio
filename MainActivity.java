package com.example.a3rdquestion;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button MainActivityChangePassword;
    EditText MainActivityEmail,MainActivityPassword,MainActivityConfirmPassword;
    TextView MainActivityEmailerror,MainActivityPasswordError,MainActivityConfirmPassError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityChangePassword=findViewById(R.id.ChanePass);
        MainActivityEmail=findViewById(R.id.MainActivityEmail);
        MainActivityPassword=findViewById(R.id.MainActivityPassword);
        MainActivityConfirmPassword=findViewById(R.id.MainActivityConfirm);
        //message
        MainActivityEmailerror=findViewById(R.id.EmailAlert);
        MainActivityPasswordError=findViewById(R.id.PaswordAlert);
        MainActivityConfirmPassError=findViewById(R.id.ConfirmPassAlert);

        MainActivityChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmail();
                validatePassword();
            }
        });

    }
    private boolean validateEmail() {
        String emailInput = MainActivityEmail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            MainActivityEmailerror.setText("Field can't be empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            MainActivityEmailerror.setText("Please enter a valid email address");
            return false;
        } else {
            MainActivityEmailerror.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = MainActivityPassword.getText().toString().trim();
        String ConfitmpasswordInput = MainActivityConfirmPassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            MainActivityPasswordError.setText("Field can't be empty");
            return false;
        }  if (passwordInput.length()<5) {
            MainActivityPasswordError.setText("Password must be at least 5 characters");
            return false;
        }
        if (!passwordInput.equals(ConfitmpasswordInput)) {
            MainActivityConfirmPassError.setText("Password Would Not be matched");
            return false;
        }else {
            MainActivityConfirmPassError.setText("Password Matched");
            return true;
        }
    }
}
