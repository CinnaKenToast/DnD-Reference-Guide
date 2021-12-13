package com.example.deee_en_deee.infoTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Spellcasting(
    var level: Int? = null,
    @SerialName("spellcasting_ability") var spellCastingAbility: APIReference? = null,
    var info: MutableList<Info>? = null
)

@Serializable
data class Info(
    var name: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null
)
