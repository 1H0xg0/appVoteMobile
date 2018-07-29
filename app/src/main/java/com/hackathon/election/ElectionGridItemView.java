package com.hackathon.election;

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

public class ElectionGridItemView extends LinearLayout {
  public static final String TAG = ElectionGridItemView.class.getSimpleName();

  private Result item;
  private ImageView imageView;
  private TextView textView1;
  private TextView textView2;

  public ElectionGridItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_election_grid, this, true);
    imageView = v.findViewById(R.id.imageView);
    textView1 = v.findViewById(R.id.title);
    textView2 = v.findViewById(R.id.count);

  }

  public void display(Result item) {
        this.item = item;
        if(item==null) return;
        int i = this.item.getCandidate().getId();
        if(i>0 && i<7){
              Glide.with(getContext())
                  .load(Uri.parse("file:///android_asset/candidates/"+i+".jpg"))
                  .into(imageView);
        }
        textView1.setText(this.item.getCandidate().getFirstName()+" "+this.item.getCandidate().getLastName());
        textView2.setText(this.item.getVote()+" votes");
  }
}