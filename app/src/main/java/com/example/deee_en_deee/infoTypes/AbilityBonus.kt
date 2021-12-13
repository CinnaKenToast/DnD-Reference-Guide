package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityBonus(
    @SerialName("ability_bonus") var abilityScore: APIReference? = null,
    var bonus: Int? = null
)
