package com.hackathon.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.hackathon.R;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button capturer;
    private Button verifier;

    private static final int RC_HANDLE_CAMERA_PERM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        capturer = (Button) findViewById(R.id.B1);
        verifier = (Button) findViewById(R.id.B2);

        capturer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent I;
        switch (view.getId()){
            case R.id.B1 :{
                I =  new Intent(this,ListCaptureViewActivity.class);
                startActivity(I);
            }
            break;
            case R.id.B2 : {

            }
            break;
        }
    }
}
