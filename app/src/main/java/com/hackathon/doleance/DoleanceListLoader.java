package com.hackathon.doleance;

import android.os.AsyncTask;

import java.util.ArrayList;

public class DoleanceListLoader extends AsyncTask<Void, Void, ArrayList<Doleance>> {

    private DoleanceListAdapter adapter;

    public DoleanceListLoader(DoleanceListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<Doleance> doInBackground(Void... voids) {
        ArrayList<Doleance> doleances = new ArrayList<>();
        for(int i=0; i<20; i++){
            Doleance doleance = new Doleance();
            doleance.setFirstName("Nom "+i);
            doleance.setLastName("Prenom "+i);
            doleances.add(doleance);
        }
        return doleances;
    }

    @Override
    protected void onPostExecute(ArrayList<Doleance> doleances) {
        super.onPostExecute(doleances);
        if(adapter!=null){
            adapter.swapItems(doleances);
        }
    }
}
