package com.example.deee_en_deee.infoTypes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString
import io.ktor.client.call.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "classType")
@Serializable
data class ClassType(
    @PrimaryKey(autoGenerate = false)
    var index: String,
    var name: String? = null,
    @SerialName("hit_die") var hitDie: Int? = null,
    @SerialName("proficiency_choices") var proficiencyChoices: MutableList<Choice>? = null,
    var proficiencies: MutableList<APIReference>?= null,
    @SerialName("saving_throws") var savingThrows: MutableList<APIReference>? = null,
    @SerialName("starting_equipment") var startingEquipment: MutableList<Inventory>? = null,
    @SerialName("starting_equipment_options") var startingEquipmentOptions: MutableList<Choice>? = null,
    //@SerialName("class_levels") var classLevels: MutableList<Level>? = null,
    @SerialName("class_levels") var classLevels: String? = null,
    @SerialName("multi_classing") var multiClassing: Multiclass? = null,
    var subclasses: MutableList<APIReference>? = null,
    var spellcasting: Spellcasting? = null,
    @SerialName("spells") var spellsURL: String? = null,
    var url: String? = null
)