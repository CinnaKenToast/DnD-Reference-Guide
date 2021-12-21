package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString
import io.ktor.client.call.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "abilityScore")
@Serializable
data class AbilityScore(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    @SerialName("full_name") var fullName: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var skills: MutableList<APIReference>? = null,
    var url: String? = null
)

class AbilityScoreConverters {
    @TypeConverter
    fun descriptionFromString(string: String?): List<String>? {
        return string?.fromJsonString<List<String>>()
    }
    @TypeConverter
    fun descriptionToString(description: List<String>?): String? {
        return description?.toJsonString()
    }

    @TypeConverter
    fun apiReferencesFromString(string: String?): List<APIReference>? {
        return string?.fromJsonString<List<APIReference>>()
    }

    @TypeConverter
    fun apiReferencesToString(apiReferencesToString: MutableList<APIReference>?): String? {
        return apiReferencesToString.toJsonString()
    }
}