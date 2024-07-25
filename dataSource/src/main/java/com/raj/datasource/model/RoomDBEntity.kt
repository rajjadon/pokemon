package com.raj.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.raj.common.Converters
import com.raj.common.model.PokemonAbility
import com.raj.common.model.PokemonAttack
import com.raj.common.model.PokemonImage
import com.raj.common.model.PokemonResistance
import com.raj.common.model.PokemonWeakness

const val POKEMON = "POKEMON"

@Entity(tableName = POKEMON)
data class RoomDbPokemon(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String? = null,
    @TypeConverters(Converters::class) val type: List<String>? = null,
    @TypeConverters(Converters::class) val subType: List<String>? = null,
    val level: String? = null,
    val hp: String? = null,
    @TypeConverters(Converters::class) val image: PokemonImage? = null,
    @TypeConverters(Converters::class) val attack: List<PokemonAttack>? = null,
    @TypeConverters(Converters::class) val weakness: List<PokemonWeakness>? = null,
    @TypeConverters(Converters::class) val ability: List<PokemonAbility>? = null,
    @TypeConverters(Converters::class) val resistances: List<PokemonResistance>? = null,
)