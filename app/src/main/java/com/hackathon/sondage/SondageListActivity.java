package com.hackathon.sondage;

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

public class SondageListActivity extends AppCompatActivity implements ClickListener{

    private RecyclerView recyclerView;
    private ArrayList<Sodage> sodages;
    private SondageListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);

        recyclerView = findViewById(R.id.recyclerView);

        // Define a layout for RecyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        sodages = new ArrayList<>();
        adapter = new SondageListAdapter(sodages, this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewListener(this, recyclerView, this));

        new SondageListLoader(adapter).execute();
    }

    @Override
    public void onClick(View view, int position) {
        Sodage item = sodages.get(position);
        Intent i = new Intent(this, SondageViewActivity.class);
        i.putExtra("id", position);
        startActivity(i);
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
