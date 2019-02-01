package com.always.work_hard_junior_yao.christ_project_nizamakil.login_registration_pack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.always.work_hard_junior_yao.christ_project_nizamakil.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Register_acti.class);
        startActivity(i);

    }
}

