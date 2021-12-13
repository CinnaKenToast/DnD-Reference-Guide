package com.example.deee_en_deee.infoTypes

import kotlinx.serialization.Serializable

@Serializable
data class ResourceList(
    var count: Int? = null,
    var results: MutableList<APIReference>? = null
)

@Serializable
data class ClassResourceList(
    var results: MutableList<ClassAPIReference>? = null
)