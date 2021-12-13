package com.example.deee_en_deee.infoTypes

import kotlinx.serialization.Serializable

@Serializable
data class Choice(
    var choose: Int? = null,
    var type: String? = null,
    var from: MutableList<APIReference>? = null
)