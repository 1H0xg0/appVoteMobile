package com.hackathon.election;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hackathon.R;

public class ElectionViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election_view);

        TextView textView = findViewById(R.id.textView);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("id");

        textView.setText("Nom "+position);
    }
}
