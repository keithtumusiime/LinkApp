package com.butoosa.linkapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {
	TextView title,link,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title = findViewById(R.id.title);
        link = findViewById(R.id.link);
        description = findViewById(R.id.description);

        String name  = getIntent().getExtras().getString("title");
        String link1 = getIntent().getExtras().getString("link");
        String description1 = getIntent().getExtras().getString("description") ;

        title.setText(name);
        link.setText(link1);
        description.setText(description1);

    }
}
