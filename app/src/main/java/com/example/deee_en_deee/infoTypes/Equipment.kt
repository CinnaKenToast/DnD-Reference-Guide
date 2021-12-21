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

class EquipmentConverters {
    @TypeConverter
    fun apiReferenceFromString(string: String?): APIReference? {
        return string?.fromJsonString<APIReference>()
    }

    @TypeConverter
    fun apiReferenceToString(apiReference: APIReference?): String? {
        return apiReference?.toJsonString()
    }

    @TypeConverter
    fun armorClassFromString(string: String?): ArmorClass? {
        return string?.fromJsonString<ArmorClass>()
    }

    @TypeConverter
    fun armorClassToString(armorClass: ArmorClass?): String? {
        return armorClass?.toJsonString()
    }

    @TypeConverter
    fun contentsFromString(string: String?): List<Content>? {
        return string?.fromJsonString<List<Content>>()
    }

    @TypeConverter
    fun contentsToString(content: List<Content>?): String? {
        return content?.toJsonString()
    }

    @TypeConverter
    fun costFromString(string: String?): Cost? {
        return string?.fromJsonString<Cost>()
    }

    @TypeConverter
    fun costToString(cost: Cost?): String? {
        return cost?.toJsonString()
    }

    @TypeConverter
    fun damageFromString(string: String?): Damage? {
        return string?.fromJsonString<Damage>()
    }

    @TypeConverter
    fun damageToString(damage: Damage?): String? {
        return damage?.toJsonString()
    }

    @TypeConverter
    fun rangeFromString(string: String?): Range? {
        return string?.fromJsonString<Range>()
    }

    @TypeConverter
    fun rangeToString(range: Range?): String? {
        return range?.toJsonString()
    }

    @TypeConverter
    fun apiReferencesFromString(string: String?): List<APIReference>? {
        return string?.fromJsonString<List<APIReference>>()
    }

    @TypeConverter
    fun apiReferencesToString(apiReferences: List<APIReference>?): String? {
        return apiReferences?.toJsonString()
    }
}

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