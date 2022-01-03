package com.example.deee_en_deee.infoTypes
import com.example.deee_en_deee.database.ClassEquipmentPrerequisite
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Inventory(
    var equipment: APIReference? = null,
    var quantity: Int? = null,
    var prerequisite: MutableList<ClassEquipmentPrerequisite>? = null,
    @SerialName("equipment_category") var equipmentCategory: APIReference? = null,
    @SerialName("0") var firstPairItem: Inventory? = null,
    @SerialName("1") var secondPairItem: EquipmentOption? = null

)

@Serializable
data class EquipmentOption(
    @SerialName("equipment_option") var equipmentChoice: BroadEquipmentChoice? = null
)

@Serializable
data class BroadEquipmentChoice(
    var choose: Int? = null,
    var type: String? = null,
    var from: EquipmentOptionCategory? = null,
)

@Serializable
data class EquipmentOptionCategory(
    @SerialName("equipment_category") var equipmentCategory: APIReference? = null
)