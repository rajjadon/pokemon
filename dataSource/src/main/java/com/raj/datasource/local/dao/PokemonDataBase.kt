package com.raj.datasource.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.raj.common.Converters
import com.raj.common.model.PokemonDetails

@Database(entities = [PokemonDetails::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PokemonDataBase : RoomDatabase() {
    abstract val pokemonDao: PokemonDao
}