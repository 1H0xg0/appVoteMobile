package com.hackathon.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hackathon.R;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button capturer;
    private Button verifier;
    private EditText numcin;

    private static final int RC_HANDLE_CAMERA_PERM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        capturer = (Button) findViewById(R.id.B1);
        verifier = (Button) findViewById(R.id.B2);

        numcin = (EditText) findViewById(R.id.E1);

        capturer.setOnClickListener(this);
        numcin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent I;
        switch (view.getId()){
            case R.id.B1 :{
                I =  new Intent(this,ListCaptureViewActivity.class);
                startActivity(I);
                finish();
            }
            break;
            case R.id.B2 : {
                String fullText = numcin.getText().toString();
                if (fullText.contains("931")) {
                    Toast.makeText(this, "Cet élécteur a déjà voté", Toast.LENGTH_SHORT).show();
                } else {
                    if (fullText.contains("796")) {
                        Toast.makeText(this, "Cet élécteur n'a pas encore voté", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
        }
    }
}
