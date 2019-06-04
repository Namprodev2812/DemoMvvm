package com.asterisk.nam.demomvvm.screen;

import com.asterisk.nam.demomvvm.model.Track;

import java.util.List;

public interface GenreContract {

    interface View {
        void loadGenresSuccess(List<Track> tracks);

        void loadGenresFailure(String error);
    }

    interface ViewModel {
        void handleLoadGenres(String keyGenre, int limit, int offset);

        void cancel();
    }
}
