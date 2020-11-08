package com.Technotuner.SVPCET;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.Technotuner.SVPCET.Adapter.AdminRecyclerAdapter;
import com.Technotuner.SVPCET.Adapter.AllComplaintAdapter;
import com.Technotuner.SVPCET.Model.AdminRecyclerInfo;
import com.Technotuner.SVPCET.Model.AllComplaintRecyclerInfo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class AllComplaints extends AppCompatActivity {

    private String fullName , mobileNo , location, city , description, image, status;

    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    StorageReference storageReference;

    List<AllComplaintRecyclerInfo> allListComplaint;
    RecyclerView allComplaintRecyclerView;
    AllComplaintAdapter allComplaintAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_complaints);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        allComplaintRecyclerView = findViewById(R.id.allComplaintRecyclerView);
        allComplaintRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(AllComplaints.this, DividerItemDecoration.VERTICAL);
        allComplaintRecyclerView.addItemDecoration(dividerItemDecoration);

        getAllComplaints();
    }

    private void getAllComplaints() {
        allListComplaint = new ArrayList<>();

        DatabaseReference databaseReference =firebaseDatabase.getReference("Complaints");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren())
                {
                    for (DataSnapshot department : snapshot.getChildren())
                    {
                        for (DataSnapshot uid : department.getChildren())
                        {
                            for (DataSnapshot data : uid.getChildren())
                            {
                                String key = data.getKey();
                                if (key.equals("Full_Name"))
                                {
                                    fullName = String.valueOf(data.getValue());
                                }else if (key.equals("Address"))
                                {
                                    location = String.valueOf(data.getValue());
                                }else if (key.equals("Mobile_No"))
                                {
                                    mobileNo = String.valueOf(data.getValue());
                                }else if (key.equals("City"))
                                {
                                    city = String.valueOf(data.getValue());
                                }else if (key.equals("Description"))
                                {
                                    description = String.valueOf(data.getValue());
                                }else if (key.equals("Image"))
                                {
                                    image = String.valueOf(data.getValue());
                                }else if(key.equals("Status"))
                                {
                                    status = String.valueOf(data.getValue());
                                }
                            }
                            AllComplaintRecyclerInfo allComplaintRecyclerInfo = new AllComplaintRecyclerInfo(fullName,mobileNo,location,description,image,city,status);
                            allListComplaint.add(allComplaintRecyclerInfo);
                        }
                    }
                    allComplaintAdapter= new AllComplaintAdapter(getApplicationContext(),allListComplaint);
                    allComplaintRecyclerView.setAdapter(allComplaintAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}