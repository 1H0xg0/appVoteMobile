package com.hackathon.candidate;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.hackathon.R;
import com.hackathon.result.Result;

public class CandidateGridItemView extends LinearLayout {
  public static final String TAG = CandidateGridItemView.class.getSimpleName();

  private Candidate item;
  private ImageView imageView;

  public CandidateGridItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_candidate_grid, this, true);
    imageView = v.findViewById(R.id.imageView);

  }

  public void display(Candidate item) {
        this.item = item;
        if(item==null) return;
        int i = this.item.getId();
        if(i>0 && i<7){
            Glide.with(getContext())
                    .load(Uri.parse("file:///android_asset/candiates/"+i+".jpg"))
                    .into(imageView);
        }
    }
}