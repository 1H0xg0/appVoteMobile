package com.hackathon.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hackathon.R;
import com.hackathon.candidate.Candidate;

public class VideoGridItemView extends LinearLayout {
  public static final String TAG = VideoGridItemView.class.getSimpleName();

  private Video item;

  public VideoGridItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_video_grid, this, true);

  }

  public void display(Video item) {
        this.item = item;
        if(item==null) return;
    }
}