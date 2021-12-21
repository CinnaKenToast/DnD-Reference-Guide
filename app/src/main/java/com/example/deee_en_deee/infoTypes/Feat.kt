package com.example.deee_en_deee.infoTypes

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "feat")
@Serializable
data class Feat(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    var prerequisites: MutableList<FeatPrerequisite>? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var url: String? = null
)

class FeatConverters {
    @TypeConverter
    fun featPrerequisitesFromString(string: String?): List<FeatPrerequisite>? {
        return string?.fromJsonString<List<FeatPrerequisite>>()
    }

    @TypeConverter
    fun featPrerequisitesToString(featPrerequisites: List<FeatPrerequisite>): String? {
        return featPrerequisites?.toJsonString()
    }

    @TypeConverter
    fun stringsFromString(string: String?): List<String>? {
        return string?.fromJsonString<List<String>>()
    }

    @TypeConverter
    fun stringsToString(strings: List<String>?): String? {
        return strings?.toJsonString()
    }
}

@Serializable
data class FeatPrerequisite(
    @SerialName("ability_score") val abilityScore: APIReference? = null,
    @SerialName("minimum_score") val minimumScore: Int? = null
)
