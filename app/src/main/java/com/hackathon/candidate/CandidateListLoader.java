package com.hackathon.candidate;

import android.os.AsyncTask;

import java.util.ArrayList;

public class CandidateListLoader extends AsyncTask<Void, Void, ArrayList<Candidate>> {
    public static final String TAG = CandidateListLoader.class.getSimpleName();

    private CandidateListAdapter adapter;

    public CandidateListLoader(CandidateListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<Candidate> doInBackground(Void... voids) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        for(int i=0; i<20; i++){
            Candidate candidate = new Candidate();
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
