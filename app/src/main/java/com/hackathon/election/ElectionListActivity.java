package com.hackathon.election;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hackathon.ClickListener;
import com.hackathon.R;
import com.hackathon.RecyclerViewListener;
import com.hackathon.candidate.Candidate;
import com.hackathon.candidate.CandidateListAdapter;
import com.hackathon.candidate.CandidateListLoader;
import com.hackathon.candidate.CandidateViewActivity;

import java.util.ArrayList;

public class ElectionListActivity extends AppCompatActivity implements ClickListener{

    private RecyclerView recyclerView;
    private ArrayList<Election> elections;
    private ElectionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election_list);

        recyclerView = findViewById(R.id.recyclerView);

        // Define a layout for RecyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        elections = new ArrayList<>();
        adapter = new ElectionListAdapter(elections, this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewListener(this, recyclerView, this));

        new ElectionListLoader(adapter).execute();
    }

    @Override
    public void onClick(View view, int position) {
        Election item = elections.get(position);
        Intent i = new Intent(this, ElectionViewActivity.class);
        i.putExtra("title", "Election "+position);
        i.putExtra("subtitle", "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.");
        startActivity(i);
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
