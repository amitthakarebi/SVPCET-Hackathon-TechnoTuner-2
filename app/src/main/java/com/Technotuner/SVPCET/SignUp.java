package com.Technotuner.SVPCET;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    private EditText editTextName, editTextMobile, editTextEmail, editTextPassword;
    private Button signUpBtn, loginBtn;

    private String name_validation = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";

    FirebaseAuth firebaseAuth;
    FirebaseUser currentUser;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialize();
    }

    private void initialize() {

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextPassword = findViewById(R.id.editTextPassword);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        firestore = FirebaseFirestore.getInstance();

        signUpBtn = findViewById(R.id.signUpBtn);
        loginBtn = findViewById(R.id.loginBtn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConditions();

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

    private void checkConditions() {

        if (!TextUtils.isEmpty(editTextName.getText().toString()) && editTextName.getText().toString().matches(name_validation))
        {
            if(!TextUtils.isEmpty(editTextMobile.getText().toString()) && editTextMobile.getText().length() ==10)
            {
                if(!TextUtils.isEmpty(editTextEmail.getText().toString()) && Patterns.EMAIL_ADDRESS.matcher(editTextEmail.getText().toString()).matches())
                {
                    if (!TextUtils.isEmpty(editTextPassword.getText().toString()))
                    {
                        if (editTextPassword.getText().length() >=8)
                        {
                            firebaseAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(),editTextPassword.getText().toString())
                                    .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful())
                                            {
                                                currentUser = firebaseAuth.getCurrentUser();

                                                Map<String,Object> userData = new HashMap<>();
                                                userData.put("Full_Name",editTextName.getText().toString());
                                                userData.put("Mobile_No",editTextMobile.getText().toString());
                                                userData.put("Email_Id",editTextEmail.getText().toString());

                                                firestore.collection("Users").document(currentUser.getUid())
                                                        .set(userData)
                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful())
                                                                {
                                                                    Toast.makeText(SignUp.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
                                                                    Intent intent = new Intent(SignUp.this,OtpVerification.class);
                                                                    intent.putExtra("mobile",editTextMobile.getText().toString());
                                                                    startActivity(intent);
                                                                    finish();
                                                                }else
                                                                {
                                                                    Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        });

                                            }else
                                            {
                                                Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }else
                        {
                            editTextPassword.setError("Password should be at least 8 letters!");
                        }
                    }else
                    {
                        editTextPassword.setError("Enter Valid Password!");
                    }
                }else
                {
                    editTextEmail.setError("Enter Valid Email!");
                }
            }else
            {
                editTextMobile.setError("Enter Valid Mobile No!");
            }
        }else
        {
            editTextName.setError("Enter Valid Full Name!");
        }

    }
}