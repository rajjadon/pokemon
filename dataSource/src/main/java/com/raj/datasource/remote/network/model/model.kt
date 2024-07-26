package com.raj.datasource.remote.network.model

import com.raj.common.model.PokemonAbility
import com.raj.common.model.PokemonAttack
import com.raj.common.model.PokemonDetails
import com.raj.common.model.PokemonImage
import com.raj.common.model.PokemonResistance
import com.raj.common.model.PokemonWeakness

data class PokemonApiData(
    val abilities: List<Ability>,
    val artist: String,
    val attacks: List<Attack>,
    val cardmarket: Cardmarket,
    val convertedRetreatCost: Int,
    val evolvesFrom: String,
    val evolvesTo: List<String>,
    val flavorText: String,
    val hp: String,
    val id: String,
    val images: Images,
    val legalities: Legalities,
    val level: String,
    val name: String,
    val nationalPokedexNumbers: List<Int>,
    val number: String,
    val rarity: String,
    val regulationMark: String,
    val resistances: List<Resistance>,
    val retreatCost: List<String>,
    val rules: List<String>,
    val `set`: Set,
    val subtypes: List<String>,
    val supertype: String,
    val tcgplayer: Tcgplayer,
    val types: List<String>,
    val weaknesses: List<Weaknesse>
){
    fun mapPokemonApiDataToPokemonDetails(): PokemonDetails {
        return PokemonDetails(
            id = this.id,
            name = this.name,
            type = this.types,
            subType = this.subtypes,
            level = this.level,
            hp = this.hp,
            image = this.images.let { PokemonImage(it.small, it.large) },
            attack = this.attacks.map { attack ->
                PokemonAttack(
                    convertedEnergyCost = attack.convertedEnergyCost,
                    name = attack.name,
                    damage = attack.damage,
                    text = attack.text,
                    cost = attack.cost
                )
            },
            weakness = this.weaknesses.map { weakness ->
                PokemonWeakness(
                    type = weakness.type,
                    value = weakness.value
                )
            },
            ability = this.abilities.map { ability ->
                PokemonAbility(
                    name = ability.name,
                    text = ability.text,
                    type = ability.type
                )
            },
            resistances = this.resistances.map { resistance ->
                PokemonResistance(
                    type = resistance.type,
                    value = resistance.value
                )
            }
        )
    }
}

data class Ability(
    val name: String,
    val text: String,
    val type: String
)

data class Attack(
    val convertedEnergyCost: Int,
    val cost: List<String>,
    val damage: String,
    val name: String,
    val text: String
)

data class Cardmarket(
    val prices: Prices,
    val updatedAt: String,
    val url: String
)

data class Images(
    val large: String,
    val small: String
)

data class Legalities(
    val expanded: String,
    val unlimited: String
)

data class Resistance(
    val type: String,
    val value: String
)

data class Set(
    val id: String,
    val images: ImagesX,
    val legalities: Legalities,
    val name: String,
    val printedTotal: Int,
    val ptcgoCode: String,
    val releaseDate: String,
    val series: String,
    val total: Int,
    val updatedAt: String
)

data class Tcgplayer(
    val prices: PricesX,
    val updatedAt: String,
    val url: String
)

data class Weaknesse(
    val type: String,
    val value: String
)

data class Prices(
    val averageSellPrice: Double,
    val avg1: Double,
    val avg30: Double,
    val avg7: Double,
    val germanProLow: Int,
    val lowPrice: Double,
    val lowPriceExPlus: Double,
    val reverseHoloAvg1: Double,
    val reverseHoloAvg30: Double,
    val reverseHoloAvg7: Double,
    val reverseHoloLow: Double,
    val reverseHoloSell: Double,
    val reverseHoloTrend: Double,
    val suggestedPrice: Int,
    val trendPrice: Double
)

data class ImagesX(
    val logo: String,
    val symbol: String
)

data class PricesX(
    val `1stEditionHolofoil`: StEditionHolofoil,
    val holofoil: Holofoil,
    val normal: Normal,
    val reverseHolofoil: ReverseHolofoil,
    val unlimitedHolofoil: UnlimitedHolofoil
)

data class StEditionHolofoil(
    val directLow: Double,
    val high: Double,
    val low: Double,
    val market: Double,
    val mid: Double
)

data class Holofoil(
    val directLow: Double,
    val high: Double,
    val low: Double,
    val market: Double,
    val mid: Double
)

data class Normal(
    val directLow: Double,
    val high: Double,
    val low: Double,
    val market: Double,
    val mid: Double
)

data class ReverseHolofoil(
    val directLow: Double,
    val high: Double,
    val low: Double,
    val market: Double,
    val mid: Double
)

data class UnlimitedHolofoil(
    val directLow: Double,
    val high: Double,
    val low: Double,
    val market: Double,
    val mid: Double
)