package com.example.admin.week_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ShowActivity extends AppCompatActivity {
    private EditText show_ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        show_ed = findViewById(R.id.show_ed);
        show_ed.setText(text);
    }
}
