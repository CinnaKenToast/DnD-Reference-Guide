package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "ruleSection")
@Serializable
data class RuleSection(
    @PrimaryKey(autoGenerate = false)
    var name: String,
    var index: String? = null,
    @SerialName("desc") var description: String? = null,
    var url: String? = null
)
