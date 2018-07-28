package com.hackathon.election;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.hackathon.ClickListener;
import com.hackathon.R;
import com.hackathon.RecyclerViewListener;
import com.hackathon.candidate.Candidate;
import com.hackathon.candidate.CandidateListAdapter;
import com.hackathon.candidate.CandidateViewActivity;
import com.hackathon.result.Result;

import java.util.ArrayList;

public class ElectionViewActivity extends AppCompatActivity implements ClickListener {
    private ArrayList<Result> results;
    private ElectionGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election_view);

        TextView textView1 = findViewById(R.id.title);
        TextView textView2 = findViewById(R.id.subtitle);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Bundle b = getIntent().getExtras();
        if(b!=null){
            String title = b.getString("title");
            String subtitle = b.getString("subtitle");

            textView1.setText(title);
            textView2.setText(subtitle);
        }

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        results = new ArrayList<>();
        adapter = new ElectionGridAdapter(results, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewListener(this, recyclerView, this));

        new ElectionGridLoader(adapter).execute();
    }

    @Override
    public void onClick(View view, int position) {
        Candidate item = results.get(position).getCandidate();
        Intent i = new Intent(this, CandidateViewActivity.class);
        i.putExtra("id", position);
        startActivity(i);
    }

    @Override
    public void onLongClick(View view, int position) {

    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
