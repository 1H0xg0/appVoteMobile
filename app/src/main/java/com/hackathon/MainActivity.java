package com.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.hackathon.candidate.CandidateListActivity;
import com.hackathon.election.ElectionListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View btn_result;
    private View btn_candidat;
    private View btn_election;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_result = findViewById(R.id.btn_result);
        btn_candidat = findViewById(R.id.btn_candidat);
        btn_election = findViewById(R.id.btn_election);

        btn_result.setOnClickListener(this);
        btn_candidat.setOnClickListener(this);
        btn_election.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.btn_result :{
                i = new Intent(this, LoginActivity.class);
                startActivity(i);
            }
            case R.id.btn_candidat :{
                i = new Intent(this, CandidateListActivity.class);
                startActivity(i);
            }
            case R.id.btn_election :{
                i = new Intent(this, ElectionListActivity.class);
                startActivity(i);
            }
            break;
        }
    }
}
