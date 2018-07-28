package com.hackathon.candidate;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackathon.R;

import java.text.SimpleDateFormat;

public class CandidateListItemView extends LinearLayout {
  public static final String TAG = CandidateListItemView.class.getSimpleName();

  private Candidate item;
  private ImageView imageView;
  private TextView firstNameView;
  private TextView lastNameView;

  public CandidateListItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_candidate_list, this, true);

    imageView = v.findViewById(R.id.imageView);
    firstNameView = v.findViewById(R.id.firstNameView);
    lastNameView = v.findViewById(R.id.lastNameView);
  }

  public void display(Candidate item) {
        this.item = item;
        if(item==null) return;

        firstNameView.setText(item.getFirstName());
        lastNameView.setText(item.getLastName());
    }
}