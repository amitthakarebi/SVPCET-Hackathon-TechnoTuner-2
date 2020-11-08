package com.Technotuner.SVPCET;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdminViewComplaint extends AppCompatActivity {

    private TextView vFullName, vMobileNo, vLocation, vCity, vDescription;
    private Button readBtn, processingBtn, completeBtn;
    private String fullName , mobileNo , location, city , description, image;
    private ImageView vImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaint);

        vFullName = findViewById(R.id.VFullName);
        vMobileNo = findViewById(R.id.VMobileNo);
        vLocation = findViewById(R.id.VLocation);
        vCity = findViewById(R.id.VCity);
        vDescription = findViewById(R.id.VDescription);
        vImage = findViewById(R.id.VImage);

        readBtn = findViewById(R.id.vReadBtn);
        processingBtn = findViewById(R.id.vProcessingBtn);
        completeBtn = findViewById(R.id.vCompleteBtn);

        getIntentData();

    }

    private void getIntentData() {

        Intent intent = getIntent();
        fullName = intent.getStringExtra("name");
        mobileNo = intent.getStringExtra("mobile");
        location = intent.getStringExtra("location");
        city = intent.getStringExtra("city");
        description = intent.getStringExtra("description");
        image = intent.getStringExtra("image");

        vFullName.setText(fullName);
        vMobileNo.setText(mobileNo);
        vLocation.setText(location);
        vCity.setText(city);
        vDescription.setText(description);
        Glide.with(this).load(image).into(vImage);

    }
}