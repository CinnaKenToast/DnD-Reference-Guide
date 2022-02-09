package com.example.deee_en_deee.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.deee_en_deee.ui.components.*

class MainActivity : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var abilityScoreViewModel: AbilityScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application = application)).get(MainViewModel::class.java)
        abilityScoreViewModel = ViewModelProvider(this, AbilityScoreViewModelFactory(application = application)).get(AbilityScoreViewModel::class.java)


        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppNavigator()
                }
            }
        }
    }

    @Composable
    fun AppNavigator() {
        val navController = rememberNavController()
        
        NavHost(navController = navController, startDestination = "startPage"){
            composable("startPage") { InitialButtons(navController = navController) }
            composable("abilityList") { AbilityListScreen(navController = navController) }
            composable(
                "abilityScorePage/{abilityIndex}",
                arguments = listOf(
                    navArgument("abilityIndex") { type = NavType.StringType }
                )
            ) { navBackStackEntry ->
                navBackStackEntry.arguments?.getString("abilityIndex")?.let { abilityIndex ->
                    val abilityScore = abilityScoreViewModel.getAbilityScore(abilityIndex)
                    AbilityScorePage(abilityScore = abilityScore)
                }
            }
            composable("alignmentList") { AlignmentListScreen(navController = navController) }
            composable(
                "alignmentPage/{alignmentIndex}",
                arguments = listOf(
                    navArgument("alignmentIndex") { type = NavType.StringType }
                )
            ) { navBackStackEntry ->
                navBackStackEntry.arguments?.getString("alignmentIndex")?.let {alignmentIndex ->
                    val alignmentType = mainViewModel.getAlignmentType(alignmentIndex)
                    AlignmentPage(alignmentType = alignmentType)
                }
            }
            composable("classList") { ClassListScreen(navController = navController) }
            composable(
                "classPage/{classIndex}",
                arguments = listOf(
                    navArgument("classIndex") { type = NavType.StringType }
                )
            ) { navBackStackEntry ->
                navBackStackEntry.arguments?.getString("classIndex")?.let {classIndex ->
                    val classType = mainViewModel.getClassType(classIndex)
                    ClassPage(classType = classType)
                }
            }

            composable("spellList") { SpellListScreen(navController = navController) }
            composable(
                "spellPage/{spellIndex}",
                arguments = listOf(
                    navArgument("spellIndex") { type = NavType.StringType }
                )
            ) { navBackStackEntry ->
                navBackStackEntry.arguments?.getString("spellIndex")?.let {spellIndex ->
                    val spell = mainViewModel.getSpell(spellIndex)
                    SpellPage(spell = spell)
                }
            }
        }
    }

    @Composable
    private fun InitialButtons(navController: NavController) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Button(
                        onClick = { navController.navigate("abilityList") }
                    ){
                        Text("Ability Score")
                    }
                }
                item {
                    Button(
                        onClick = { navController.navigate("alignmentList") }
                    ){
                        Text("Alignments")
                    }
                }
                item {
                    Button(
                        onClick = { navController.navigate("classList") }
                    ){
                        Text("Classes")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getConditionList() }
                    ){
                        Text("Conditions")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getDamageTypeList() }
                    ){
                        Text("Damage Types")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getEquipmentCategoryList() }
                    ){
                        Text("Equipment Categories")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getEquipmentList() }
                    ){
                        Text("Equipment")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getFeatList() }
                    ){
                        Text("Feats")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getFeatureList() }
                    ){
                        Text("Features")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getLanguageList() }
                    ){
                        Text("Languages")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getMagicItemList() }
                    ){
                        Text("Magic Items")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getMagicSchoolList() }
                    ){
                        Text("Magic Schools")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getMonsterList() }
                    ){
                        Text("Monsters")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getProficiencyList() }
                    ){
                        Text("Proficiencies")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getRaceList() }
                    ){
                        Text("Races")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getRuleList() }
                    ){
                        Text("Rules")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getRuleSectionList() }
                    ){
                        Text("Rule Sections")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getSkillList() }
                    ){
                        Text("Skills")
                    }
                }
                item {
                    Button(
                        onClick = { navController.navigate("spellList") }
                    ){
                        Text("Spells")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getSubclassList() }
                    ){
                        Text("Subclasses")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getSubraceList() }
                    ){
                        Text("Subraces")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getTraitList() }
                    ){
                        Text("Traits")
                    }
                }
                item {
                    Button(
                        onClick = { mainViewModel.getWeaponPropertyList() }
                    ){
                        Text("Weapon Properties")
                    }
                }
            }
        }
    }

    @Composable
    private fun AbilityListScreen(navController: NavController) {
        Log.d("debug", "STARTING ABILITY LIST")
        LaunchedEffect(Unit) {
            abilityScoreViewModel.getAbilityScoreList()
        }

        val isLoading by abilityScoreViewModel.isLoading
        Log.d("debug", "LOADING: $isLoading")
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        ) {
            if (isLoading) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Log.d("debug", "LOADING")
                    CircularProgressIndicator()
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontSize = 16.sp,
                        text = "This may take a moment",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            } else {
                Log.d("debug", "SHOWING CARDS")
                AbilityScoreCardList(abilityScoreList = abilityScoreViewModel.listOfAbilityScores.value, navController = navController)
            }
        }
    }

    @Composable
    private fun AlignmentListScreen(navController: NavController) {
        LaunchedEffect(Unit) {
            mainViewModel.getAlignmentList()
        }

        val isLoading by mainViewModel.isLoading
        Log.d("debug", "LOADING: $isLoading")
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        ) {
            if (isLoading) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Log.d("debug", "LOADING")
                    CircularProgressIndicator()
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontSize = 16.sp,
                        text = "This may take a moment",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            } else {
                Log.d("debug", "SHOWING CARDS")
                AlignmentCardList(alignmentList = mainViewModel.listOfAlignments.value, navController = navController)
            }
        }
    }

    @Composable
    private fun ClassListScreen(navController: NavController) {
        LaunchedEffect(Unit) {
            mainViewModel.getClassList()
        }

        val isLoading by mainViewModel.isLoading
        Log.d("debug", "LOADING: $isLoading")
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        ) {
            if (isLoading) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Log.d("debug", "LOADING")
                    CircularProgressIndicator()
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontSize = 16.sp,
                        text = "This may take a moment",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            } else {
                Log.d("debug", "SHOWING CARDS")
                ClassCardList(classList = mainViewModel.listOfClasses.value, navController)
            }
        }
    }

    @Composable
    private fun SpellListScreen(navController: NavController) {
        LaunchedEffect(Unit) {
            mainViewModel.getSpellList()
        }

        val isLoading by mainViewModel.isLoading
        Log.d("debug", "LOADING: $isLoading")
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        ) {
            if (isLoading) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Log.d("debug", "LOADING")
                    CircularProgressIndicator()
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontSize = 16.sp,
                        text = "This may take a moment",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            } else {
                Log.d("debug", "SHOWING CARDS")
                SpellCardList(spellList = mainViewModel.listOfSpells.value, navController)
            }
        }
    }

    enum class Categories(val category: String) {
        ABILITY_SCORE("ability-scores"),
        ALIGNMENTS("alignments"),
        BACKGROUNDS(""),
        CLASSES("classes"),
        CONDITIONS("conditions"),
        DAMAGE_TYPES("damage-types"),
        EQUIPMENT_CATEGORIES("equipment-categories"),
        EQUIPMENT("equipment"),
        FEATS("feats"),
        FEATURES("features"),
        LANGUAGES("languages"),
        MAGIC_ITEMS("magic-items"),
        MAGIC_SCHOOLS("magic-schools"),
        MONSTERS("monsters"),
        PROFICIENCIES("proficiencies"),
        RACES("races"),
        RULES("rules"),
        RULE_SECTION("rule-sections"),
        SKILLS("skills"),
        SPELLS("spells"),
        SUBCLASSES("subclasses"),
        SUBRACES("subraces"),
        TRAITS("traits"),
        WEAPON_PROPERTIES("weapon-properties")
    }

}
