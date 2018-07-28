package com.hackathon.doleance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackathon.R;

public class DoleanceListItemView extends LinearLayout {
  public static final String TAG = "CandidatListItemView";

  private Doleance item;
  private ImageView imageView;
  private TextView firstNameView;
  private TextView lastNameView;

  public DoleanceListItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_candidate_list, this, true);

    imageView = v.findViewById(R.id.imageView);
    firstNameView = v.findViewById(R.id.firstNameView);
    lastNameView = v.findViewById(R.id.lastNameView);
  }

  public void display(Doleance item) {
        this.item = item;
        if(item==null) return;

        firstNameView.setText(item.getFirstName());
        lastNameView.setText(item.getLastName());
    }
}