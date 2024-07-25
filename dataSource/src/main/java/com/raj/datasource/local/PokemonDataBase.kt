package com.raj.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.raj.common.Converters
import com.raj.datasource.model.RoomDbPokemon

@Database(entities = [RoomDbPokemon::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PokemonDataBase : RoomDatabase() {
    abstract val pokemonDao: PokemonDao
}