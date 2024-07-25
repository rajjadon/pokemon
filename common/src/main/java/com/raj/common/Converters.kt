package com.raj.common

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raj.common.model.PokemonAbility
import com.raj.common.model.PokemonAttack
import com.raj.common.model.PokemonImage
import com.raj.common.model.PokemonResistance
import com.raj.common.model.PokemonWeakness

class Converters {

    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromPokemonImage(value: PokemonImage?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPokemonImage(value: String?): PokemonImage? {
        return Gson().fromJson(value, PokemonImage::class.java)
    }

    @TypeConverter
    fun fromPokemonAttackList(value: List<PokemonAttack>?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPokemonAttackList(value: String?): List<PokemonAttack>? {
        val listType = object : TypeToken<List<PokemonAttack>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromPokemonWeaknessList(value: List<PokemonWeakness>?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPokemonWeaknessList(value: String?): List<PokemonWeakness>? {
        val listType = object : TypeToken<List<PokemonWeakness>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromPokemonAbilityList(value: List<PokemonAbility>?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPokemonAbilityList(value: String?): List<PokemonAbility>? {
        val listType = object : TypeToken<List<PokemonAbility>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromPokemonResistanceList(value: List<PokemonResistance>?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPokemonResistanceList(value: String?): List<PokemonResistance>? {
        val listType = object : TypeToken<List<PokemonResistance>>() {}.type
        return Gson().fromJson(value, listType)
    }
}