package com.example.deee_en_deee.infoTypes

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "monster")
@Serializable
data class Monster(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    var size: String? = null,
    var type: String? = null,
    var subtype: String? = null,
    var alignment: String? = null,
    @SerialName("armor_class") var armorClass: Int? = null,
    @SerialName("hit_points") var hitPoints: Int? = null,
    @SerialName("hit_dice") var hitDice: String? = null,
    var forms: MutableList<APIReference>? = null,
    var speed: Speed? = null,
    var strength: Int? = null,
    var dexterity: Int? = null,
    var constitution: Int? = null,
    var intelligence: Int? = null,
    var wisdom: Int? = null,
    var charisma: Int? = null,
    var proficiencies: MutableList<MonsterProficiency>? = null,
    @SerialName("damage_vulnerabilities") var damageVulnerabilities: MutableList<String>? = null,
    @SerialName("damage_resistances") var damageResistances: MutableList<String>? = null,
    @SerialName("damage_immunities") var damageImmunities: MutableList<String>? = null,
    @SerialName("condition_immunities") var conditionImmunities: MutableList<APIReference>? = null,
    var senses: Senses? = null,
    var languages: String? = null,
    @SerialName("challenge_rating") var challengeRating: Float? = null,
    @SerialName("special_abilities") var specialAbilities: MutableList<SpecialAbility>? = null,
    var actions: MutableList<MonsterAction>? = null,
    @SerialName("legendary_actions") var legendaryActions: MutableList<MonsterAction>? = null,
    var url: String? = null
)

@Serializable
data class Speed(
    var walk: String? = null,
    var swim: String? = null
)

@Serializable
data class MonsterProficiency(
    var value: Int? = null,
    var proficiency: APIReference? = null
)

@Serializable
data class Senses(
    var blindsight: String? = null,
    var tremorsense: String? = null,
    var darkvision: String? = null,
    var truesight: String? = null,
    @SerialName("passive_perception") var passivePerception: Int? = null,
)

@Serializable
data class MonsterAction(
    var name: String? = null,
    @SerialName("desc") var description: String? = null,
    @SerialName("attack_bonus") var attackBonus: Int? = null,
    var dc: DifficultyClass? = null,
    var damage: MutableList<Damage>? = null,
    var usage: Usage? = null,
)

@Serializable
data class SpecialAbility(
        var name: String? = null,
        @SerialName("desc") var description: String? = null,
        var usage: Usage? = null
)