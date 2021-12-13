package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityScore(
    var index: String? = null,
    var name: String? = null,
    @SerialName("full_name") var fullName: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var skills: MutableList<APIReference>? = null,
    var url: String? = null
)