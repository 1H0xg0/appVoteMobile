package com.hackathon.doleance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DoleanceListAdapter extends RecyclerView.Adapter<DoleanceListAdapter.ViewHolder>{
    private ArrayList<Doleance> mDataSet;
    private Context mContext;

    public DoleanceListAdapter(ArrayList<Doleance> mDataSet, Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new View
        DoleanceListItemView view = new DoleanceListItemView(mContext,null);
        DoleanceListAdapter.ViewHolder viewHolder = new DoleanceListAdapter.ViewHolder(view);
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

    public void swapItems(ArrayList<Doleance> doleances) {
        if(mDataSet==null){
            mDataSet = new ArrayList<>();
        }else{
            mDataSet.clear();
        }
        mDataSet.addAll(doleances);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        DoleanceListItemView mView;
        public ViewHolder(DoleanceListItemView view){
            super(view);
            mView = view;
        }
    }
}
