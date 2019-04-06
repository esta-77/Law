package com.example.franko.law;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Intent.ACTION_SENDTO;

public class LawyerProfileActivity extends AppCompatActivity {

    private TextView name ,title ,total_cases ,lost_cases ,won_cases ,desc, place_of_work;
    private CircleImageView lawyer_photo;
    private ImageView telephone, message;
    private Bundle bundle;
    private DatabaseReference database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laywer_profile);
        bundle = getIntent().getExtras();
        populateView();
    }

    private void populateView() {
        name = findViewById(R.id.lawyer_name);
        title = findViewById(R.id.lawyer_group);
        total_cases = findViewById(R.id.cases_total);
        lost_cases = findViewById(R.id.cases_lost);
        won_cases = findViewById(R.id.cases_won);
        desc = findViewById(R.id.description);
        telephone = findViewById(R.id.call);
        message = findViewById(R.id.message);
        lawyer_photo = findViewById(R.id.lawyer_image);

        name.setText(bundle.getString("name"));
        total_cases.setText(bundle.getString("cases"));
        lost_cases.setText(bundle.getString("cases_lost"));
        won_cases.setText(bundle.getString("cases_won"));
        desc.setText(bundle.getString("desc"));
        Glide.with(LawyerProfileActivity.this).load(bundle.getString("image")).into(lawyer_photo);


        database = FirebaseDatabase.getInstance().getReference("lawyer_groups/"+bundle.getString("id"));
        System.out.println("id "+bundle.getString("id"));
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String, Object> object = (HashMap<String, Object>) dataSnapshot.getValue();
                System.out.println("name "+dataSnapshot.getValue());
                title.setText(String.valueOf(object.get("name")));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast call = Toast.makeText(this, "Call", "5000");
                //Toast.makeText(this,"call","5000").show();
                call();
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmessage();
            }
        });

    }

    protected void sendmessage(){
        Log.i("Send SMS","");
        Intent smsIntent = new Intent(Intent.ACTION_SEND);
        String phonenumber =  bundle.getString("contact");
        Uri smsUri = Uri.parse("sms:" + phonenumber);
        smsIntent.setData(smsUri);
        smsIntent.putExtra("address",phonenumber);
        smsIntent.putExtra("sms_body","Hello,please i need your help i'm in trouble");
        smsIntent.setType("text/plain");
        startActivity(smsIntent);

    }

    protected void call(){
        Intent phonecall = new Intent(Intent.ACTION_DIAL);
        String phoneNumber = bundle.getString("contact");
        phonecall.setData(Uri.parse("tel:"+phoneNumber));
        startActivity(phonecall);

    }
}
