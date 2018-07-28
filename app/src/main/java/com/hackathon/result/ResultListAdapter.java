package com.hackathon.result;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.ViewHolder>{
    private ArrayList<Result> mDataSet;
    private Context mContext;

    public ResultListAdapter(ArrayList<Result> mDataSet, Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new View
        ResultListItemView view = new ResultListItemView(mContext,null);
        ResultListAdapter.ViewHolder viewHolder = new ResultListAdapter.ViewHolder(view);
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

        ResultListItemView mView;
        public ViewHolder(ResultListItemView view){
            super(view);
            mView = view;
        }
    }
}
