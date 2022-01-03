package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Multiclass(
    var prerequisites: MutableList<AbilityPrerequisite>? = null,
    @SerialName("prerequisite_options") var prerequisiteOptions: Choice? = null,
    var proficiencies: MutableList<APIReference>? = null,
    @SerialName("proficiency_choices") var proficiencyChoices: MutableList<Choice>? = null
)

@Serializable
data class AbilityPrerequisite(
    @SerialName("ability_score") var abilityScore: APIReference? = null,
    @SerialName("minimum_score") var minimumScore: Int? = null
)
