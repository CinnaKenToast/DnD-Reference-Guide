package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "feature")
@Serializable
data class Feature(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    var level: Int? = null,
    @SerialName("class") var classType: APIReference? = null,
    var prerequisites: MutableList<APIReference>? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    @SerialName("feature_specific") var featureSpecific: FeatureSpecific? = null,
    var url: String? = null
)

@Serializable
data class FeatureSpecific(
    @SerialName("subfeature_options") var subfeatureOptions: Choice? = null,
    @SerialName("expertise_options") var expertiseOptions: Choice? = null
)