package com.example.deee_en_deee.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.ui.components.SpellCardList
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val mainVM = MainVM()

    private val abilityScoreList by mainVM.listOfAbilityScores
    private val alignmentList by mainVM.listOfAlignments
    private val classList by mainVM.listOfClasses
    private val conditionList by mainVM.listOfConditions
    private val damageTypeList by mainVM.listOfDamageTypes
    private val equipmentCategoryList by mainVM.listOfEquipmentCategories
    private val equipmentList by mainVM.listOfEquipments
    private val featList by mainVM.listOfFeats
    private val featureList by mainVM.listOfFeatures
    private val languageList by mainVM.listOfLanguages
    private val magicItemList by mainVM.listOfMagicItems
    private val magicSchoolList by mainVM.listOfMagicSchools
    private val monsterList by mainVM.listOfMonsters
    private val proficiencyList by mainVM.listOfProficiencies
    private val raceList by mainVM.listOfRaces
    private val ruleList by mainVM.listOfRules
    private val ruleSectionList by mainVM.listOfRuleSections
    private val skillList by mainVM.listOfSkills
    private val spellList by mainVM.listOfSpells
    private val subclassList by mainVM.listOfSubclasses
    private val subraceList by mainVM.listOfSubraces
    private val traitList by mainVM.listOfTraits
    private val weaponPropertyList by mainVM.listOfWeaponProperties

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.lifecycleScope.launch {
            mainVM.getCategories().onSuccess {
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.abilityScore)
                mainVM.getAbilityScores(it.abilityScore)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.alignments)
                mainVM.getAlignments(it.alignments)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.classes)
                mainVM.getClasses(it.classes)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.conditions)
                mainVM.getConditions(it.conditions)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.damageTypes)
                mainVM.getDamageTypes(it.damageTypes)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.equipmentCategory)
                mainVM.getEquipmentCategories(it.equipmentCategory)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.equipment)
                mainVM.getEquipments(it.equipment)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.feats)
                mainVM.getFeats(it.feats)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.features)
                mainVM.getFeatures(it.features)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.languages)
                mainVM.getLanguages(it.languages)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.magicItems)
                mainVM.getMagicItems(it.magicItems)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.magicSchools)
                mainVM.getMagicSchool(it.magicSchools)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.monsters)
                mainVM.getMonsters(it.monsters)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.proficiencies)
                mainVM.getProficiencies(it.proficiencies)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.races)
                mainVM.getRaces(it.races)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.rules)
                mainVM.getRules(it.rules)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.ruleSections)
                mainVM.getRuleSections(it.ruleSections)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.skills)
                mainVM.getSkills(it.skills)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.spells)
                mainVM.getSpells(it.spells)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.subclasses)
                mainVM.getSubclasses(it.subclasses)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.subraces)
                mainVM.getSubraces(it.subraces)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.traits)
                mainVM.getTraits(it.traits)
                Log.d("debug", "--------------------------------------")
                Log.d("debug", it.weaponProperties)
                mainVM.getWeaponProperties(it.weaponProperties)
            }
            //showInitialButtons()
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        this.lifecycleScope.launch {
            showInitialButtons()
        }
    }

    private suspend fun showInitialButtons() {
        mainVM.getCategories().onSuccess { references ->
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
                                    Log.d("debug", references.abilityScore)
                                }
                            ){
                                Text("Ability Score")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.alignments) }
                            ){
                                Text("Alignments")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.backgrounds) }
                            ){
                                Text("Backgrounds")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.classes) }
                            ){
                                Text("Classes")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.conditions) }
                            ){
                                Text("Conditions")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.damageTypes) }
                            ){
                                Text("Damage Types")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.equipmentCategory) }
                            ){
                                Text("Equipment Categories")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.equipment) }
                            ){
                                Text("Equipment")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.feats) }
                            ){
                                Text("Feats")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.features) }
                            ){
                                Text("Features")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.languages) }
                            ){
                                Text("Languages")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.magicItems) }
                            ){
                                Text("Magic Items")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.magicSchools) }
                            ){
                                Text("Magic Schools")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.monsters) }
                            ){
                                Text("Monsters")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.proficiencies) }
                            ){
                                Text("Proficiencies")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.races) }
                            ){
                                Text("Races")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.rules) }
                            ){
                                Text("Rules")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.ruleSections) }
                            ){
                                Text("Rule Sections")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.skills) }
                            ){
                                Text("Skills")
                            }
                        }
                        item {
                            Button(
                                onClick = {
                                    Log.d("debug", references.spells)
                                    showCardList(references.spells)
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
                                onClick = { Log.d("debug", references.subclasses) }
                            ){
                                Text("Subclasses")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.subraces) }
                            ){
                                Text("Subraces")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.traits) }
                            ){
                                Text("Traits")
                            }
                        }
                        item {
                            Button(
                                onClick = { Log.d("debug", references.weaponProperties) }
                            ){
                                Text("Weapon Properties")
                            }
                        }
                    }
                }
            }
        }.onFailure {
            throw(Throwable("Unable to get the initial list"))
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

    private fun showCardList(url: String) {
        var spellList by mainVM.listOfSpells

        this.lifecycleScope.launch {
            mainVM.getSpells(url)
        }

        setContent {
            Log.d("debug", "SETTING CONTENT")
            val isLoading = mainVM.isLoading.value
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
                    SpellCardList(spellList = spellList)
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
