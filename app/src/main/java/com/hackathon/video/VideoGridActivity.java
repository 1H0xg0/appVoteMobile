package com.hackathon.video;

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
import com.hackathon.candidate.CandidateViewActivity;
import com.hackathon.election.GridSpacingItemDecoration;

import java.util.ArrayList;

public class VideoGridActivity extends AppCompatActivity implements ClickListener {
    private ArrayList<Video> videos;
    private VideoGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_grid);

        TextView textView1 = findViewById(R.id.title);
        TextView textView2 = findViewById(R.id.subtitle);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        videos = new ArrayList<>();
        adapter = new VideoGridAdapter(videos, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewListener(this, recyclerView, this));

        new VideoGridLoader(adapter).execute();
    }

    @Override
    public void onClick(View view, int position) {
        Video item = videos.get(position);
        Intent i = new Intent(this, VideoViewActivity.class);
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
