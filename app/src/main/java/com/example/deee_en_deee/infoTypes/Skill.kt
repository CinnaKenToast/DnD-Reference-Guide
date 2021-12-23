package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "skill")
@Serializable
data class Skill(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    @SerialName("ability_score") var abilityScore: APIReference? = null,
    var url: String? = null
)