package com.example.deee_en_deee.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.ui.components.SpellCardList
import com.example.deee_en_deee.ui.components.capitalize
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val mainVM = MainVM()


    val isLoading by mainVM.isLoading

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

        val loadedCategories = mutableStateOf(0)
        val downloadingCategoryTitle = mutableStateOf("")

        this.lifecycleScope.launch {
            mainVM.getCategories().onSuccess {
                mainVM.setLoading(true)

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.abilityScore)
                mainVM.getAbilityScores(it.abilityScore)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.alignments)
                mainVM.getAlignments(it.alignments)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.classes)
                mainVM.getClasses(it.classes)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.conditions)
                mainVM.getConditions(it.conditions)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.damageTypes)
                mainVM.getDamageTypes(it.damageTypes)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.equipmentCategory)
                mainVM.getEquipmentCategories(it.equipmentCategory)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.equipment)
                mainVM.getEquipments(it.equipment)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.feats)
                mainVM.getFeats(it.feats)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.features)
                mainVM.getFeatures(it.features)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.languages)
                mainVM.getLanguages(it.languages)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.magicItems)
                mainVM.getMagicItems(it.magicItems)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.magicSchools)
                mainVM.getMagicSchool(it.magicSchools)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.monsters)
                mainVM.getMonsters(it.monsters)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.proficiencies)
                mainVM.getProficiencies(it.proficiencies)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.races)
                mainVM.getRaces(it.races)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.rules)
                mainVM.getRules(it.rules)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.ruleSections)
                mainVM.getRuleSections(it.ruleSections)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.skills)
                mainVM.getSkills(it.skills)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.spells)
                mainVM.getSpells(it.spells)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.subclasses)
                mainVM.getSubclasses(it.subclasses)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.subraces)
                mainVM.getSubraces(it.subraces)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.traits)
                mainVM.getTraits(it.traits)
                loadedCategories.value++

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.weaponProperties)
                mainVM.getWeaponProperties(it.weaponProperties)
                loadedCategories.value++

                delay(5000)
                mainVM.setLoading(false)
            }
        }
        setContent {
            Log.d("debug2", "SETTING CONTENT")
            Log.d("debug2", isLoading.toString())
            val numberOfLoadedCategories by loadedCategories
            val currentlyDownloadingCategory by downloadingCategoryTitle

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (isLoading) {
                        Text("Downloading Data")
                        Text("This may take a couple of minutes")
                        LinearProgressIndicator(progress = numberOfLoadedCategories / 22f)
                        if (currentlyDownloadingCategory.isNotEmpty()) {
                            Text("Downloading... $currentlyDownloadingCategory")
                        }
                    } else {
                        showInitialButtons()
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
            showInitialButtons()
    }

    private fun getCategoryStringFromUrl(url: String): String {
        var newString = url.drop(5).replace("-", " ")
        newString = newString.split(" ").joinToString(" ") { it.capitalize() }.trimEnd();
        return newString
    }

    private fun showInitialButtons() {
            setContent {
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
                                onClick = {
                                }
                            ){
                                Text("Ability Score")
                            }
                        }
                        item {
                            Button(
                                onClick = {}
                            ){
                                Text("Alignments")
                            }
                        }
                        item {
                            Button(
                                onClick = {}
                            ){
                                Text("Backgrounds")
                            }
                        }
                        item {
                            Button(
                                onClick = {}
                            ){
                                Text("Classes")
                            }
                        }
                        item {
                            Button(
                                onClick = {}
                            ){
                                Text("Conditions")
                            }
                        }
                        item {
                            Button(
                                onClick = {  }
                            ){
                                Text("Damage Types")
                            }
                        }
                        item {
                            Button(
                                onClick = {}
                            ){
                                Text("Equipment Categories")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Equipment")
                            }
                        }
                        item {
                            Button(
                                onClick = {}
                            ){
                                Text("Feats")
                            }
                        }
                        item {
                            Button(
                                onClick = {}
                            ){
                                Text("Features")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Languages")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Magic Items")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Magic Schools")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Monsters")
                            }
                        }
                        item {
                            Button(
                                onClick = {  }
                            ){
                                Text("Proficiencies")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Races")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Rules")
                            }
                        }
                        item {
                            Button(
                                onClick = {  }
                            ){
                                Text("Rule Sections")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Skills")
                            }
                        }
                        item {
                            Button(
                                onClick = {
                                    showSpellCardList()
//                                    var listOfSpellsResult:  Result<List<Spell>> = Result.success(listOf())
//                                    this@MainActivity.lifecycleScope.launch {
//                                        listOfSpellsResult = mainVM.getSpells(references.spells)
//                                        Log.d("debug", listOfSpellsResult.toString())
//                                    }
//                                    showGenericCardList(listOfSpellsResult)
                                }
                            ){
                                Text("Spells")
                            }
                        }
                        item {
                            Button(
                                onClick = {}
                            ){
                                Text("Subclasses")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Subraces")
                            }
                        }
                        item {
                            Button(
                                onClick = {  }
                            ){
                                Text("Traits")
                            }
                        }
                        item {
                            Button(
                                onClick = { }
                            ){
                                Text("Weapon Properties")
                            }
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

    private fun showSpellCardList() {
        setContent {
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
