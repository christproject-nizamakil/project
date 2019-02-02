package com.always.work_hard_junior_yao.christ_project_nizamakil.login_registration_pack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.always.work_hard_junior_yao.christ_project_nizamakil.MainActivity;
import com.always.work_hard_junior_yao.christ_project_nizamakil.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText email,password ;
    Button Log_in ;
    private ProgressDialog pd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        Log_in = findViewById(R.id.Login);
        email = findViewById(R.id.email);
        password= findViewById(R.id.password);
        //loading bar
        pd = new ProgressDialog(this );

        Log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });

        }

    private void login(String email , String password) {
        //loading bar
        pd.setTitle("Verification");
        pd.setMessage("Please Wait");
        pd.setCanceledOnTouchOutside(true);
        pd.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "Authentication Confirmed ", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            pd.dismiss();

                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Register_acti.class);
        startActivity(i);

    }
}

