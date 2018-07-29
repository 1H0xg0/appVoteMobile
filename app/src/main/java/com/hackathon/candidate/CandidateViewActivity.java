package com.hackathon.candidate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackathon.R;

public class CandidateViewActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = CandidateViewActivity.class.getSimpleName();

    private TextView firstNameView;
    private TextView lastNameView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_view);

        firstNameView = findViewById(R.id.firstNameView);
        lastNameView = findViewById(R.id.lastNameView);
        imageView = findViewById(R.id.imageView);

        Bundle b = getIntent().getExtras();
        if(b!=null) {
            int i = b.getInt("id");
            String firstName = b.getString("firstName");
            String lastName = b.getString("lastName");
            firstNameView.setText(firstName);
            lastNameView.setText(lastName);

            Glide.with(this)
                    .load(Uri.parse("file:///android_asset/candidates/"+i+".jpg"))
                    .into(imageView);
        }

        LinearLayout container = findViewById(R.id.container);
        for(int i=0; i<container.getChildCount(); i++){
            View view = container.getChildAt(i);
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CandidateDetailActivity.class);
        String text = "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.";
        switch (v.getId()){
            case R.id.profile:
                intent.putExtra("title", "Profile");
                break;
            case R.id.biographie:
                intent.putExtra("title", "Biographie");
                break;
            case R.id.programme:
                intent.putExtra("title", "Programme");
                break;
            default:
            case R.id.other:
                intent.putExtra("title", "Autre");
                break;
        }
        intent.putExtra("firstName", firstNameView.getText());
        intent.putExtra("lastName", lastNameView.getText());
        intent.putExtra("content", text);
        startActivity(intent);
    }
}
