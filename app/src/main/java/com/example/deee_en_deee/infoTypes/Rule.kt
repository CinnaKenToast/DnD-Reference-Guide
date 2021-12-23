package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "rule")
@Serializable
data class Rule(
    @PrimaryKey(autoGenerate = false)
    var name: String,
    var index: String? = null,
    @SerialName("desc") var description: String? = null,
    var subsections: MutableList<APIReference>? = null,
    var url: String? = null
)