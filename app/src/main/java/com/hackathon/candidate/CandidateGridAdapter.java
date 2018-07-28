package com.hackathon.candidate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.hackathon.election.ElectionGridItemView;
import com.hackathon.result.Result;

import java.util.ArrayList;

public class CandidateGridAdapter extends RecyclerView.Adapter<CandidateGridAdapter.ViewHolder>{
    private ArrayList<Candidate> mDataSet;
    private Context mContext;

    public CandidateGridAdapter(ArrayList<Candidate> mDataSet, Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new View
        CandidateGridItemView view = new  CandidateGridItemView(mContext,null);
        CandidateGridAdapter.ViewHolder viewHolder = new CandidateGridAdapter.ViewHolder(view);
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

        CandidateGridItemView mView;
        public ViewHolder(CandidateGridItemView view){
            super(view);
            mView = view;
        }
    }
}
