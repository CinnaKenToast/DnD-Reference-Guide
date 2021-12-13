package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubclassLevel(
    var level: Int? = null,
    var features: MutableList<APIReference>? = null,
    @SerialName("class") var classType: APIReference? = null,
    var subclass: APIReference? = null,
    var url: String? = null,
    var index: String? = null
)
