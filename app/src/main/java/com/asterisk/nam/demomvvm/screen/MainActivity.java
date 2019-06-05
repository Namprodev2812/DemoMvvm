package com.asterisk.nam.demomvvm.screen;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asterisk.nam.demomvvm.R;
import com.asterisk.nam.demomvvm.databinding.ActivityMainBinding;
import com.asterisk.nam.demomvvm.model.Track;
import com.asterisk.nam.demomvvm.utils.Constants;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GenreContract.View {

    private static final int LIMIT = 20;
    private static final int OFFSET = 0;
    private GenreViewModel mGenreViewModel;
    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupListGenreView(mActivityMainBinding.recyclerMusic);
        loadGenres(Constants.GENRES_ALL_MUSIC);
    }

    @Override
    public void loadGenresSuccess(List<Track> tracks) {
        GenreAdapter genreAdapter = (GenreAdapter) mActivityMainBinding.recyclerMusic.getAdapter();
        genreAdapter.setGenrelist(tracks);
    }

    @Override
    public void loadGenresFailure(String error) {
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mGenreViewModel.cancel();
    }

    private void initDataBinding() {
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mGenreViewModel = new GenreViewModel();
        mGenreViewModel.setView(this);
        mActivityMainBinding.setDatalist(mGenreViewModel);
    }

    private void setupListGenreView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenreAdapter());
    }

    private void loadGenres(String keyGenre) {
        mGenreViewModel.handleLoadGenres(keyGenre, LIMIT, OFFSET);
    }
}
