package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rule(
    var name: String? = null,
    var index: String? = null,
    @SerialName("desc") var description: String? = null,
    var subsections: MutableList<APIReference>? = null,
    var url: String? = null
)