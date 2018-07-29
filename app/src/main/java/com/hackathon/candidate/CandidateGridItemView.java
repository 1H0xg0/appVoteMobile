package com.hackathon.candidate;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackathon.R;
import com.hackathon.result.Result;

public class CandidateGridItemView extends LinearLayout {
  public static final String TAG = CandidateGridItemView.class.getSimpleName();

  private Candidate item;
  private ImageView imageView;
  private TextView textView1;
    private TextView textView2;

  public CandidateGridItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_candidate_grid, this, true);
    imageView = v.findViewById(R.id.imageView);
    textView1 = v.findViewById(R.id.title);
    textView2 = v.findViewById(R.id.count);

  }

  public void display(Candidate item) {
        this.item = item;
        if(item==null) return;
        int i = this.item.getId();
        if(i>0 && i<7){
            Glide.with(getContext())
                    .load(Uri.parse("file:///android_asset/candidates/"+i+".jpg"))
                    .into(imageView);
        }
        textView1.setText(this.item.getFirstName());
        textView2.setText(this.item.getLastName());
    }
}