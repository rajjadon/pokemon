package com.raj.datasource.remote.network.model

import com.raj.common.model.PokemonAbility
import com.raj.common.model.PokemonAttack
import com.raj.common.model.PokemonDetails
import com.raj.common.model.PokemonImage
import com.raj.common.model.PokemonResistance
import com.raj.common.model.PokemonWeakness

data class PokemonApiData(
    val abilities: List<Ability>? = null,
    val artist: String? = null,
    val attacks: List<Attack>? = null,
    val cardmarket: Cardmarket? = null,
    val convertedRetreatCost: Int? = null,
    val evolvesFrom: String? = null,
    val evolvesTo: List<String>? = null,
    val flavorText: String? = null,
    val hp: String? = null,
    val id: String,
    val images: Images? = null,
    val legalities: Legalities? = null,
    val level: String? = null,
    val name: String? = null,
    val nationalPokedexNumbers: List<Int>? = null,
    val number: String? = null,
    val rarity: String? = null,
    val regulationMark: String? = null,
    val resistances: List<Resistance>? = null,
    val retreatCost: List<String>? = null,
    val rules: List<String>? = null,
    val `set`: Set? = null,
    val subtypes: List<String>? = null,
    val supertype: String? = null,
    val tcgplayer: Tcgplayer? = null,
    val types: List<String>? = null,
    val weaknesses: List<Weaknesse>? = null
){
    fun mapPokemonApiDataToPokemonDetails(): PokemonDetails {
        return PokemonDetails(
            id = this.id,
            name = this.name,
            type = this.types,
            subType = this.subtypes,
            level = this.level,
            hp = this.hp,
            image = this.images.let { PokemonImage(it?.small, it?.large) },
            attack = this.attacks?.map { attack ->
                PokemonAttack(
                    convertedEnergyCost = attack.convertedEnergyCost,
                    name = attack.name,
                    damage = attack.damage,
                    text = attack.text,
                    cost = attack.cost
                )
            },
            weakness = this.weaknesses?.map { weakness ->
                PokemonWeakness(
                    type = weakness.type,
                    value = weakness.value
                )
            },
            ability = this.abilities?.map { ability ->
                PokemonAbility(
                    name = ability.name,
                    text = ability.text,
                    type = ability.type
                )
            },
            resistances = this.resistances?.map { resistance ->
                PokemonResistance(
                    type = resistance.type,
                    value = resistance.value
                )
            }
        )
    }
}

data class Ability(
    val name: String? = null,
    val text: String? = null,
    val type: String? = null
)

data class Attack(
    val convertedEnergyCost: Int? = null,
    val cost: List<String>? = null,
    val damage: String? = null,
    val name: String? = null,
    val text: String? = null
)

data class Cardmarket(
    val prices: Prices? = null,
    val updatedAt: String? = null,
    val url: String? = null
)

data class Images(
    val large: String? = null,
    val small: String? = null
)

data class Legalities(
    val expanded: String? = null,
    val unlimited: String? = null
)

data class Resistance(
    val type: String? = null,
    val value: String? = null
)

data class Set(
    val id: String? = null,
    val images: ImagesX? = null,
    val legalities: Legalities? = null,
    val name: String? = null,
    val printedTotal: Int? = null,
    val ptcgoCode: String? = null,
    val releaseDate: String? = null,
    val series: String? = null,
    val total: Int? = null,
    val updatedAt: String? = null
)

data class Tcgplayer(
    val prices: PricesX? = null,
    val updatedAt: String? = null,
    val url: String? = null
)

data class Weaknesse(
    val type: String? = null,
    val value: String? = null
)

data class Prices(
    val averageSellPrice: Double? = null,
    val avg1: Double? = null,
    val avg30: Double? = null,
    val avg7: Double? = null,
    val germanProLow: Int? = null,
    val lowPrice: Double? = null,
    val lowPriceExPlus: Double? = null,
    val reverseHoloAvg1: Double? = null,
    val reverseHoloAvg30: Double? = null,
    val reverseHoloAvg7: Double? = null,
    val reverseHoloLow: Double? = null,
    val reverseHoloSell: Double? = null,
    val reverseHoloTrend: Double? = null,
    val suggestedPrice: Int? = null,
    val trendPrice: Double? = null
)

data class ImagesX(
    val logo: String? = null,
    val symbol: String? = null
)

data class PricesX(
    val `1stEditionHolofoil`: StEditionHolofoil? = null,
    val holofoil: Holofoil? = null,
    val normal: Normal? = null,
    val reverseHolofoil: ReverseHolofoil? = null,
    val unlimitedHolofoil: UnlimitedHolofoil? = null
)

data class StEditionHolofoil(
    val directLow: Double? = null,
    val high: Double? = null,
    val low: Double? = null,
    val market: Double? = null,
    val mid: Double? = null
)

data class Holofoil(
    val directLow: Double? = null,
    val high: Double? = null,
    val low: Double? = null,
    val market: Double? = null,
    val mid: Double? = null
)

data class Normal(
    val directLow: Double? = null,
    val high: Double? = null,
    val low: Double? = null,
    val market: Double? = null,
    val mid: Double? = null
)

data class ReverseHolofoil(
    val directLow: Double? = null,
    val high: Double? = null,
    val low: Double? = null,
    val market: Double? = null,
    val mid: Double? = null
)

data class UnlimitedHolofoil(
    val directLow: Double? = null,
    val high: Double? = null,
    val low: Double? = null,
    val market: Double? = null,
    val mid: Double? = null
)