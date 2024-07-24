package com.raj.datasource.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val ENTITY_NAME = "POKEMON_TABLE"

@Entity(tableName = ENTITY_NAME)
data class RoomDbPokemon(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "image") val image: String = "",
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "type") val type: String = "",
    @ColumnInfo(name = "subType") val subType: String = "",
    @ColumnInfo(name = "level") val level: String = "",
    @ColumnInfo(name = "hp") val hp: String = "",
    @ColumnInfo(name = "attack") val attack: String = "",
    @ColumnInfo(name = "weakness") val weakness: String = "",
    @ColumnInfo(name = "ability") val ability: String = "",
    @ColumnInfo(name = "resistance") val resistance: String = "",
)