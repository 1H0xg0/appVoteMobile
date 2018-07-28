package com.hackathon.candidate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.hackathon.R;

public class CandidateDetailActivity extends AppCompatActivity {
    public static final String TAG = CandidateDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_detail);

        Bundle b = getIntent().getExtras();
        if(b!=null){
            String title = b.getString("title");
            String content = b.getString("content");

            TextView textView = findViewById(R.id.title);
            textView.setText(title);

            WebView webView = findViewById(R.id.webView);
            webView.loadDataWithBaseURL("", content, "text/html", "utf-8", "");
        }
    }
}
