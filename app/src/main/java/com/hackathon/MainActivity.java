package com.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.hackathon.candidate.CandidateListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View btn_vote;
    private View btn_result;
    private View btn_candidat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_vote = findViewById(R.id.btn_vote);
        btn_result = findViewById(R.id.btn_result);
        btn_candidat = findViewById(R.id.btn_candidat);

        btn_vote.setOnClickListener(this);
        btn_result.setOnClickListener(this);
        btn_candidat.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.btn_vote : {
                i = new Intent(this, menu_principale.class);
                startActivity(i);
            }
            break;
            case R.id.btn_result :{
                i = new Intent(this, LoginActivity.class);
                startActivity(i);
            }
            case R.id.btn_candidat :{
                i = new Intent(this, CandidateListActivity.class);
                startActivity(i);
            }
            break;
        }
    }
}
