package com.example.hackathon.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView Vote,Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vote = (CardView) findViewById(R.id.card_vote);
        Result = (CardView) findViewById(R.id.card_result);

        Vote.setOnClickListener(this);
        Result.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.card_vote : {
                i = new Intent(this,menu_principale.class);
                startActivity(i);
            }
            break;
            case R.id.card_result :{
                i = new Intent(this,LoginActivity.class);
                startActivity(i);
            }
            break;
        }
    }
}
