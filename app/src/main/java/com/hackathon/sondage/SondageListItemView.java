package com.hackathon.sondage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackathon.R;

public class SondageListItemView extends LinearLayout {
  public static final String TAG = "CandidatListItemView";

  private Sodage item;
  private TextView titleView;
  private TextView descriptionView;

  public SondageListItemView(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View v =  inflater.inflate(R.layout.view_result_list, this, true);

    titleView = v.findViewById(R.id.titleView);
    descriptionView = v.findViewById(R.id.descriptionView);
  }

  public void display(Sodage item) {
        this.item = item;
        if(item==null) return;

      descriptionView.setText(item.getFirstName());
      descriptionView.setText(item.getLastName());
    }
}