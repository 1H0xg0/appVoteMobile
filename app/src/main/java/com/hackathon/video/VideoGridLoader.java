package com.hackathon.video;

import android.os.AsyncTask;

import com.hackathon.candidate.Candidate;

import java.util.ArrayList;

public class VideoGridLoader extends AsyncTask<Void, Void, ArrayList<Video>> {

    private VideoGridAdapter adapter;

    public VideoGridLoader(VideoGridAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<Video> doInBackground(Void... voids) {
        String[] args = new String[]{
          "Sensibilisation",
          "Blanchissement d'argents",
          "Financement des parties politiques",
          "Prevention de la violence du code electoral",
        };
        ArrayList<Video> videos = new ArrayList<>();
        for(int i=0; i<4; i++){
            Video video = new Video(i, args[i]);
            videos.add(video);
        }
        return videos;
    }

    @Override
    protected void onPostExecute(ArrayList<Video> videos) {
        super.onPostExecute(videos);
        if(adapter!=null){
            adapter.swapItems(videos);
        }
    }
}
