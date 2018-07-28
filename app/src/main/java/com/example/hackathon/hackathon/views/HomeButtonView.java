package com.example.hackathon.hackathon.views;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hackathon.hackathon.R;


public class HomeButtonView extends LinearLayout {

    private ImageView imageView;
    private TextView textView;

    public HomeButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MenuItemView, 0, 0);
        String titleText = a.getString(R.styleable.MenuItemView_titleText);
        Drawable srcImage = a.getDrawable(R.styleable.MenuItemView_srcImage);
        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =  inflater.inflate(R.layout.home_button_view, this, true);

        imageView = v.findViewById(R.id.imageView);
        textView = v.findViewById(R.id.textView);

        imageView.setImageDrawable(srcImage);
        textView.setText(titleText);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
