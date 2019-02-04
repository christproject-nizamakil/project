package com.always.work_hard_junior_yao.christ_project_nizamakil.login_registration_pack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.always.work_hard_junior_yao.christ_project_nizamakil.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
    TextView emailreset;
    Button confirm_email;
    private FirebaseAuth mAuth;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        //loading bar
        pd = new ProgressDialog(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        //////////////////////////////////////////////////////

        confirm_email = findViewById(R.id.buttonreset);
        emailreset = findViewById(R.id.resetemail);

        confirm_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetpassword(emailreset.getText().toString().trim());
            }
        });

    }

    private void resetpassword(String email123) {


        if (TextUtils.isEmpty(email123)) {
            Toast.makeText(this, "Enter an Email", Toast.LENGTH_SHORT).show();
            return;
        }

        pd.setTitle("Creating your account ");
        pd.setMessage("Please Wait");
        pd.setCanceledOnTouchOutside(true);
        pd.show();

        mAuth.sendPasswordResetEmail(email123).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    pd.dismiss();
                    Toast.makeText(ResetPassword.this, "Reset Email Sent ", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(i);


                } else {
                    pd.dismiss();
                    Toast.makeText(ResetPassword.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
