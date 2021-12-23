package com.example.deee_en_deee.infoTypes

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "Spell")
@Serializable
data class Spell(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    @SerialName("higher_level") var highLevel: MutableList<String>? = null,
    var range: String? = null,
    var components: MutableList<String>? = null,
    var material: String? = null,
    var ritual: Boolean? = null,
    var duration: String? = null,
    var concentration: Boolean? = null,
    @SerialName("casting_time") var castingTime: String? = null,
    var level: Int? = null,
    @SerialName("attack_type") var attackType: String? = null,
    var damage: Damage? = null,
    var school: APIReference? = null,
    @SerialName("classes") var classTypes: MutableList<APIReference>? = null,
    var subclasses: MutableList<APIReference>? = null,
    var url: String? = null
)