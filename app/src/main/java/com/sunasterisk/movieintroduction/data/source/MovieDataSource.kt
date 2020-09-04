package com.sunasterisk.movieintroduction.data.source

import com.sunasterisk.movieintroduction.data.model.ResponseGenre

interface MovieDataSource {
    interface Remote{
        fun getAllGenres(): List<ResponseGenre>
    }
}
