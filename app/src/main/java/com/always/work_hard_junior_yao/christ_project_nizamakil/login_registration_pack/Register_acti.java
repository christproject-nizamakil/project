package com.always.work_hard_junior_yao.christ_project_nizamakil.login_registration_pack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.always.work_hard_junior_yao.christ_project_nizamakil.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register_acti extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText Email, Password,c_password ;
    Button registration ;
    private ProgressDialog pd ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acti);


        //loading bar
        pd = new ProgressDialog(this );

        // Initialize Firebase Auth

        mAuth = FirebaseAuth.getInstance();

///////////////////////////////////////////////////////////////////////////////////////////////////////
        Email= findViewById(R.id.email1);
        Password = findViewById(R.id.password1);
        c_password =findViewById(R.id.Con_password1);
        registration=findViewById(R.id.reg);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Oncreatenewaccount();

            }
        });


    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void Oncreatenewaccount() {

        String password1=Password.getText().toString().trim() ;
        String cpassword=c_password.getText().toString().trim();
        String email = Email.getText().toString().trim();
        if(password1.equals(cpassword)) {
            password1 = Password.getText().toString();
        } else {
            Toast.makeText(this, "password do not match", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password1)){

            Toast.makeText(this, "Fill the form", Toast.LENGTH_LONG).show();
            return;
        } else {
            //loading bar
            pd.setTitle("Creating your account ");
            pd.setMessage("Please Wait");
            pd.setCanceledOnTouchOutside(true);
            pd.show();
            mAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(Register_acti.this, "Account Created",
                                Toast.LENGTH_LONG).show();
                        pd.dismiss();
                        Intent i = new Intent(getBaseContext(),LoginActivity.class);
                        startActivity(i);
                        FirebaseUser user = mAuth.getCurrentUser();
                    } else {
                        // If sign in fails, display a message to the user.
                        pd.dismiss();
                        Toast.makeText(Register_acti.this, task.getException().toString(),
                                Toast.LENGTH_LONG).show();

                        return;
                    }

                }
            });

        }


    }


}
