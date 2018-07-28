package com.hackathon.election;

import android.os.AsyncTask;

import com.hackathon.candidate.Candidate;
import com.hackathon.candidate.CandidateListAdapter;

import java.util.ArrayList;

public class ElectionListLoader extends AsyncTask<Void, Void, ArrayList<Election>> {

    private ElectionListAdapter adapter;

    public ElectionListLoader(ElectionListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<Election> doInBackground(Void... voids) {
        ArrayList<Election> elections = new ArrayList<>();
        for(int i=0; i<20; i++){
            Election election = new Election(i, "Title "+i, "Description "+i);
            elections.add(election);
        }
        return elections;
    }

    @Override
    protected void onPostExecute(ArrayList<Election> elections) {
        super.onPostExecute(elections);
        if(adapter!=null){
            adapter.swapItems(elections);
        }
    }
}
