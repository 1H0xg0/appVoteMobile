package com.hackathon.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.R;

public class HomeButtonView extends LinearLayoutCompat {

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
