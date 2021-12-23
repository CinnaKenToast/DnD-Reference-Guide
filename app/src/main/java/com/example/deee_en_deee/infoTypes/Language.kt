package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "language")
@Serializable
data class Language(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    var type: String? = null,
    @SerialName("typical_speakers") var typicalSpeakers: MutableList<String>? = null,
    var script: String? = null,
    var url: String? = null
)