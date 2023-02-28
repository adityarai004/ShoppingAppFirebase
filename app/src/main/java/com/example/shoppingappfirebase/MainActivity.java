package com.example.shoppingappfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    UserAdapter userAdapter;
    ArrayList<ItemModel> list;
    Button button;
    EditText editText;

    TextView goldPriceTV,realTimeGoldPriceTV;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mDatabase = FirebaseDatabase.getInstance().getReference("GoldPrice").child("Price");

        //writing data to firebase
//        button = findViewById(R.id.button);
//        editText = findViewById(R.id.editText);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDatabase.setValue(editText.getText().toString());
//            }
//        });

        // Reading Data from the firebase
//        realTimeGoldPriceTV = findViewById(R.id.realTimeGoldPriceTV);
//        mDatabase.addValueEventListener(
//                new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        //when any change in data occurs
//                        realTimeGoldPriceTV.setText(snapshot.getValue().toString());
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//        });

        //Writing Custom Objects on firebase
//        mDatabase = FirebaseDatabase.getInstance().getReference("MyUsers");
//        EditText username = findViewById(R.id.usernameET);
//        EditText password = findViewById(R.id.passwordET);
//        Button btn = findViewById(R.id.button);
//        //don't forget to add internet permission
//        //add firebase database dependency
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                DataModel user1 = new DataModel(username.getText().toString(), password.getText().toString());
//                mDatabase.setValue(user1);
//            }
//        });


        recyclerView = findViewById(R.id.recyclerView);
        mDatabase = FirebaseDatabase.getInstance().getReference("Users");
        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();
        userAdapter = new UserAdapter(this, list);
        recyclerView.setAdapter(userAdapter);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ItemModel user = snapshot.getValue(ItemModel.class);
                    list.add(user);
                }
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}