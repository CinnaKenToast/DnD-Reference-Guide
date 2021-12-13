package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Damage(
    @SerialName("damage_dice") var damageDice: String? = null,
    @SerialName("damage_type") var damageType: APIReference? = null,
    @SerialName("damage_at_slot_level") var damageSlotLevel: DamageAtSlotLevel? = null,
    @SerialName("damage_at_character_level") var damageCharacterLevel: DamageAtCharacterLevel? = null
)

@Serializable
data class DamageAtSlotLevel(
    @SerialName("2") var level2: String? = null,
    @SerialName("3") var level3: String? = null,
    @SerialName("4") var level4: String? = null,
    @SerialName("5") var level5: String? = null,
    @SerialName("6") var level6: String? = null,
    @SerialName("7") var level7: String? = null,
    @SerialName("8") var level8: String? = null,
    @SerialName("9") var level9: String? = null
)

@Serializable
data class DamageAtCharacterLevel(
    @SerialName("1") var level1: String? = null,
    @SerialName("2") var level2: String? = null,
    @SerialName("3") var level3: String? = null,
    @SerialName("4") var level4: String? = null,
    @SerialName("5") var level5: String? = null,
    @SerialName("6") var level6: String? = null,
    @SerialName("7") var level7: String? = null,
    @SerialName("8") var level8: String? = null,
    @SerialName("9") var level9: String? = null,
    @SerialName("10") var level10: String? = null,
    @SerialName("11") var level11: String? = null,
    @SerialName("12") var level12: String? = null,
    @SerialName("13") var level13: String? = null,
    @SerialName("14") var level14: String? = null,
    @SerialName("15") var level15: String? = null,
    @SerialName("16") var level16: String? = null,
    @SerialName("17") var level17: String? = null,
    @SerialName("18") var level18: String? = null,
    @SerialName("19") var level19: String? = null,
    @SerialName("20") var level20: String? = null
)