package com.example.deee_en_deee.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.ui.components.AbilityScoreCardList
import com.example.deee_en_deee.ui.components.AlignmentCardList
import com.example.deee_en_deee.ui.components.ClassCardList
import com.example.deee_en_deee.ui.components.SpellCardList

class MainActivity : ComponentActivity() {
    private lateinit var mainVM: MainVM

//    private val abilityScoreList by mainVM.listOfAbilityScores
//    private val alignmentList by mainVM.listOfAlignments
//    private val classList by mainVM.listOfClasses
//    private val conditionList by mainVM.listOfConditions
//    private val damageTypeList by mainVM.listOfDamageTypes
//    private val equipmentCategoryList by mainVM.listOfEquipmentCategories
//    private val equipmentList by mainVM.listOfEquipments
//    private val featList by mainVM.listOfFeats
//    private val featureList by mainVM.listOfFeatures
//    private val languageList by mainVM.listOfLanguages
//    private val magicItemList by mainVM.listOfMagicItems
//    private val magicSchoolList by mainVM.listOfMagicSchools
//    private val monsterList by mainVM.listOfMonsters
//    private val proficiencyList by mainVM.listOfProficiencies
//    private val raceList by mainVM.listOfRaces
//    private val ruleList by mainVM.listOfRules
//    private val ruleSectionList by mainVM.listOfRuleSections
//    private val skillList by mainVM.listOfSkills
//    private val spellList by mainVM.listOfSpells
//    private val subclassList by mainVM.listOfSubclasses
//    private val subraceList by mainVM.listOfSubraces
//    private val traitList by mainVM.listOfTraits
//    private val weaponPropertyList by mainVM.listOfWeaponProperties

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vmFactory = MainVMFactory(application = application)
        mainVM = ViewModelProvider(this, vmFactory).get(MainVM::class.java)


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

//    override fun onBackPressed() {
//        //super.onBackPressed()
//        setContent {
//            InitialButtons()
//        }
//    }

    @Composable
    fun AppNavigator() {
        val navController = rememberNavController()
        
        NavHost(navController = navController, startDestination = "startPage"){
            composable("startPage") { InitialButtons(navController = navController) }
            composable("abilityList") { AbilityList(navController = navController) }
            composable(
                "abilityPage/{ability}",
                arguments = listOf(
                    navArgument("ability") { type = NavType.StringType }
                )
            ) { navBackStackEntry ->
                navBackStackEntry.arguments?.getString("ability")?.let { ability ->
                /*
                   AbilityPage(navController = navController, ability = ability.fromJsonString<AbilityScore>())
               */
                }
            }
            composable("alignmentList") { AlignmentList(navController = navController) }
            composable("classList") { ClassList(navController = navController) }
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
                        onClick = { mainVM.getConditionList() }
                    ){
                        Text("Conditions")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getDamageTypeList() }
                    ){
                        Text("Damage Types")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getEquipmentCategoryList() }
                    ){
                        Text("Equipment Categories")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getEquipmentList() }
                    ){
                        Text("Equipment")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getFeatList() }
                    ){
                        Text("Feats")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getFeatureList() }
                    ){
                        Text("Features")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getLanguageList() }
                    ){
                        Text("Languages")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getMagicItemList() }
                    ){
                        Text("Magic Items")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getMagicSchoolList() }
                    ){
                        Text("Magic Schools")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getMonsterList() }
                    ){
                        Text("Monsters")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getProficiencyList() }
                    ){
                        Text("Proficiencies")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getRaceList() }
                    ){
                        Text("Races")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getRuleList() }
                    ){
                        Text("Rules")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getRuleSectionList() }
                    ){
                        Text("Rule Sections")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getSkillList() }
                    ){
                        Text("Skills")
                    }
                }
                item {
                    Button(
                        onClick = { showSpellCardList() }
                    ){
                        Text("Spells")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getSubclassList() }
                    ){
                        Text("Subclasses")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getSubraceList() }
                    ){
                        Text("Subraces")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getTraitList() }
                    ){
                        Text("Traits")
                    }
                }
                item {
                    Button(
                        onClick = { mainVM.getWeaponPropertyList() }
                    ){
                        Text("Weapon Properties")
                    }
                }
            }
        }
    }

    private inline fun <reified T> showGenericCardList(stuffResult: Result<List<T>>) {
        when(T::class) {
            AbilityScore::class -> {}
            AlignmentType::class -> {}
            ClassType::class -> {}
            Condition::class -> {}
            DamageType::class -> {}
            EquipmentCategory::class -> {}
            Equipment::class -> {}
            Feat::class -> {}
            Feature::class -> {}
            Language::class -> {}
            MagicItem::class -> {}
            MagicSchool::class -> {}
            Monster::class -> {}
            Proficiency::class -> {}
            Race::class -> {}
            Rule::class -> {}
            RuleSection::class -> {}
            Skill::class -> {}
            Spell::class -> { val genericList by mainVM.listOfSpells }
            Subclass::class -> {}
            Subrace::class -> {}
            Trait::class -> {}
            WeaponProperty::class -> {}
        }
        setContent {
            Log.d("debug", "SETTING CONTENT")
            val isLoading = mainVM.isLoading.value
            val stuffResultState = mutableStateOf(stuffResult)
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
                    }
                } else {
                    stuffResultState.value.onSuccess { listOfStuff ->
                        Log.d("debug", "SHOWING CARDS")
                        when(T::class) {
                            AbilityScore::class -> {}
                            AlignmentType::class -> {}
                            ClassType::class -> {}
                            Condition::class -> {}
                            DamageType::class -> {}
                            EquipmentCategory::class -> {}
                            Equipment::class -> {}
                            Feat::class -> {}
                            Feature::class -> {}
                            Language::class -> {}
                            MagicItem::class -> {}
                            MagicSchool::class -> {}
                            Monster::class -> {}
                            Proficiency::class -> {}
                            Race::class -> {}
                            Rule::class -> {}
                            RuleSection::class -> {}
                            Skill::class -> {}
                            Spell::class -> { SpellCardList(spellList = listOfStuff.filterIsInstance<Spell>()) }
                            Subclass::class -> {}
                            Subrace::class -> {}
                            Trait::class -> {}
                            WeaponProperty::class -> {}
                        }
                    }.onFailure {
                        throw(Throwable(it))
                    }
                }
            }
        }

//        when(listOfStuff.getOrThrow().first()) {
//            is AbilityScore -> {}
//            is AlignmentType -> {}
//            is ClassType -> {}
//            is Condition -> {}
//            is DamageType -> {}
//            is EquipmentCategory -> {}
//            is Equipment -> {}
//            is Feat -> {}
//            is Feature -> {}
//            is Language -> {}
//            is MagicItem -> {}
//            is MagicSchool -> {}
//            is Monster -> {}
//            is Proficiency -> {}
//            is Race -> {}
//            is Rule -> {}
//            is RuleSection -> {}
//            is Skill -> {}
//            is Spell -> {}
//            is Subclass -> {}
//            is Subrace -> {}
//            is Trait -> {}
//            is WeaponProperty -> {}
//        }
    }

    @Composable
    private fun AbilityList(navController: NavController) {
        mainVM.getAbilityScoreList()

        val isLoading by mainVM.isLoading
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
                }
            } else {
                Log.d("debug", "SHOWING CARDS")
                AbilityScoreCardList(abilityScoreList = mainVM.listOfAbilityScores.value)
            }
        }

    }

    @Composable
    private fun AlignmentList(navController: NavController) {
        mainVM.getAlignmentList()

        val isLoading by mainVM.isLoading
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
                }
            } else {
                Log.d("debug", "SHOWING CARDS")
                AlignmentCardList(alignmentList = mainVM.listOfAlignments.value)
            }
            }
    }

    @Composable
    private fun ClassList(navController: NavController) {
        mainVM.getClassList()

        val isLoading by mainVM.isLoading
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
                }
            } else {
                Log.d("debug", "SHOWING CARDS")
                ClassCardList(classList = mainVM.listOfClasses.value)
            }
        }
    }


    private fun showSpellCardList() {
        mainVM.getSpellList()
        setContent {
            val isLoading by mainVM.isLoading
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
                    }
                } else {
                    Log.d("debug", "SHOWING CARDS")
                    SpellCardList(spellList = mainVM.listOfSpells.value)
                }
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
