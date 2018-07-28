package com.hackathon.candidate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hackathon.R;
import com.hackathon.result.Result;

public class CandidateGridItemView extends LinearLayout {
  public static final String TAG = CandidateGridItemView.class.getSimpleName();

  private Candidate item;

  public CandidateGridItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_candidate_grid, this, true);

  }

  public void display(Candidate item) {
        this.item = item;
        if(item==null) return;
    }
}