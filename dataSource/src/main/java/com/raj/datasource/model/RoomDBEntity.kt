package com.raj.datasource.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val ENTITY_NAME = "TRENDING_DOMAIN_TABLE"

@Entity(tableName = ENTITY_NAME)
data class RoomDbTrendingDomain(
    @PrimaryKey @ColumnInfo(name = "movie_id") val id: Int = 0,
    @ColumnInfo(name = "adult") val adult: Boolean = false,
    @ColumnInfo(name = "backdropPath") val backdropPath: String = "",
    @ColumnInfo(name = "firstAirDate") val firstAirDate: String = "",
    @ColumnInfo(name = "genreIds") val genreIds: String = "",
    @ColumnInfo(name = "mediaType") val mediaType: String = "",
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "originCountry") val originCountry: String = "",
    @ColumnInfo(name = "originalLanguage") val originalLanguage: String = "",
    @ColumnInfo(name = "originalName") val originalName: String = "",
    @ColumnInfo(name = "originalTitle") val originalTitle: String = "",
    @ColumnInfo(name = "overview") val overview: String = "",
    @ColumnInfo(name = "popularity") val popularity: Double = 0.0,
    @ColumnInfo(name = "posterPath") val posterPath: String = "",
    @ColumnInfo(name = "releaseDate") val releaseDate: String = "",
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "video") val video: Boolean = false,
    @ColumnInfo(name = "voteAverage") val voteAverage: Double = 0.0,
    @ColumnInfo(name = "voteCount") val voteCount: Int = 0,
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean = false
)