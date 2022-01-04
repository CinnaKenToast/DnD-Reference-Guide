package com.example.deee_en_deee.infoTypes
import com.example.deee_en_deee.database.ClassEquipmentPrerequisite
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Inventory(
    var equipment: APIReference? = null,
    var quantity: Int? = null,
    var prerequisites: MutableList<ClassEquipmentPrerequisite>? = null,
    @SerialName("equipment_category") var equipmentCategory: APIReference? = null,
    @SerialName("equipment_option") var equipmentChoice: BroadEquipmentChoice? = null,
    @SerialName("0") var firstPairItem: ItemQuantity? = null,
    @SerialName("1") var secondPairItem: EquipmentOption? = null

)

@Serializable
data class ItemQuantity(
    var equipment: APIReference? = null,
    var quantity: Int? = null
)

@Serializable
data class EquipmentOption(
    @SerialName("equipment_option") var equipmentChoice: BroadEquipmentChoice? = null,
    var equipment: APIReference? = null,
    var quantity: Int? = null
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