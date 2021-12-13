package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentCategory(
    var index: String? = null,
    var name: String? = null,
    var equipment: MutableList<APIReference>? = null,
    var url: String? = null
)