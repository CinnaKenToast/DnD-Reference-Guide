package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Condition(
    var index: String? = null,
    var name: String? = null,
    var description: MutableList<String>? = null,
    var url: String? = null
)