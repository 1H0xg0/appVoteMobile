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
        String[] names = new String[]{
                "RABEMANANA",
                "RAKOTONDRAFARA",
                "RAFANOMEZANA",
                "RANDRIANASOLO",
                "RAZAFINDRABEAINA",
                "RASOANDRAINY",
        };
        String[] lasts = new String[]{
                "Laurent",
                "Mathieu",
                "Adrien",
                "Andry",
                "Haja",
                "Tiana",
        };
        for(int i=1; i<7; i++){
            Candidate candidate = new Candidate();
            candidate.setId(i);
            candidate.setFirstName(names[i-1]);
            candidate.setLastName(lasts[i-1]);

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
