package com.hackathon.result;

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

public class ResultListActivity extends AppCompatActivity implements ClickListener{

    private RecyclerView recyclerView;
    private ArrayList<Result> results;
    private ResultListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);

        recyclerView = findViewById(R.id.recyclerView);

        // Define a layout for RecyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        results = new ArrayList<>();
        adapter = new ResultListAdapter(results, this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewListener(this, recyclerView, this));

        new ResultListLoader(adapter).execute();
    }

    @Override
    public void onClick(View view, int position) {
        Result item = results.get(position);
        Intent i = new Intent(this, ResultViewActivity.class);
        i.putExtra("id", position);
        startActivity(i);
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
