package com.example.deee_en_deee.infoTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIReference(
    var index: String? = null,
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class ClassAPIReference(
    var index: String? = null,
    @SerialName("class") var classType: String? = null,
    var url: String? = null
)

@Serializable
data class InitialReferences(
    @SerialName("ability-scores") var abilityScore: String = "",
    var alignments: String = "",
    var backgrounds: String = "",
    var classes: String = "",
    var conditions: String = "",
    @SerialName("damage-types") var damageTypes: String = "",
    @SerialName("equipment-categories") var equipmentCategory: String = "",
    var equipment: String = "",
    var feats: String = "",
    var features: String = "",
    var languages: String = "",
    @SerialName("magic-items") var magicItems: String = "",
    @SerialName("magic-schools") var magicSchools: String = "",
    var monsters: String = "",
    var proficiencies: String = "",
    var races: String = "",
    var rules: String = "",
    @SerialName("rule-sections") var ruleSections: String = "",
    var skills: String = "",
    var spells: String = "",
    var subclasses: String = "",
    var subraces: String = "",
    var traits: String = "",
    @SerialName("weapon-properties") var weaponProperties: String = "",
)