package com.hackathon.doleance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hackathon.ClickListener;
import com.hackathon.R;
import com.hackathon.RecyclerViewListener;

import java.util.ArrayList;

public class DoleanceListActivity extends AppCompatActivity implements ClickListener{

    private RecyclerView recyclerView;
    private ArrayList<Doleance> doleances;
    private DoleanceListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_list);

        recyclerView = findViewById(R.id.recyclerView);

        // Define a layout for RecyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        doleances = new ArrayList<>();
        adapter = new DoleanceListAdapter(doleances, this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewListener(this, recyclerView, this));

        new DoleanceListLoader(adapter).execute();
    }

    @Override
    public void onClick(View view, int position) {
        Doleance item = doleances.get(position);
        Intent i = new Intent(this, DoleanceViewActivity.class);
        i.putExtra("id", position);
        startActivity(i);
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
