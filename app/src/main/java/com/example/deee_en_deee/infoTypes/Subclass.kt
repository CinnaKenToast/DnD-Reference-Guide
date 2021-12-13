package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subclass(
    var index: String? = null,
    @SerialName("class") var classType: APIReference? = null,
    var name: String? = null,
    @SerialName("subclass_flavor") var subclassFlavor: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var spells: MutableList<APIReference>? = null,
    @SerialName("subclass_levels") var subclassLevels: String? = null,
    var url: String? = null
)
