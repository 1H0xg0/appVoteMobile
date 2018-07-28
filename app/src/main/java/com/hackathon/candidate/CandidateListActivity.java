package com.hackathon.candidate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.hackathon.ClickListener;
import com.hackathon.R;
import com.hackathon.RecyclerViewListener;
import com.hackathon.menu_principale;

import java.util.ArrayList;

public class CandidateListActivity extends AppCompatActivity implements ClickListener{
    public static final String TAG = CandidateListActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private ArrayList<Candidate> candidates;
    private CandidateListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_list);

        recyclerView = findViewById(R.id.recyclerView);

        // Define a layout for RecyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        candidates = new ArrayList<>();
        adapter = new CandidateListAdapter(candidates, this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewListener(this, recyclerView, this));

        new CandidateListLoader(adapter).execute();
    }

    @Override
    public void onClick(View view, int position) {
        Candidate item = candidates.get(position);
        Intent i = new Intent(this, CandidateViewActivity.class);
        i.putExtra("id", position);
        startActivity(i);
        Toast.makeText(this, "POsition "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
