package com.hackathon.candidate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hackathon.R;

public class CandidateViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_view);

        TextView textView = findViewById(R.id.textView);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("id");

        textView.setText("Nom "+position);
    }
}
