package com.hackathon.sondage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SondageListAdapter extends RecyclerView.Adapter<SondageListAdapter.ViewHolder>{
    private ArrayList<Sodage> mDataSet;
    private Context mContext;

    public SondageListAdapter(ArrayList<Sodage> mDataSet, Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new View
        SondageListItemView view = new SondageListItemView(mContext,null);
        SondageListAdapter.ViewHolder viewHolder = new SondageListAdapter.ViewHolder(view);
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

    public void swapItems(ArrayList<Sodage> sodages) {
        if(mDataSet==null){
            mDataSet = new ArrayList<>();
        }else{
            mDataSet.clear();
        }
        mDataSet.addAll(sodages);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SondageListItemView mView;
        public ViewHolder(SondageListItemView view){
            super(view);
            mView = view;
        }
    }
}
