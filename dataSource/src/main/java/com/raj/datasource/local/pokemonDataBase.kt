package com.raj.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raj.datasource.model.RoomDbPokemon

@Database(entities = [RoomDbPokemon::class], version = 1, exportSchema = false)
abstract class PokemonDataBase : RoomDatabase() {
    abstract val pokemonDao: PokemonDao
}