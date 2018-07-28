package com.hackathon.candidate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hackathon.R;

public class CandidateViewActivity extends AppCompatActivity {
    public static final String TAG = CandidateViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_view);
    }
}
