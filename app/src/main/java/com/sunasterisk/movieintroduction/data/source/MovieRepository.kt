package com.sunasterisk.movieintroduction.data.source

import com.sunasterisk.movieintroduction.data.model.ResponseGenre


class MovieRepository private constructor(
    private var remoteGenre: MovieDataSource.Remote
): MovieDataSource.Remote{
    override fun getAllGenres(): List<ResponseGenre> =
        remoteGenre.getAllGenres()

    companion object{
        private var INSTANCE: MovieRepository? = null
        fun getInstance(remoteDataSource: MovieDataSource.Remote) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MovieRepository(remoteDataSource)
            }.also { INSTANCE=it }
    }
}
