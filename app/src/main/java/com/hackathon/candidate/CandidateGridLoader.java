package com.hackathon.candidate;

import android.os.AsyncTask;

import com.hackathon.election.ElectionGridAdapter;
import com.hackathon.result.Result;

import java.util.ArrayList;

public class CandidateGridLoader extends AsyncTask<Void, Void, ArrayList<Candidate>> {

    private CandidateGridAdapter adapter;

    public CandidateGridLoader(CandidateGridAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<Candidate> doInBackground(Void... voids) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        for(int i=1; i<7; i++){
            Candidate candidate = new Candidate();
            candidate.setId(i);
            candidate.setFirstName("Nom "+i);
            candidate.setLastName("Prenom "+i);
            candidates.add(candidate);
        }
        return candidates;
    }

    @Override
    protected void onPostExecute(ArrayList<Candidate> candidates) {
        super.onPostExecute(candidates);
        if(adapter!=null){
            adapter.swapItems(candidates);
        }
    }
}
