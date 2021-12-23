package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "magicItem")
@Serializable
data class MagicItem(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    @SerialName("equipment_category") var equipmentCategory: APIReference? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var url: String? = null
)