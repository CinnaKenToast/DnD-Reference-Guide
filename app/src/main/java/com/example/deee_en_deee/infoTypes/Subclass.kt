package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "subclass")
@Serializable
data class Subclass(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    @SerialName("class") var classType: APIReference? = null,
    var name: String? = null,
    @SerialName("subclass_flavor") var subclassFlavor: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var spells: MutableList<SubclassSpell>? = null,
    @SerialName("subclass_levels") var subclassLevels: String? = null,
    var url: String? = null
)

@Serializable
data class SubclassSpell(
    val spell: APIReference? = null,
    val prerequisites: MutableList<SubclassPrerequisite>? = null
)

@Serializable
data class SubclassPrerequisite(
    val index: String? = null,
    val type: String? = null,
    val name: String? = null,
    val url: String? = null
)