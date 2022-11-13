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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    TextView txtSignUp;

    TextInputEditText uname, Email, pwd ,pno;

    Button btn ;
    ProgressBar progressBar;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        txtSignUp = findViewById(R.id.txtSignUp);
        progressBar = (ProgressBar) findViewById(R.id.pbar);

        Email = (TextInputEditText) findViewById(R.id.edtSignInEmail);
        pwd = (TextInputEditText) findViewById(R.id.edtSignInPassword);

        btn =  (Button) findViewById(R.id.btnSignIn);

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthMain();
            }
        });



    }
    private void AuthMain() {
        String password = pwd.getText().toString().trim();
        String email = Email.getText().toString().trim();

        if (email.isEmpty()){
            Email.setError("Username is required");
            Email.requestFocus();
            return;

        }


        else if (password.isEmpty()){
            pwd.setError("Username is required");
            pwd.requestFocus();
            return;

        }


        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Please Provide Valid Email");
            Email.requestFocus();
            return;
        }



        progressBar.setVisibility(View.VISIBLE);
        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(LoginPage.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);



                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(LoginPage.this, "Failed to Register! Try Again !", Toast.LENGTH_LONG).show();
                        }






                    }
                });




    }
}

