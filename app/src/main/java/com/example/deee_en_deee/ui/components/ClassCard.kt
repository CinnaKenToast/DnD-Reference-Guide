package com.example.deee_en_deee.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.utils.fromJsonString

@Composable
fun ClassCardList(classList: List<ClassType>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = classList) { classType ->
            ClassCard(classType)
        }

    }
}

@Composable
fun ClassCard(classType: ClassType) {
    var openDialog by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { openDialog = true }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            ClassBaseCard(classType = classType)
        }
    }

    if (openDialog) {
        ClassCardDialog(classType = classType, onDismissRequest = { openDialog = false })
    }
}

@Composable
fun ClassBaseCard(classType: ClassType) {
    classType.name?.let { name ->
        Text(text = name)
    }
}

@Composable
fun ClassExtendedCard(classType: ClassType) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Divider(
            modifier = Modifier
                .wrapContentWidth()
                .padding(all = 8.dp)
        )

        classType.hitDie?.let { hitDie ->
            Column {
                Text(
                    text = "Hit Die:",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = hitDie.toString()
                )
            }
        }

        classType.proficiencyChoices?.let { proficiencyChoices ->
            Column {
                Text(
                    text = "Skill Proficiency Choices:",
                    fontWeight = FontWeight.Bold
                )
                var text = "Choose ${proficiencyChoices[0].choose} from: \n"
                proficiencyChoices[0].from?.forEach { skill ->
                    text += "${skill.name?.drop(7)},\n"
                }
                text = text.trimEnd().dropLast(1)
                Text(
                    text = text
                )
            }
        }

        classType.proficiencies?.let { proficiencies ->
            Column {
                Text(
                    text = "Proficiencies:",
                    fontWeight = FontWeight.Bold
                )
                val proficiencyList = mutableListOf<String>()
                proficiencies.forEach { proficiency ->
                    proficiencyList.add(proficiency.name ?: "")
                }
                val text = proficiencyList.joinToString(separator = "\n").trimEnd()
                Text(
                    text = text
                )
            }
        }

        classType.savingThrows?.let { savingThrows ->
            Column {
                Text(
                    text = "Saving Throws:",
                    fontWeight = FontWeight.Bold
                )
                val savingThrowList = mutableListOf<String>()
                savingThrows.forEach { savingThrow ->
                    savingThrowList.add(savingThrow.name ?: "")
                }
                val text = savingThrowList.joinToString(separator = "\n").trimEnd()
                Text(
                    text = text
                )
            }
        }

        classType.startingEquipment?.let { startingEquipment ->
            Column {
                Text(
                    text = "Starting Equipment:",
                    fontWeight = FontWeight.Bold
                )
                val equipmentList = mutableListOf<String>()
                startingEquipment.forEach { equipment ->
                    if (equipment.quantity!! > 1) {
                        equipmentList.add("${equipment.equipment?.name ?: ""} (${equipment.quantity})")
                    } else {
                        equipmentList.add(equipment.equipment?.name ?: "")
                    }
                }
                classType.startingEquipmentOptions?.let { startingOptions ->
                    startingOptions.forEach { startingOption ->
                        if (startingOption.choose!! > 0 ) {
                            var text = ""
                            startingOption.from?.forEach { inventory ->
                                if (startingOption.from!!.indexOf(inventory) > 0 && startingOption.from!!.indexOf(inventory) != startingOption.from!!.size) {
                                    text += " or "
                                }

                                inventory.firstPairItem?.let { firstPairItem ->
                                    inventory.secondPairItem?.let { secondPairItem ->
                                        var itemText = "${ if (firstPairItem.quantity!! > 1) firstPairItem.quantity else {""} } ${ firstPairItem.equipment?.name }"
                                        itemText = if (secondPairItem.equipment != null) {
                                            "$itemText and ${ if (secondPairItem.quantity!! > 1) secondPairItem.quantity else {""} } ${ secondPairItem.equipment?.name ?: ""}"
                                        } else {
                                            "$itemText and ${ secondPairItem.equipmentChoice!!.choose } ${ secondPairItem.equipmentChoice!!.from!!.equipmentCategory!!.name }"
                                        }

                                        itemText = "($itemText)"

                                        text += itemText
                                    }
                                }

                                inventory.equipmentChoice?.let { choice ->
                                    var itemText = "${ choice.choose } ${ choice.from?.equipmentCategory?.name }"
                                    if (startingOption.from!!.size > 1 ) {
                                        itemText = "($itemText)"
                                    }
                                    text += itemText
                                }

                                inventory.equipment?.let { item ->
                                    inventory.quantity?. let { quantity ->
                                        var itemText = "${ if (quantity > 1) { "$quantity " } else {""} }${ item.name }"
                                        if ( inventory.prerequisites != null ) {
                                            inventory.prerequisites!!.forEach { prerequisite ->
                                                if ( prerequisite.proficiency!!.name!!.contains(item.name!!)) {
                                                    itemText = "$itemText if proficient"
                                                }
                                            }
                                        }
                                        if (startingOption.from!!.size > 1 ) {
                                            itemText = "($itemText)"
                                        }
                                        text += itemText
                                    }
                                }

                                inventory.equipmentCategory?.let { item ->
                                    var itemText = "${ item.name }"
                                    if (startingOption.from!!.size > 1 ) {
                                        itemText = "($itemText)"
                                    }
                                    text += itemText
                                }
                            }
                            equipmentList.add(text)
                            text = ""
                        }
                    }
                }
                val text = equipmentList.joinToString(separator = "\n").trimEnd()
                Text(
                    text = text
                )


            }
        }

    }
}

@Composable
fun ClassCardDialog(classType: ClassType, onDismissRequest: () -> Unit){
    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Surface(
            shape = RoundedCornerShape(size = 16.dp),
            modifier = Modifier.clickable { onDismissRequest() }
        ) {
            LazyColumn(
                modifier = Modifier.padding(8.dp)
            ) {
                item{
                    ClassBaseCard(classType = classType)
                }
                item{
                    ClassExtendedCard(classType = classType)
                }
            }
        }
    }
}

@Preview
@Composable
fun ClassPreview() {
    val classList = mutableListOf(
        classType, classType, classType, classType, classType, classType, classType, classType
    )
    ClassCardList(classList = classList)
}

val classType = "{\"index\":\"paladin\",\"name\":\"Paladin\",\"hit_die\":10,\"proficiency_choices\":[{\"choose\":2,\"type\":\"proficiencies\",\"from\":[{\"index\":\"skill-athletics\",\"name\":\"Skill: Athletics\",\"url\":\"/api/proficiencies/skill-athletics\"},{\"index\":\"skill-insight\",\"name\":\"Skill: Insight\",\"url\":\"/api/proficiencies/skill-insight\"},{\"index\":\"skill-intimidation\",\"name\":\"Skill: Intimidation\",\"url\":\"/api/proficiencies/skill-intimidation\"},{\"index\":\"skill-medicine\",\"name\":\"Skill: Medicine\",\"url\":\"/api/proficiencies/skill-medicine\"},{\"index\":\"skill-persuasion\",\"name\":\"Skill: Persuasion\",\"url\":\"/api/proficiencies/skill-persuasion\"},{\"index\":\"skill-religion\",\"name\":\"Skill: Religion\",\"url\":\"/api/proficiencies/skill-religion\"}]}],\"proficiencies\":[{\"index\":\"all-armor\",\"name\":\"All armor\",\"url\":\"/api/proficiencies/all-armor\"},{\"index\":\"shields\",\"name\":\"Shields\",\"url\":\"/api/proficiencies/shields\"},{\"index\":\"simple-weapons\",\"name\":\"Simple Weapons\",\"url\":\"/api/proficiencies/simple-weapons\"},{\"index\":\"martial-weapons\",\"name\":\"Martial Weapons\",\"url\":\"/api/proficiencies/martial-weapons\"}],\"saving_throws\":[{\"index\":\"wis\",\"name\":\"WIS\",\"url\":\"/api/ability-scores/wis\"},{\"index\":\"cha\",\"name\":\"CHA\",\"url\":\"/api/ability-scores/cha\"}],\"starting_equipment\":[{\"equipment\":{\"index\":\"chain-mail\",\"name\":\"Chain Mail\",\"url\":\"/api/equipment/chain-mail\"},\"quantity\":1}],\"starting_equipment_options\":[{\"choose\":1,\"type\":\"equipment\",\"from\":[{\"0\":{\"equipment\":{\"index\":\"shield\",\"name\":\"Shield\",\"url\":\"/api/equipment/shield\"},\"quantity\":1},\"1\":{\"equipment_option\":{\"choose\":1,\"type\":\"equipment\",\"from\":{\"equipment_category\":{\"index\":\"martial-weapons\",\"name\":\"Martial Weapons\",\"url\":\"/api/equipment-categories/martial-weapons\"}}}}},{\"equipment_option\":{\"choose\":2,\"type\":\"equipment\",\"from\":{\"equipment_category\":{\"index\":\"martial-weapons\",\"name\":\"Martial Weapons\",\"url\":\"/api/equipment-categories/martial-weapons\"}}}}]},{\"choose\":1,\"type\":\"equipment\",\"from\":[{\"equipment\":{\"index\":\"javelin\",\"name\":\"Javelin\",\"url\":\"/api/equipment/javelin\"},\"quantity\":5},{\"equipment_option\":{\"choose\":1,\"type\":\"equipment\",\"from\":{\"equipment_category\":{\"index\":\"simple-weapons\",\"name\":\"Simple Weapons\",\"url\":\"/api/equipment-categories/simple-weapons\"}}}}]},{\"choose\":1,\"type\":\"equipment\",\"from\":[{\"equipment\":{\"index\":\"priests-pack\",\"name\":\"Priest's Pack\",\"url\":\"/api/equipment/priests-pack\"},\"quantity\":1},{\"equipment\":{\"index\":\"explorers-pack\",\"name\":\"Explorer's Pack\",\"url\":\"/api/equipment/explorers-pack\"},\"quantity\":1}]},{\"choose\":1,\"type\":\"equipment\",\"from\":[{\"equipment_category\":{\"index\":\"holy-symbols\",\"name\":\"Holy Symbols\",\"url\":\"/api/equipment-categories/holy-symbols\"}}]}],\"class_levels\":\"/api/classes/paladin/levels\",\"multi_classing\":{\"prerequisites\":[{\"ability_score\":{\"index\":\"str\",\"name\":\"STR\",\"url\":\"/api/ability-scores/str\"},\"minimum_score\":13},{\"ability_score\":{\"index\":\"cha\",\"name\":\"CHA\",\"url\":\"/api/ability-scores/cha\"},\"minimum_score\":13}],\"proficiencies\":[{\"index\":\"light-armor\",\"name\":\"Light Armor\",\"url\":\"/api/proficiencies/light-armor\"},{\"index\":\"medium-armor\",\"name\":\"Medium Armor\",\"url\":\"/api/proficiencies/medium-armor\"},{\"index\":\"shields\",\"name\":\"Shields\",\"url\":\"/api/proficiencies/shields\"},{\"index\":\"simple-weapons\",\"name\":\"Simple Weapons\",\"url\":\"/api/proficiencies/simple-weapons\"},{\"index\":\"martial-weapons\",\"name\":\"Martial Weapons\",\"url\":\"/api/proficiencies/martial-weapons\"}]},\"subclasses\":[{\"index\":\"devotion\",\"name\":\"Devotion\",\"url\":\"/api/subclasses/devotion\"}],\"spellcasting\":{\"level\":2,\"spellcasting_ability\":{\"index\":\"cha\",\"name\":\"CHA\",\"url\":\"/api/ability-scores/cha\"},\"info\":[{\"name\":\"Preparing and Casting Spells\",\"desc\":[\"The Paladin table shows how many spell slots you have to cast your spells. To cast one of your paladin spells of 1st level or higher, you must expend a slot of the spell's level or higher. You regain all expended spell slots when you finish a long rest.\",\"You prepare the list of paladin spells that are available for you to cast, choosing from the paladin spell list. When you do so, choose a number of paladin spells equal to your Charisma modifier + half your paladin level, rounded down (minimum of one spell). The spells must be of a level for which you have spell slots.\",\"For example, if you are a 5th-level paladin, you have four 1st-level and two 2nd-level spell slots. With a Charisma of 14, your list of prepared spells can include four spells of 1st or 2nd level, in any combination. If you prepare the 1st-level spell cure wounds, you can cast it using a 1st-level or a 2nd- level slot. Casting the spell doesn't remove it from your list of prepared spells.\",\"You can change your list of prepared spells when you finish a long rest. Preparing a new list of paladin spells requires time spent in prayer and meditation: at least 1 minute per spell level for each spell on your list.\"]},{\"name\":\"Spellcasting Ability\",\"desc\":[\"Charisma is your spellcasting ability for your paladin spells, since their power derives from the strength of your convictions. You use your Charisma whenever a spell refers to your spellcasting ability. In addition, you use your Charisma modifier when setting the saving throw DC for a paladin spell you cast and when making an attack roll with one.\",\"Spell save DC = 8 + your proficiency bonus + your Charisma modifier.\",\"Spell attack modifier = your proficiency bonus + your Charisma modifier.\"]},{\"name\":\"Spellcasting Focus\",\"desc\":[\"You can use a holy symbol as a spellcasting focus for your paladin spells.\"]}]},\"spells\":\"/api/classes/paladin/spells\",\"url\":\"/api/classes/paladin\"}".fromJsonString<ClassType>()