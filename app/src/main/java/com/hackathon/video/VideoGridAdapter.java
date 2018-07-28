package com.hackathon.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.hackathon.candidate.Candidate;

import java.util.ArrayList;

public class VideoGridAdapter extends RecyclerView.Adapter<VideoGridAdapter.ViewHolder>{
    private ArrayList<Video> mDataSet;
    private Context mContext;

    public VideoGridAdapter(ArrayList<Video> mDataSet, Context mContext) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new View
        VideoGridItemView view = new VideoGridItemView(mContext,null);
        VideoGridAdapter.ViewHolder viewHolder = new VideoGridAdapter.ViewHolder(view);
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

    public void swapItems(ArrayList<Video> videos) {
        if(mDataSet==null){
            mDataSet = new ArrayList<>();
        }else{
            mDataSet.clear();
        }
        mDataSet.addAll(videos);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        VideoGridItemView mView;
        public ViewHolder(VideoGridItemView view){
            super(view);
            mView = view;
        }
    }
}
