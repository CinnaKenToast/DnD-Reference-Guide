package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "abilityBonuses")
@Serializable
data class AbilityBonus(
    @SerialName("ability_bonus") var abilityScore: APIReference? = null,
    var bonus: Int? = null
)
