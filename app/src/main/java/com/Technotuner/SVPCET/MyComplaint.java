package com.Technotuner.SVPCET;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.Technotuner.SVPCET.Adapter.RecyclerAdapter;
import com.Technotuner.SVPCET.Model.RecyclerInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MyComplaint extends AppCompatActivity {

    String fullName, mobileNo, location, city, description , image;

    List<RecyclerInfo> listComplaints;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    FirebaseDatabase firebaseDatabase;
    FirebaseFirestore firestore;
    FirebaseAuth firebaseAuth;
    FirebaseUser currentUser;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_complaint);

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        initializeRecyclerView();

    }

    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.myComplaintRecyclerView);
        listComplaints = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // here do the firebase loop and get data into adapter and show as the complaint
        DocumentReference documentReference = firestore.collection("MyComplaints").document(firebaseAuth.getCurrentUser().getUid());
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value !=null)
                {

                }
            }
        });




        fullName = "Amit Thakare";
        mobileNo = "7767987378";
        location = "Bele layout";
        city = "yavatmal";
        description = "Kuch nai";
        image = "";

        RecyclerInfo recyclerInfo = new RecyclerInfo(fullName,mobileNo,location,description,image,city);
        listComplaints.add(recyclerInfo);

        //here at last attach the list to the adapter like below
        recyclerAdapter= new RecyclerAdapter(getApplicationContext(),listComplaints);
        recyclerView.setAdapter(recyclerAdapter);

    }
}