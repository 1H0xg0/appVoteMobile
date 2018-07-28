package com.hackathon.candidate;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hackathon.R;

public class CandidateListItemView extends LinearLayout {
  public static final String TAG = "CandidatListItemView";

  public CandidateListItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MenuItemView, 0, 0);
    String titleText = a.getString(R.styleable.MenuItemView_titleText);
    Drawable srcImage = a.getDrawable(R.styleable.MenuItemView_srcImage);
    a.recycle();

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_candidate_list, this, true);
  }
}