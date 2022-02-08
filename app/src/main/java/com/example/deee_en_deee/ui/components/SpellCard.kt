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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.deee_en_deee.infoTypes.*
import java.util.*

@Composable
fun SpellCardList(spellList: List<Spell>, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = spellList) { spell ->
            SpellCard(spell, navController = navController)
        }

    }
}

@Composable
fun SpellCard(spell: Spell, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { navController.navigate("spellPage/${spell.index}") }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            SpellBaseCard(spell = spell)
        }
    }
}

@Composable
fun SpellBaseCard(spell: Spell) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            spell.name?.let {
                Text(
                    text = it,
                    fontSize = 16.sp
                )
            }
            spell.level?.let {
                Text(
                    text = "Level $it",
                    color = Color.Gray
                )
            }
        }
        Divider(
            modifier = Modifier
                .wrapContentWidth()
                .padding(vertical = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val spellText = spell.attackType?.let { attackType ->
                "Spell (${attackType.capitalize()})"
            } ?: "Spell"
            Text(
                text = spellText,
                color = Color.Gray
            )
            spell.damage?.damageType?.name?.let {
                Text(
                    text = it,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun SpellExtendedCard(spell: Spell) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Divider(
            modifier = Modifier
                .wrapContentWidth()
                .padding(all = 8.dp)
        )
        spell.range?.let { range ->
            Column {
                Text(
                    text = "Range:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = range
                )
            }
        }

        spell.components?.let { components ->
            Column {
                Text(
                    text = "Components:",
                    fontWeight = FontWeight.Bold
                )
                var componentString = ""
                components.forEach { component ->
                    componentString += "$component, "
                }
                Text(
                    text = componentString
                )
            }
        }

        spell.ritual?.let { ritual ->
            Column {
                Text(
                    text = "Ritual:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = ritual.toString().capitalize()
                )
            }
        }

        spell.duration?.let { duration ->
            Column {
                Text(
                    text = "Duration:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = duration
                )
            }
        }

        spell.concentration?.let { concentration ->
            Column {
                Text(
                    text = "Concentration:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = concentration.toString().capitalize()
                )
            }
        }

        spell.castingTime?.let { castingTime ->
            Column {
                Text(
                    text = "Casting Time:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = castingTime
                )
            }
        }

        spell.damage?.damageSlotLevel?.let { damageSlotLevel ->
            Column {
                Text(
                    text = "Damage at Slot Level:",
                    fontWeight = FontWeight.Bold
                )
                var damageText = ""
                damageSlotLevel.level2?.let {
                    damageText += "Level 2: ${it}\n"
                }
                damageSlotLevel.level3?.let {
                    damageText += "Level 3: ${it}\n"
                }
                damageSlotLevel.level4?.let {
                    damageText += "Level 4: ${it}\n"
                }
                damageSlotLevel.level5?.let {
                    damageText += "Level 5: ${it}\n"
                }
                damageSlotLevel.level6?.let {
                    damageText += "Level 6: ${it}\n"
                }
                damageSlotLevel.level7?.let {
                    damageText += "Level 7: ${it}\n"
                }
                damageSlotLevel.level8?.let {
                    damageText += "Level 8: ${it}\n"
                }
                damageSlotLevel.level9?.let {
                    damageText += "Level 9: ${it}\n"
                }
                damageText = damageText.trimEnd()

                Text(
                    text = damageText
                )
            }
        }

        spell.school?.let { school ->
            Column {
                Text(
                    text = "School:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = school.name!!
                )
            }
        }

        spell.classTypes?.let { classes ->
            Column {
                Text(
                    text = "Classes:",
                    fontWeight = FontWeight.Bold
                )
                var classText = ""
                classes.forEach { classType ->
                    classText += "${classType.name!!}, "
                }
                classText = classText.substring(0, classText.length - 2)
                Text(
                    text = classText,
                )
            }
        }

        spell.description?.let { description ->
            Column{
                Text(
                    text = "Description:",
                    fontWeight = FontWeight.Bold
                )
                var descriptor = ""
                description.forEach {
                    descriptor += "$it \n\n"
                }
                descriptor = descriptor.trimEnd()
                Text(
                    text = descriptor
                )
            }
        }
    }
}

@Composable
fun SpellPage(spell: Spell){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(8.dp)
        ) {
            item{
                SpellBaseCard(spell = spell)
            }
            item{
                SpellExtendedCard(spell = spell)
            }
        }
    }
}

@Composable
fun SpellCardDialog(spell: Spell, onDismissRequest: () -> Unit){
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
                    SpellBaseCard(spell = spell)
                }
                item{
                    SpellExtendedCard(spell = spell)
                }
            }
        }
    }
}

fun String.capitalize() =
    this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

@Preview
@Composable
fun SpellCardPreview() {
    val spellList = mutableListOf(
        acidArrow, acidArrow, acidArrow, acidArrow, acidArrow, acidArrow, acidArrow, acidArrow
    )
//    SpellCardList(spellList = spellList)
}

val acidArrow = Spell(
    index = "acid-arrow",
    name = "Acid Arrow",
    description = mutableListOf(
        "A shimmering green arrow streaks toward a target within range and bursts in a spray of acid. Make a ranged spell attack against the target. On a hit, the target takes 4d4 acid damage immediately and 2d4 acid damage at the end of its next turn. On a miss, the arrow splashes the target with acid for half as much of the initial damage and no damage at the end of its next turn."
    ),
    highLevel = mutableListOf(
        "When you cast this spell using a spell slot of 3rd level or higher, the damage (both initial and later) increases by 1d4 for each slot level above 2nd."
    ),
    range = "90 feet",
    components = mutableListOf(
        "V", "S", "M"
    ),
    material = "Powdered rhubarb leaf and an adder's stomach.",
    ritual = false,
    duration = "Instantaneous",
    concentration = false,
    castingTime = "1 action",
    level = 2,
    attackType = "ranged",
    damage = Damage(
        damageType = APIReference(
            index = "acid",
            name = "Acid",
            url = "api/damage-types/acid"
        ),
        damageSlotLevel = DamageAtSlotLevel(
            level2 = "4d4",
            level3 = "5d4",
            level4 = "6d4",
            level5 = "7d4",
            level6 = "8d4",
            level7 = "9d4",
            level8 = "10d4",
            level9 = "11d4"
        )
    ),
    school = APIReference(
        index = "evocation",
        name = "Evocation",
        url = "/api/magic-schools/evocation"
    ),
    classTypes = mutableListOf(
        APIReference(
            index = "wizard",
            name = "Wizard",
            url = "api/classes/wizard"
        )
    ),
    subclasses = mutableListOf(
        APIReference(
            index = "lore",
            name = "Lore",
            url = "/api/subclasses/lore"
        ),
        APIReference(
            index = "land",
            name = "Land",
            url = "/api/subclasses/land"
        )
    ),
    url = "/api/spells/acid-arrow"
)