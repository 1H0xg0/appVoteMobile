package com.hackathon.election;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackathon.R;
import com.hackathon.candidate.Candidate;

public class ElectionListItemView extends LinearLayout {
  public static final String TAG = "CandidatListItemView";

  private Election item;
  private TextView descriptionView;
  private TextView titleView;

  public ElectionListItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_election_list, this, true);

      titleView = v.findViewById(R.id.titleView);
      descriptionView = v.findViewById(R.id.descriptionView);
  }

  public void display(Election item) {
        this.item = item;
        if(item==null) return;

      titleView.setText(item.getTitle());
        descriptionView.setText(item.getDate());
    }
}