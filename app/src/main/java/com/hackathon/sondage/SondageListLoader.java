package com.hackathon.sondage;

import android.os.AsyncTask;

import java.util.ArrayList;

public class SondageListLoader extends AsyncTask<Void, Void, ArrayList<Sodage>> {

    private SondageListAdapter adapter;

    public SondageListLoader(SondageListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<Sodage> doInBackground(Void... voids) {
        ArrayList<Sodage> sodages = new ArrayList<>();
        for(int i=0; i<20; i++){
            Sodage sodage = new Sodage();
            sodage.setFirstName("Nom "+i);
            sodage.setLastName("Prenom "+i);
            sodages.add(sodage);
        }
        return sodages;
    }

    @Override
    protected void onPostExecute(ArrayList<Sodage> sodages) {
        super.onPostExecute(sodages);
        if(adapter!=null){
            adapter.swapItems(sodages);
        }
    }
}
