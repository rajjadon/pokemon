package com.raj.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raj.datasource.model.RoomDbPokemon

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonDetails: List<RoomDbPokemon>)

    @Delete
    suspend fun delete(pokemonDetails: RoomDbPokemon)

    @Query("SELECT * FROM POKEMON WHERE id = :id")
    suspend fun getPokemonDetailsById(id: String): RoomDbPokemon?

    @Query("SELECT * FROM POKEMON")
    suspend fun getAllPokemonDetails(): List<RoomDbPokemon>

    @Query("DELETE FROM POKEMON")
    suspend fun deleteAll()
}