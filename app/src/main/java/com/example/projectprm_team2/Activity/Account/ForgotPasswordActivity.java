package com.example.projectprm_team2.Activity.Account;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectprm_team2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity  {

    private EditText emailEditText;
    private Button resetPasswordButton;
    private ProgressBar progressBar;
    private TextView hint;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = (EditText) findViewById(R.id.editEmail);
        resetPasswordButton = (Button) findViewById(R.id.btnresetpassword);
        hint = findViewById(R.id.hint);

        auth = FirebaseAuth.getInstance();
        Init();

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickResetPassword();
            }
        });
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
    private void Init() {
        findViewById(R.id.btn_back_to_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void onClickResetPassword(){
        String email = emailEditText.getText().toString().trim();

        if(email.isEmpty()){
            emailEditText.setError(" Email không được để trống");
            emailEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Vui lòng cung cấp đúng Email");
            emailEditText.requestFocus();
            return;
        }

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPasswordActivity.this,"Đã xác nhận! Vui Lòng kiểm tra mail của bạn để làm lại mật khẩu",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(ForgotPasswordActivity.this,"Email không đúng! Vui lòng nhập lại",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}