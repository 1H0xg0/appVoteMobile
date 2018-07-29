package com.hackathon.video;

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
import com.hackathon.candidate.Candidate;

public class VideoGridItemView extends LinearLayout {
  public static final String TAG = VideoGridItemView.class.getSimpleName();

  private Video item;
  private ImageView imageView;
  private TextView textView1;
  private TextView textView2;

  public VideoGridItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_video_grid, this, true);

    imageView = v.findViewById(R.id.imageView);
    textView1 = v.findViewById(R.id.title);
    textView2 = v.findViewById(R.id.count);

  }

  public void display(Video item) {
        this.item = item;
        if(item==null) return;
        int i = this.item.getId();
        if(i>=0 && i<4){
          Glide.with(getContext())
                  .load(Uri.parse("file:///android_asset/videos/0"+i+".png"))
                  .into(imageView);
        }
        textView1.setText(this.item.getLink());
        textView2.setText("");
    }
}