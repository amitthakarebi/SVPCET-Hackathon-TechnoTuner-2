package com.Technotuner.SVPCET;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class NewComplaint extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView toolbarBackBtn;
    private Spinner spinner;
    private String[] departmentList = {"Muncipal Council","Ministry of Road Transport & Highways, Government of India",
            "Department of Water Resources, River Development & Ganga Rejuvenation",
             "Ministry Of Power","Ministry of Agriculture and Farmers' Welfare",
            "Ministry of Food Processing Industries","Ministry of Health and Family Welfare",
            "Ministry of Health and Family Welfare","Ministry of Labour and Employment",
            "Ministry of Law and Justice","Ministry of Railways"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_complaint);
        initialize();
    }

    private void initialize() {

        toolbarBackBtn = findViewById(R.id.toolbar_back);
        spinner = findViewById(R.id.toDepartmentSpinnerNC);
        spinner.setOnItemSelectedListener(this);
        //spinner setting
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,departmentList);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);;
        spinner.setAdapter(arrayAdapter);

        toolbarBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, departmentList[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}