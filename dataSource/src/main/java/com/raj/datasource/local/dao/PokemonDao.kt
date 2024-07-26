package com.raj.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raj.common.model.PokemonDetails

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonDetails: List<PokemonDetails>)

    @Delete
    suspend fun delete(pokemonDetails: PokemonDetails)

    @Query("SELECT * FROM POKEMON WHERE id = :id")
    suspend fun getPokemonDetailsById(id: String): PokemonDetails?

    @Query("SELECT * FROM POKEMON")
    suspend fun getAllPokemonDetails(): List<PokemonDetails>?

    @Query("DELETE FROM POKEMON")
    suspend fun deleteAll()
}