package com.hackathon.election;

import android.os.AsyncTask;

import com.hackathon.candidate.Candidate;
import com.hackathon.result.Result;

import java.util.ArrayList;

public class ElectionGridLoader extends AsyncTask<Void, Void, ArrayList<Result>> {

    private ElectionGridAdapter adapter;

    public ElectionGridLoader(ElectionGridAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<Result> doInBackground(Void... voids) {
        ArrayList<Result> results = new ArrayList<>();
        //Election election = new Election(1, "Title "+1, "Description "+1, "28 Juillet 2018");
        for(int i=0; i<10; i++){
            Candidate candidate = new Candidate();
            candidate.setLastName("Prenom "+i);
            candidate.setFirstName("Nom "+i);

            Result result = new Result();
            result.setCandidate(candidate);
            result.setVote((int) (Math.random()*100));

            results.add(result);
        }
        return results;
    }

    @Override
    protected void onPostExecute(ArrayList<Result> results) {
        super.onPostExecute(results);
        if(adapter!=null){
            adapter.swapItems(results);
        }
    }
}
