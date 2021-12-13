package com.example.deee_en_deee.infoTypes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClassType(
    var index: String? = null,
    var name: String? = null,
    @SerialName("hit_dice") var hitDice: Int? = null,
    @SerialName("proficiency_choices") var proficiencyChoices: Choice? = null,
    var proficiencies: MutableList<APIReference>?= null,
    @SerialName("saving_throws") var savingThrows: MutableList<APIReference>? = null,
    @SerialName("starting_equipment") var startingEquipment: MutableList<Inventory>? = null,
    @SerialName("starting_equipment_options") var startingEquipmentOptions: MutableList<Choice>? = null,
    @SerialName("class_levels") var classLevels: MutableList<Level>? = null,
    @SerialName("multi_classing") var multiClassing: Multiclass? = null,
    var subclasses: MutableList<APIReference>? = null,
    var spellcasting: Spellcasting? = null,
    @SerialName("spells") var spellsURL: String? = null,
    var url: String? = null
)
