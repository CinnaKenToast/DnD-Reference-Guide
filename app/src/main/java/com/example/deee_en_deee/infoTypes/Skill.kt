package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skill(
    var index: String? = null,
    var name: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    @SerialName("ability_score") var abilityScore: APIReference? = null,
    var url: String? = null
)