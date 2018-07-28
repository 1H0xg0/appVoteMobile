package com.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.hackathon.candidate.CandidateGridActivity;
import com.hackathon.candidate.CandidateListActivity;
import com.hackathon.election.ElectionListActivity;
import com.hackathon.video.VideoGridActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View btn_doleance;
    private View btn_candidat;
    private View btn_election;
    private View btn_sondage;
    private View btn_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_doleance = findViewById(R.id.btn_doleance);
        btn_candidat = findViewById(R.id.btn_candidat);
        btn_election = findViewById(R.id.btn_election);
        btn_sondage = findViewById(R.id.btn_sondage);
        btn_video = findViewById(R.id.btn_video);

        btn_doleance.setOnClickListener(this);
        btn_candidat.setOnClickListener(this);
        btn_election.setOnClickListener(this);
        btn_sondage.setOnClickListener(this);
        btn_video.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.btn_candidat :
                i = new Intent(this, CandidateGridActivity.class);
                startActivity(i);
                break;
            case R.id.btn_election :
                i = new Intent(this, ElectionListActivity.class);
                startActivity(i);
                break;
            case R.id.btn_doleance :
                i = new Intent(this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.btn_sondage :
                i = new Intent(this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.btn_video :
                i = new Intent(this, VideoGridActivity.class);
                startActivity(i);
                break;
        }
    }
}
