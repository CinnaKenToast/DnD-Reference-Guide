package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Language(
    var index: String? = null,
    var name: String? = null,
    var type: String? = null,
    @SerialName("typical_speakers") var typicalSpeakers: MutableList<String>? = null,
    var script: String? = null,
    var url: String? = null
)