package com.raj.common.model

data class PokemonDetails(
    val id : String? = null,
    val name : String? = null,
    val type : List<String>? = null,
    val subType : List<String>? = null,
    val level : String? = null,
    val hp : String? = null,
    val image : PokemonImage? = null,
    val attack : List<PokemonAttack>? = null,
    val weakness : List<PokemonWeakness>? = null,
    val ability : List<PokemonAbility>? = null,
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