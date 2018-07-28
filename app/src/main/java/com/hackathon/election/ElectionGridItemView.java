package com.hackathon.election;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackathon.R;
import com.hackathon.result.Result;

public class ElectionGridItemView extends LinearLayout {
  public static final String TAG = ElectionGridItemView.class.getSimpleName();

  private Result item;

  public ElectionGridItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_election_grid, this, true);

  }

  public void display(Result item) {
        this.item = item;
        if(item==null) return;
    }
}