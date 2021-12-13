package com.example.deee_en_deee.infoTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreathWeapon(
    var name: String? = null,
    @SerialName("desc") var description: String? = null,
    var usage: Usage? = null,
    var dc: DifficultyClass? = null,
    var damage: Damage? = null,
    var url: String? = null
)

@Serializable
data class Usage(
    var type: String? = null,
    var dice: String? = null,
    @SerialName("min_value") var minValue: Int? = null,
    var times: Int? = null
)

@Serializable
data class DifficultyClass(
    @SerialName("dc_type") var dcType: AbilityScore? = null,
    @SerialName("dc_value") var dcValue: Int? = null,
    @SerialName("success_type") var successType: String? = null
)