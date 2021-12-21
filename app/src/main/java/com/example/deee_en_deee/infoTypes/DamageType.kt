package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "damageType")
@Serializable
data class DamageType(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var url: String? = null
)

class DamageTypeConverters {
    @TypeConverter
    fun stringsFromString(string: String?): List<String>? {
        return string?.fromJsonString<List<String>>()
    }

    @TypeConverter
    fun stringsToString(strings: List<String>?): String? {
        return strings?.toJsonString()
    }

}