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
import androidx.navigation.NavController
import com.example.deee_en_deee.infoTypes.*

@Composable
fun AlignmentCardList(alignmentList: List<AlignmentType>, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = alignmentList) { alignmentType ->
            AlignmentCard(alignmentType, navController)
        }

    }
}

@Composable
fun AlignmentCard(alignmentType: AlignmentType, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { navController.navigate("alignmentPage/${alignmentType.index}") }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            AlignmentBaseCard(alignment = alignmentType)
        }
    }
}

@Composable
fun AlignmentBaseCard(alignment: AlignmentType) {
    alignment.name?.let { name ->
        val text = "$name (${alignment.abbreviation})"
        Text(text = text)
    }
}

@Composable
fun AlignmentExtendedCard(alignment: AlignmentType) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Divider(
            modifier = Modifier
                .wrapContentWidth()
                .padding(all = 8.dp)
        )

        alignment.description?.let { description ->
            Column {
                Text(
                    text = "Description:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = description
                )
            }
        }
    }
}

@Composable
fun AlignmentPage(alignmentType: AlignmentType) {
    Box(
        modifier = Modifier.fillMaxHeight()
    ) {
        LazyColumn(
            modifier = Modifier.padding(8.dp)
        ) {
            item{
                AlignmentBaseCard(alignment = alignmentType)
            }
            item{
                AlignmentExtendedCard(alignment = alignmentType)
            }
        }
    }
}

@Composable
fun AlignmentCardDialog(alignment: AlignmentType, onDismissRequest: () -> Unit){
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
                    AlignmentBaseCard(alignment = alignment)
                }
                item{
                    AlignmentExtendedCard(alignment = alignment)
                }
            }
        }
    }
}

@Preview
@Composable
fun AlignmentPreview() {
    val alignmentList = mutableListOf(
        alignmentType, alignmentType, alignmentType, alignmentType, alignmentType, alignmentType, alignmentType, alignmentType
    )
//    AlignmentCardList(alignmentList = alignmentList)
}

val alignmentType = AlignmentType(
    index = "cha",
    abbreviation = "CHA",
    name = "Chaotic Neutral",
    description = "Chaotic neutral (CN) creatures follow their whims, holding their personal freedom above all else. Many barbarians and rogues, and some bards, are chaotic neutral.",

    url = "/api/ability-scores/cha"
)