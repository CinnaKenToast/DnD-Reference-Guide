package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString
import kotlinx.serialization.Serializable


@Entity(tableName = "equipmentCategory")
@Serializable
data class EquipmentCategory(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    var equipment: MutableList<APIReference>? = null,
    var url: String? = null
)