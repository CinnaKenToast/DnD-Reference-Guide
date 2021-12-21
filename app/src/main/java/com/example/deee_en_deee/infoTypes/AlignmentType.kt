package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "alignmentType")
@Serializable
data class AlignmentType(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    var abbrevitation: String? = null,
    @SerialName("desc") var description: String? = null,
    var url: String? = null
)