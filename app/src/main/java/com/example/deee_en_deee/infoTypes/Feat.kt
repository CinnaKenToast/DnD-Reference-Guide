package com.example.deee_en_deee.infoTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feat(
    var index: String? = null,
    var name: String? = null,
    var prerequisites: MutableList<APIReference>? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var url: String? = null
)
