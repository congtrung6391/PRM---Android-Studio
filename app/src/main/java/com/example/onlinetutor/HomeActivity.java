package com.example.onlinetutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Intent listIntent;
    CardView englishCard;
    CardView franceCard;
    CardView mathCard;
    CardView physicCard;

    void onSetupComponent() {
        englishCard = findViewById(R.id.english_card);
        franceCard = findViewById(R.id.france_card);
        mathCard = findViewById((R.id.math_card));
        physicCard = findViewById((R.id.physic_card));
    }

    void onSetupIntent() {
        listIntent = new Intent(HomeActivity.this, ListActivity.class);
    }

    void onSetupAction() {
        englishCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                listIntent.putExtra("class_type", "english");
                startActivity(listIntent);
            }
        });

        franceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                listIntent.putExtra("class_type", "france");
                startActivity(listIntent);
            }
        });

        mathCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                listIntent.putExtra("class_type", "math");
                startActivity(listIntent);
            }
        });

        physicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                listIntent.putExtra("class_type", "physic");
                startActivity(listIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        onSetupComponent();
        onSetupIntent();
        onSetupAction();


        Intent intent = getIntent();
        String message = intent.getStringExtra("username");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.homepage_username);
        textView.setText("Hello " + message);
    }
}