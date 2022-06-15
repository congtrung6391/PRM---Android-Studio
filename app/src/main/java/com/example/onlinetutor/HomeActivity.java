package com.example.onlinetutor;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Intent listIntent;
    CardView englishCard;
    CardView franceCard;
    CardView mathCard;
    CardView physicCard;
    Button startBtn;
    Button stopBtn;

    void startNotification() {
        String channel_id = "chanel_id";
        CharSequence name = "channel_name";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        Context context = getApplicationContext();
        Intent i = new Intent(
                Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        PendingIntent pe = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification builder = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("this is title").setContentText(" Music is playing")
                .setChannelId(channel_id).setContentIntent(pe).build();
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {// chu o
            NotificationChannel mchannel = new NotificationChannel(channel_id, name, importance);
            manager.createNotificationChannel(mchannel);
        }
        manager.notify(0, builder);
        // Intent ii = new Intent(HomeActivity.this, MyService.class);
        startActivity(i);
    }

    void stopNotification() {
        Intent i = new Intent();
    }

    void onSetupComponent() {
        englishCard = findViewById(R.id.english_card);
        franceCard = findViewById(R.id.france_card);
        mathCard = findViewById((R.id.math_card));
        physicCard = findViewById((R.id.physic_card));
        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);
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

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                startNotification();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                stopNotification();
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