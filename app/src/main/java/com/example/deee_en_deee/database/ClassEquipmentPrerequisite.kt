package com.example.deee_en_deee.database

import com.example.deee_en_deee.infoTypes.APIReference
import kotlinx.serialization.Serializable

@Serializable
data class ClassEquipmentPrerequisite(
    var type: String? = null,
    var proficiency: APIReference? = null
)