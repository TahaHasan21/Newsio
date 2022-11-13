package com.example.newsio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    TextView txtSignIn;
    TextInputEditText uname, Email, pwd ,pno;

    Button btn ;
    ProgressBar progressBar;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        txtSignIn = findViewById(R.id.txtSignIn);
        uname = (TextInputEditText) findViewById(R.id.editUsername);
        pno = (TextInputEditText) findViewById(R.id.edtSignUpMobile);
        Email = (TextInputEditText) findViewById(R.id.edtSignUpEmail);
        pwd = (TextInputEditText) findViewById(R.id.edtSignUpPassword);

        btn =  (Button) findViewById(R.id.btnSignUp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    AuthMain();


            }
        });





        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,LoginPage.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void AuthMain() {
        String username = uname.getText().toString().trim();
        String password = pwd.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String phno = pno.getText().toString().trim();

        if (username.isEmpty()){
            uname.setError("Username is required");
            uname.requestFocus();
            return;

        }

        else if (password.isEmpty()){
            pwd.setError("Username is required");
            pwd.requestFocus();
            return;

        }

        else if (email.isEmpty()){
            Email.setError("Username is required");
            Email.requestFocus();
            return;

        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Please Provide Valid Email");
            Email.requestFocus();
            return;
        }

        else if (phno.isEmpty()){
            pno.setError("Username is required");
            pno.requestFocus();
            return;

        }


            progressBar.setVisibility(View.VISIBLE);
            mAuth = FirebaseAuth.getInstance();

            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);



                            }
                            else {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(SignUp.this, "Failed to Register! Try Again !", Toast.LENGTH_LONG).show();
                            }






                        }
                    });




    }
}
