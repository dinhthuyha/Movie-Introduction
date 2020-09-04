package com.sunasterisk.movieintroduction.data.source.remote

import com.sunasterisk.movieintroduction.BuildConfig
import com.sunasterisk.movieintroduction.data.model.ResponseGenre
import com.sunasterisk.movieintroduction.data.source.MovieDataSource

class MovieRemoteDataSource() : MovieDataSource.Remote {
    var key: String = BuildConfig.API_KEY
    override fun getAllGenres(): List<ResponseGenre> {
        return HomeTask()
            .execute("https://api.themoviedb.org/3/genre/movie/list?api_key=$key&language=en-US").get()

    }

    companion object {
        private var INSTANCE: MovieRemoteDataSource? = null
        fun getInstance() = INSTANCE ?: synchronized(this) {
            INSTANCE ?: MovieRemoteDataSource
        }
    }
}

