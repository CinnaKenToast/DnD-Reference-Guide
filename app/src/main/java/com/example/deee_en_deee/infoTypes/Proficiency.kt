package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Proficiency(
    var index: String? = null,
    var type: String? = null,
    var name: String? = null,
    @SerialName("classes") var classTypes: MutableList<APIReference>? = null,
    var races: MutableList<APIReference>? = null,
    var url: String? = null,
    var reference: APIReference? = null,
    var references: MutableList<APIReference>? = null
)
