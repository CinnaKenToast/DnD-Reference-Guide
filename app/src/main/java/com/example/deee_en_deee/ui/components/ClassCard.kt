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
//        ClassCardDialog(classType = classType, onDismissRequest = { openDialog = false })
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
                var text = "Choose ${proficiencyChoices[0].choose} from \n"
                proficiencyChoices[0].from?.forEach { skill ->
                    text += "${skill.name}, "
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
                    text = "Proficiencies:",
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
                    text = "Proficiencies:",
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
    val abilityScoreList = mutableListOf(
        classType, classType, classType, classType, classType, classType, classType, classType
    )
    AbilityScoreCardList(abilityScoreList = abilityScoreList)
}

val classType = AbilityScore(
    index = "cha",
    name = "CHA",
    fullName = "Charisma",
    description = mutableListOf("Charisma measures your ability to interact effectively with others. It includes such factors as confidence and eloquence, and it can represent a charming or commanding personality.",
        "A Charisma check might arise when you try to influence or entertain others, when you try to make an impression or tell a convincing lie, or when you are navigating a tricky social situation. The Deception, Intimidation, Performance, and Persuasion skills reflect aptitude in certain kinds of Charisma checks."),
    skills = mutableListOf(
        APIReference(
            index = "deception",
            name = "Deception",
            url = "/api/skills/deception"
        ),
        APIReference(
            index = "intimidation",
            name = "Intimidation",
            url = "/api/skills/intimidation"
        ),
        APIReference(
            index = "performance",
            name = "Performance",
            url = "/api/skills/performance"
        ),
        APIReference(
            index = "persuasion",
            name = "Persuasion",
            url = "/api/skills/persuasion"
        )
    ),
    url = "/api/ability-scores/cha"
)