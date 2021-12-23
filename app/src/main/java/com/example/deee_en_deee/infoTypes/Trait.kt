package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "trait")
@Serializable
data class Trait(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var races: MutableList<APIReference>? = null,
    var subraces: MutableList<APIReference>? = null,
    var name: String? = null,
    @SerialName("desc") var description: MutableList<String>? = null,
    var parent: APIReference? = null,
    var proficiencies: MutableList<APIReference>? = null,
    @SerialName("proficiency_choices") var proficiencyChoices: Choice? = null,
    @SerialName("trait_specific") var traitSpecific: TraitSpecific? = null,
    var url: String? = null
)

@Serializable
data class TraitSpecific(
        @SerialName("subtrait_options") var subtraitOptions: Choice? = null,
        @SerialName("spell_options") var spellOptions: Choice? = null,
        @SerialName("damage_type") var damageType: APIReference? = null,
        @SerialName("breathWeapon") var breathWeapon: BreathWeapon? = null
)