package com.hackathon.result;

import android.os.AsyncTask;

import java.util.ArrayList;

public class ResultListLoader extends AsyncTask<Void, Void, ArrayList<Result>> {

    private ResultListAdapter adapter;

    public ResultListLoader(ResultListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<Result> doInBackground(Void... voids) {
        ArrayList<Result> results = new ArrayList<>();
        for(int i=0; i<20; i++){
            Result result = new Result();
            result.setFirstName("Nom "+i);
            result.setLastName("Prenom "+i);
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
