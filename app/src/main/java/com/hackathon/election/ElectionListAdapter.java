package com.hackathon.election;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.hackathon.candidate.Candidate;
import com.hackathon.candidate.CandidateListItemView;

import java.util.ArrayList;

public class ElectionListAdapter extends RecyclerView.Adapter<ElectionListAdapter.ViewHolder>{
    private ArrayList<Election> mDataSet;
    private Context mContext;

    public ElectionListAdapter(ArrayList<Election> mDataSet, Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new View
        ElectionListItemView view = new  ElectionListItemView(mContext,null);
        ElectionListAdapter.ViewHolder viewHolder = new ElectionListAdapter.ViewHolder(view);
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

    public void swapItems(ArrayList<Election> elections) {
        if(mDataSet==null){
            mDataSet = new ArrayList<>();
        }else{
            mDataSet.clear();
        }
        mDataSet.addAll(elections);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ElectionListItemView mView;
        public ViewHolder(ElectionListItemView view){
            super(view);
            mView = view;
        }
    }
}
