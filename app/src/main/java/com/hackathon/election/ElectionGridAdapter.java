package com.hackathon.election;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.hackathon.result.Result;

import java.util.ArrayList;

public class ElectionGridAdapter extends RecyclerView.Adapter<ElectionGridAdapter.ViewHolder>{
    private ArrayList<Result> mDataSet;
    private Context mContext;

    public ElectionGridAdapter(ArrayList<Result> mDataSet, Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new View
        ElectionGridItemView view = new  ElectionGridItemView(mContext,null);
        ElectionGridAdapter.ViewHolder viewHolder = new ElectionGridAdapter.ViewHolder(view);
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

    public void swapItems(ArrayList<Result> results) {
        if(mDataSet==null){
            mDataSet = new ArrayList<>();
        }else{
            mDataSet.clear();
        }
        mDataSet.addAll(results);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ElectionGridItemView mView;
        public ViewHolder(ElectionGridItemView view){
            super(view);
            mView = view;
        }
    }
}
