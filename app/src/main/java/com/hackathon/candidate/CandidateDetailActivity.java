package com.hackathon.candidate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.hackathon.R;

public class CandidateDetailActivity extends AppCompatActivity {
    public static final String TAG = CandidateDetailActivity.class.getSimpleName();

    private TextView firstNameView;
    private TextView lastNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_detail);

        firstNameView = findViewById(R.id.firstNameView);
        lastNameView = findViewById(R.id.lastNameView);

        Bundle b = getIntent().getExtras();
        if(b!=null){
            String name = b.getString("firstName");
            name += " "+b.getString("lastName");
            String title = b.getString("title");
            String content = b.getString("content");

            firstNameView.setText(title);
            lastNameView.setText(name);

            WebView webView = findViewById(R.id.webView);
            webView.loadDataWithBaseURL("", content, "text/html", "utf-8", "");
        }
    }
}
