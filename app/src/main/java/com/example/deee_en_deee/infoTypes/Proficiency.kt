package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "proficiency")
@Serializable
data class Proficiency(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var type: String? = null,
    var name: String? = null,
    @SerialName("classes") var classTypes: MutableList<APIReference>? = null,
    var races: MutableList<APIReference>? = null,
    var url: String? = null,
    var reference: APIReference? = null,
    var references: MutableList<APIReference>? = null
)
