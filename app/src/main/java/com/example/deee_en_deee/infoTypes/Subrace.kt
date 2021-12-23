package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "subrace")
@Serializable
data class Subrace(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    var race: APIReference? = null,
    @SerialName("desc") var description: String? = null,
    @SerialName("ability_bonuses") var abilityBonuses: MutableList<AbilityBonus>? = null,
    @SerialName("starting_proficiencies") var startingProficiencies: MutableList<APIReference>? = null,
    var languages: MutableList<APIReference>? = null,
    @SerialName("language_options") var languageOptions: Choice? = null,
    @SerialName("racial_traits") var racialOptions: MutableList<APIReference>? = null,
    var url: String? = null
)
