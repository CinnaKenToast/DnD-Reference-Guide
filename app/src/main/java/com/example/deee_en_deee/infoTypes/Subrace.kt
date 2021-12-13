package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subrace(
    var index: String? = null,
    var name: String? = null,
    var race: APIReference? = null,
    @SerialName("desc") var description: String? = null,
    @SerialName("ability_bonuses") var abilityBonuses: MutableList<AbilityBonus>? = null,
    @SerialName("starting_proficiencies") var startingProficiencies: MutableList<APIReference>? = null,
    var languages: MutableList<APIReference>? = null,
    @SerialName("language_options") var languageOptions: Choice? = null,
    @SerialName("racial_traits") var racialOptions: MutableList<APIReference>? = null,
    var url: String? = null
)
