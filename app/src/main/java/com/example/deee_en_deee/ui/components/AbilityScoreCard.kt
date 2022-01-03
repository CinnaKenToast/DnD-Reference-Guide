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
fun AbilityScoreCardList(abilityScoreList: List<AbilityScore>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = abilityScoreList) { abilityScore ->
            AbilityScoreCard(abilityScore)
        }
    }
}

@Composable
fun AbilityScoreCard(abilityScore: AbilityScore) {
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
            AbilityScoreBaseCard(abilityScore = abilityScore)
        }
    }

    if (openDialog) {
        AbilityScoreCardDialog(abilityScore = abilityScore, onDismissRequest = { openDialog = false })
    }
}

@Composable
fun AbilityScoreBaseCard(abilityScore: AbilityScore) {
    abilityScore.fullName?.let { fullName ->
        val text = "$fullName (${abilityScore.name})"
        Text(text = text)
    }
}

@Composable
fun AbilityScoreExtendedCard(abilityScore: AbilityScore) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Divider(
            modifier = Modifier
                .wrapContentWidth()
                .padding(all = 8.dp)
        )

        abilityScore.description?.let { description ->
            Column {
                Text(
                    text = "Description:",
                    fontWeight = FontWeight.Bold
                )
                val text = description.joinToString(separator = "\n").trimEnd()
                Text(
                    text = text
                )
            }
        }

        abilityScore.skills?.let { skills ->
            if (skills.isNotEmpty()) {
                Column {
                    Text(
                        text = "Skills:",
                        fontWeight = FontWeight.Bold
                    )
                    val skillNames = mutableListOf<String>()
                    skills.forEach { skill ->
                        skillNames.add(skill.name ?: "")
                    }
                    val text = skillNames.joinToString(separator = "\n").trimEnd()
                    Text(
                        text = text
                    )
                }
            }
        }

    }
}

@Composable
fun AbilityScoreCardDialog(abilityScore: AbilityScore, onDismissRequest: () -> Unit){
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
                    AbilityScoreBaseCard(abilityScore = abilityScore)
                }
                item{
                    AbilityScoreExtendedCard(abilityScore = abilityScore)
                }
            }
        }
    }
}

@Preview
@Composable
fun AbilityScorePreview() {
    val abilityScoreList = mutableListOf(
        abilityScore, abilityScore, abilityScore, abilityScore, abilityScore, abilityScore, abilityScore, abilityScore
    )
    AbilityScoreCardList(abilityScoreList = abilityScoreList)
}

val abilityScore = AbilityScore(
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