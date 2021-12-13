package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MagicSchool(
    var index: String? = null,
    var name: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var url: String? = null
)