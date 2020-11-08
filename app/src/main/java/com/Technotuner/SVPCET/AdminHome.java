package com.Technotuner.SVPCET;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.Technotuner.SVPCET.Adapter.AdminRecyclerAdapter;
import com.Technotuner.SVPCET.Adapter.RecyclerAdapter;
import com.Technotuner.SVPCET.Model.AdminRecyclerInfo;
import com.Technotuner.SVPCET.Model.RecyclerInfo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminHome extends AppCompatActivity {

    private String department;
    private String fullName , mobileNo , location, city , description, image, status;

    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    StorageReference storageReference;

    List<AdminRecyclerInfo> adminListComplaints;
    RecyclerView adminRecyclerView;
    AdminRecyclerAdapter adminRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        adminRecyclerView = findViewById(R.id.adminRecyclerView);
        adminRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(AdminHome.this, DividerItemDecoration.VERTICAL);
        adminRecyclerView.addItemDecoration(dividerItemDecoration);




        getDepartment();
        getComplaints();


    }

    private void getComplaints() {
        adminListComplaints = new ArrayList<>();

        DatabaseReference databaseReference =firebaseDatabase.getReference("Complaints").child(department);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren())
                {
                    for (DataSnapshot snap : snapshot.getChildren())
                    {
                        for (DataSnapshot snapshot1 : snap.getChildren())
                        {
                            String key = snapshot1.getKey();
                            if (key.equals("Full_Name"))
                            {
                                fullName = String.valueOf(snapshot1.getValue());
                            }else if (key.equals("Address"))
                            {
                                location = String.valueOf(snapshot1.getValue());
                            }else if (key.equals("Mobile_No"))
                            {
                                mobileNo = String.valueOf(snapshot1.getValue());
                            }else if (key.equals("City"))
                            {
                                city = String.valueOf(snapshot1.getValue());
                            }else if (key.equals("Description"))
                            {
                                description = String.valueOf(snapshot1.getValue());
                            }else if (key.equals("Image"))
                            {
                                image = String.valueOf(snapshot1.getValue());
                            }else if(key.equals("Status"))
                            {
                                status = String.valueOf(snapshot1.getValue());
                            }
                        }
                        AdminRecyclerInfo adminRecyclerInfo = new AdminRecyclerInfo(fullName,mobileNo,location,description,image,city,status);
                        adminListComplaints.add(adminRecyclerInfo);
                    }
                    adminRecyclerAdapter= new AdminRecyclerAdapter(getApplicationContext(),adminListComplaints);
                    adminRecyclerView.setAdapter(adminRecyclerAdapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void getDepartment() {

        Intent intent = getIntent();
        department = intent.getStringExtra("department");
        Toast.makeText(this, department, Toast.LENGTH_SHORT).show();
    }
}