package com.raj.common.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.raj.common.Converters

const val POKEMON = "POKEMON"

@Entity(tableName = POKEMON)
data class PokemonDetails(
    @PrimaryKey
    val id : String,
    val name : String? = null,
    @TypeConverters(Converters::class)
    val type : List<String>? = null,
    @TypeConverters(Converters::class)
    val subType : List<String>? = null,
    val level : String? = null,
    val hp : String? = null,
    @TypeConverters(Converters::class)
    val image : PokemonImage? = null,
    @TypeConverters(Converters::class)
    val attack : List<PokemonAttack>? = null,
    @TypeConverters(Converters::class)
    val weakness : List<PokemonWeakness>? = null,
    @TypeConverters(Converters::class)
    val ability : List<PokemonAbility>? = null,
    @TypeConverters(Converters::class)
    val resistances: List<PokemonResistance>? = null,
)

data class PokemonWeakness(
    val type: String,
    val value: String
)

data class PokemonImage(
    val large: String,
    val small: String
)

data class PokemonAttack(
    val convertedEnergyCost: Int,
    val cost: List<String>,
    val damage: String,
    val name: String,
    val text: String
)

data class PokemonAbility(
    val name: String,
    val text: String,
    val type: String
)

data class PokemonResistance(
    val type: String,
    val value: String
)