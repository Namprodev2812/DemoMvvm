package com.asterisk.nam.demomvvm.screen;

import com.asterisk.nam.demomvvm.model.Collection;
import com.asterisk.nam.demomvvm.model.Genre;
import com.asterisk.nam.demomvvm.model.Track;
import com.asterisk.nam.demomvvm.retrofit.ApiUtils;
import com.asterisk.nam.demomvvm.retrofit.DataClient;
import com.asterisk.nam.demomvvm.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GenreViewModel implements GenreContract.ViewModel {

    private GenreContract.View mView;
    private Disposable mDisposable;

    public void setView(GenreContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleLoadGenres(String keyGenre, int limit, int offset) {
        getData(keyGenre, limit, offset);
    }

    @Override
    public void cancel() {
        mDisposable.dispose();
    }

    private void getData(String keyGenre, int limit, int offset) {
        DataClient dataClient = ApiUtils.getData();
        Observable<Genre> observable = dataClient.register(keyGenre,
                Constants.CLIENT_ID, limit, offset);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(goObserver());
    }

    private Observer<Genre> goObserver() {
        Observer<Genre> observer = new Observer<Genre>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(Genre genres) {
                mView.loadGenresSuccess(changeList(genres.getCollection()));
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
        return observer;
    }

    private List<Track> changeList(List<Collection> collections) {
        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < collections.size(); i++) {
            tracks.add(collections.get(i).getTrack());
        }
        return tracks;
    }
}
