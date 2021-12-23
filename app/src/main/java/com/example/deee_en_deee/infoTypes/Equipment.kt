package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "equipment")
@Serializable
data class Equipment(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    @SerialName("equipment_category") var equipmentCategory: APIReference? = null,
    @SerialName("weapon_category") var weaponCategory: String? = null,
    @SerialName("weapon_range") var weaponRange: String? = null,
    @SerialName("category_range") var categoryRange: String? = null,
    @SerialName("armor_category") var armorCategory: String? = null,
    @SerialName("armor_class") var armorClass: ArmorClass? = null,
    @SerialName("str_minimum") var strengthMinimum: Int? = null,
    @SerialName("stealth_disadvantage") var stealthDisadvantage: Boolean? = null,
    @SerialName("gear_category") var gearCategory: APIReference? = null,
    var contents: MutableList<Content>? = null,
    var quantity: Int? = null,
    var cost: Cost? = null,
    var damage: Damage? = null,
    var range: Range? = null,
    var weight: Float? = null,
    var properties: MutableList<APIReference>? = null,
    var url: String? = null
)

@Serializable
data class Content(
    var item: APIReference? = null,
    var quantity: Int? = null
)

@Serializable
data class Cost(
    var quantity: Int? = null,
    var unit: String? = null
)

@Serializable
data class Range(
    var normal: Int? = null,
    var long: Int? = null
)

@Serializable
data class ArmorClass(
    var base: Int? = null,
    @SerialName("dex_bonus") var dexBonus: Boolean? = null,
    @SerialName("max_bonus") var maxBonus: Int? = null
)