package com.sunasterisk.movieintroduction.data.model

data class ResponseDetailGenre(
    var posterPath: String,
    var id: String,
    var title: String,
    var genreId: List<Int>,
    var voteAverage: Int,
    var releaseDate: String
)
