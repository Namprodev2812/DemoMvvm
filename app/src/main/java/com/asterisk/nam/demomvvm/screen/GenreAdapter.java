package com.asterisk.nam.demomvvm.screen;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.asterisk.nam.demomvvm.R;
import com.asterisk.nam.demomvvm.databinding.GenreItemListBinding;
import com.asterisk.nam.demomvvm.model.Track;

import java.util.ArrayList;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.MyViewHolder> {

    private List<Track> mtracks;

    public GenreAdapter() {
        mtracks = new ArrayList<>();
    }

    @NonNull
    @Override
    public GenreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        GenreItemListBinding genreItemListBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.genre_item_list, viewGroup, false);
        return new MyViewHolder(genreItemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAdapter.MyViewHolder viewHolder, int i) {
        viewHolder.bindData(mtracks.get(i));
    }

    @Override
    public int getItemCount() {
        return mtracks == null ? 0 : mtracks.size();
    }

    public void setGenrelist(List<Track> tracks) {
        mtracks.clear();
        this.mtracks.addAll(tracks);
        notifyDataSetChanged();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private GenreItemListBinding mGenreItemListBinding;

        public MyViewHolder(GenreItemListBinding genreItemListBinding) {
            super(genreItemListBinding.getRoot());
            this.mGenreItemListBinding = genreItemListBinding;
        }

        public void bindData(Track track) {
            mGenreItemListBinding.setDatatrack(track);
            mGenreItemListBinding.setDatauser(track.getUser());
        }
    }
}
