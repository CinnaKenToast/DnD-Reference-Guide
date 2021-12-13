package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Race(
    var index: String? = null,
    var name: String? = null,
    var speed: Int? = null,
    @SerialName("ability_bonuses") var abilityBonuses: MutableList<AbilityBonus>? = null,
    var alignment: String? = null,
    var age: String? = null,
    var size: String? = null,
    @SerialName("size_description") var sizeDescription: String? = null,
    @SerialName("starting_proficiencies") var startingProficiencies: MutableList<APIReference>? = null,
    @SerialName("starting_proficiency_options") var startingProficiencyOptions: Choice? = null,
    var languages: MutableList<APIReference>? = null,
    @SerialName("language_desc") var languageDescription: String? = null,
    var traits: MutableList<APIReference>? = null,
    var subraces: MutableList<APIReference>? = null,
    var url: String? = null
)
