package com.example.resumeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static String name = "Soheil Homayoonfard";
    static String phone = "+989022232312";
    static String[] email = {"soheilhomayoonfard@gmail.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0; i < 3; i++)
            Toast.makeText(this, "Welcome To My Resume", Toast.LENGTH_LONG).show();

        TextView name_TextView = findViewById(R.id.name_TextView);
        if (name.length() < 20)
            name_TextView.setText(name);
        else
            name_TextView.setText(name.substring(0,20)+"...");
    }

    public void mailButtonClick(View view){
        ImageButton button = findViewById(R.id.email_Button);
        button.setOnClickListener(v -> sendEmail());
    }

    public void phoneButtonClick(View view){
        ImageButton button = findViewById(R.id.phone_Button);
        button.setOnClickListener(v -> dialPhone());
    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.setData(Uri.parse("mailto:"));
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else
            Toast.makeText(MainActivity.this,"there is no application that support this action",
                    Toast.LENGTH_SHORT).show();
    }

    private void dialPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phone));
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else
            Toast.makeText(MainActivity.this,"there is no application that support this action",
                    Toast.LENGTH_SHORT).show();
    }

}