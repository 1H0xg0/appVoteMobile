package com.hackathon;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.hackathon.candidate.CandidateGridActivity;
import com.hackathon.election.ElectionListActivity;
import com.hackathon.video.VideoGridActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View btn_candidat;
    private View btn_election;
    private View btn_video;
    private View btn_file;
    private View btn_list;
    private View btn_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadView();

    }

    private void loadView() {
        setContentView(R.layout.activity_main);

        btn_candidat = findViewById(R.id.btn_candidat);
        btn_video = findViewById(R.id.btn_video);
        btn_file = findViewById(R.id.btn_file);
        btn_election = findViewById(R.id.btn_election);
        btn_list = findViewById(R.id.btn_list);
        btn_setting = findViewById(R.id.btn_setting);

        btn_candidat.setOnClickListener(this);
        btn_video.setOnClickListener(this);
        btn_file.setOnClickListener(this);
        btn_election.setOnClickListener(this);
        btn_list.setOnClickListener(this);
        btn_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.btn_candidat :
                i = new Intent(this, CandidateGridActivity.class);
                startActivity(i);
                break;
            case R.id.btn_election :
                i = new Intent(this, ElectionListActivity.class);
                startActivity(i);
                break;
            case R.id.btn_video :
                i = new Intent(this, VideoGridActivity.class);
                startActivity(i);
                break;
            case R.id.btn_file :
            case R.id.btn_list :
                Toast.makeText(this, "En cours de developpement", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_setting :
                showDialogBox();
                break;
        }
    }

    private void showDialogBox() {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.btn_parametre))
            .setMessage("Are you sure you want to delete this entry?")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // continue with delete
                    setLocale("mg");
                }
            })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        onConfigurationChanged(conf);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        loadView();
    }
}
