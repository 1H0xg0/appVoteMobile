package com.hackathon.candidate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CandidateListAdapter extends RecyclerView.Adapter<CandidateListAdapter.ViewHolder>{
    private ArrayList<Candidate> mDataSet;
    private Context mContext;

    public CandidateListAdapter(ArrayList<Candidate> mDataSet, Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new View
        CandidateListItemView view = new  CandidateListItemView(mContext,null);
        CandidateListAdapter.ViewHolder viewHolder = new CandidateListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            holder.mView.display(mDataSet.get(position));
        }catch (Exception e){
            Log.e("CandidateListAdapter", "onBindViewHolder()", e);
        }
    }

    @Override
    public int getItemCount() {
        if(mDataSet ==null) return 0;
        return mDataSet.size();
    }

    public void swapItems(ArrayList<Candidate> candidates) {
        if(mDataSet==null){
            mDataSet = new ArrayList<>();
        }else{
            mDataSet.clear();
        }
        mDataSet.addAll(candidates);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CandidateListItemView mView;
        public ViewHolder(CandidateListItemView view){
            super(view);
            mView = view;
        }
    }
}
