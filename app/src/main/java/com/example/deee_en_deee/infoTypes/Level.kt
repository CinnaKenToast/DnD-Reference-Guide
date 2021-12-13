package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Level(
    var index: String? = null,
    var level: Int? = null,
    @SerialName("ability_score_bonuses") var abilityScoreBonus: Int? = null,
    @SerialName("prof_bonus") var proficiencyBonus: Int? = null,
    var features: MutableList<APIReference>? = null,
    var spellcasting: KnownSpells? = null,
    @SerialName("class_specific") var classSpecific: ClassSpecific? = null,
    @SerialName("class")var classType: APIReference? = null,
    var url: String? = null
)

@Serializable
data class KnownSpells(
    var cantripsKnown: Int? = null,
    var spellSlotsLevel1: Int? = null,
    var spellSlotsLevel2: Int? = null,
    var spellSlotsLevel3: Int? = null,
    var spellSlotsLevel4: Int? = null,
    var spellSlotsLevel5: Int? = null,
    var spellSlotsLevel6: Int? = null,
    var spellSlotsLevel7: Int? = null,
    var spellSlotsLevel8: Int? = null,
    var spellSlotsLevel9: Int? = null
)

@Serializable
data class ClassSpecific(
    var die1: Int? = null,
    var die2: Int? = null,
    var die3: Int? = null,
    var die4: Int? = null,
    var die5: Int? = null,
)
