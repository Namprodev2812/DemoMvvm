package com.asterisk.nam.demomvvm.screen;

import android.support.annotation.StringDef;

@StringDef({
        GenreEntity.KIND_TREND,
        GenreEntity.GENRES_ALL_MUSIC,
})
public @interface GenreEntity {
    String KIND_TREND = "trending";
    String GENRES_ALL_MUSIC = "soundcloud:genres:all-music";
}