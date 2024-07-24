package com.raj.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.raj.datasource.model.RoomDbPokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert(onConflict = IGNORE)
    suspend fun insert(roomDbPokemon: RoomDbPokemon)

    @Query("DELETE FROM POKEMON_TABLE")
    suspend fun deleteAll()

    @Query("DELETE FROM POKEMON_TABLE WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM POKEMON_TABLE")
    fun getAllPokemon(): Flow<List<RoomDbPokemon>>

    @Update(onConflict = REPLACE)
    suspend fun update(roomDbPokemon: RoomDbPokemon)
}