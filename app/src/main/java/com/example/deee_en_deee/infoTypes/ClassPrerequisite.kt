package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.Serializable

@Serializable
data class ClassPrerequisite(
    var classType: ClassType? = null,
    var minimumLevel: Int? = null
)
