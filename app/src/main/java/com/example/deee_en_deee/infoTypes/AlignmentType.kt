package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlignmentType(
    var index: String? = null,
    var name: String? = null,
    var abbrevitation: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var url: String? = null
)