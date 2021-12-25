package com.example.deee_en_deee.ui

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.deee_en_deee.database.*
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.services.CategoryDataService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainVM(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    private val categoryDataService = CategoryDataService(context)
    val isLoading = mutableStateOf(true)

    val abilityScoreDao = AbilityScoreDatabase.getInstance(context).abilityScoreDao()
    val alignmentDao = AlignmentDatabase.getInstance(context).alignmentDao()
    val classDao = ClassDatabase.getInstance(context).classDao()
    val conditionDao = ConditionDatabase.getInstance(context).conditionDao()
    val damageTypeDao = DamageTypeDatabase.getInstance(context).damageTypeDao()
    val equipmentCategoryDao = EquipmentCategoryDatabase.getInstance(context).equipmentCategoryDao()
    val equipmentDao = EquipmentDatabase.getInstance(context).equipmentDao()
    val featDao = FeatDatabase.getInstance(context).featDao()
    val featureDao = FeatureDatabase.getInstance(context).featureDao()
    val languageDao = LanguageDatabase.getInstance(context).languageDao()
    val magicItemDao = MagicItemDatabase.getInstance(context).magicItemDao()
    val magicSchoolDao = MagicSchoolDatabase.getInstance(context).magicSchoolDao()
    val monsterDao = MonsterDatabase.getInstance(context).monsterDao()
    val proficiencyDao = ProficiencyDatabase.getInstance(context).proficiencyDao()
    val raceDao = RaceDatabase.getInstance(context).raceDao()
    val ruleDao = RuleDatabase.getInstance(context).ruleDao()
    val ruleSectionDao = RuleSectionDatabase.getInstance(context).ruleSectionDao()
    val skillDao = SkillDatabase.getInstance(context).skillDao()
    val spellDao = SpellDatabase.getInstance(context).spellDao()
    val subclassDao = SubclassDatabase.getInstance(context).subclassDao()
    val subraceDao = SubraceDatabase.getInstance(context).subraceDao()
    val traitDao = TraitDatabase.getInstance(context).traitDao()
    val weaponPropertyDao = WeaponPropertyDatabase.getInstance(context).weaponPropertyDao()

    val listOfAbilityScores = mutableStateOf(listOf<AbilityScore>())
    val listOfAlignments = mutableStateOf(listOf<AlignmentType>())
    val listOfClasses = mutableStateOf(listOf<ClassType>())
    val listOfConditions = mutableStateOf(listOf<Condition>())
    val listOfDamageTypes = mutableStateOf(listOf<DamageType>())
    val listOfEquipmentCategories = mutableStateOf(listOf<EquipmentCategory>())
    val listOfEquipments = mutableStateOf(listOf<Equipment>())
    val listOfFeats = mutableStateOf(listOf<Feat>())
    val listOfFeatures = mutableStateOf(listOf<Feature>())
    val listOfLanguages = mutableStateOf(listOf<Language>())
    val listOfMagicItems = mutableStateOf(listOf<MagicItem>())
    val listOfMagicSchools = mutableStateOf(listOf<MagicSchool>())
    val listOfMonsters = mutableStateOf(listOf<Monster>())
    val listOfProficiencies = mutableStateOf(listOf<Proficiency>())
    val listOfRaces = mutableStateOf(listOf<Race>())
    val listOfRules = mutableStateOf(listOf<Rule>())
    val listOfRuleSections = mutableStateOf(listOf<RuleSection>())
    val listOfSkills = mutableStateOf(listOf<Skill>())
    val listOfSpells = mutableStateOf(listOf<Spell>())
    val listOfSubclasses = mutableStateOf(listOf<Subclass>())
    val listOfSubraces = mutableStateOf(listOf<Subrace>())
    val listOfTraits = mutableStateOf(listOf<Trait>())
    val listOfWeaponProperties = mutableStateOf(listOf<WeaponProperty>())

    val loadedCategories = mutableStateOf(0)
    val downloadingCategoryTitle = mutableStateOf("")

    init {
        viewModelScope.launch {
            categoryDataService.getCategories().onSuccess { it ->
                setLoading(true)

                categoryDataService.checkAndSetAbilityScoreList(it.abilityScore, listOfAbilityScores, abilityScoreDao)
                categoryDataService.checkAndSetAlignmentList(it.alignments, listOfAlignments, alignmentDao)
                categoryDataService.checkAndSetClassList(it.classes, listOfClasses, classDao)
                categoryDataService.checkAndSetConditionList(it.conditions, listOfConditions, conditionDao)
                categoryDataService.checkAndSetDamageTypeList(it.damageTypes, listOfDamageTypes, damageTypeDao)
                categoryDataService.checkAndSetEquipmentCategoryList(it.equipmentCategory, listOfEquipmentCategories, equipmentCategoryDao)
                categoryDataService.checkAndSetEquipmentList(it.equipment, listOfEquipments, equipmentDao)
                categoryDataService.checkAndSetFeatList(it.feats, listOfFeats, featDao)
                categoryDataService.checkAndSetFeatureList(it.features, listOfFeatures, featureDao)
                categoryDataService.checkAndSetLanguageList(it.languages, listOfLanguages, languageDao)
                categoryDataService.checkAndSetMagicItemList(it.magicItems, listOfMagicItems, magicItemDao)
                categoryDataService.checkAndSetMagicSchoolList(it.magicSchools, listOfMagicSchools, magicSchoolDao)
                categoryDataService.checkAndSetMonsterList(it.monsters, listOfMonsters, monsterDao)
                categoryDataService.checkAndSetProficiencyList(it.proficiencies, listOfProficiencies, proficiencyDao)
                categoryDataService.checkAndSetRaceList(it.races, listOfRaces, raceDao)
                categoryDataService.checkAndSetRuleList(it.rules, listOfRules, ruleDao)
                categoryDataService.checkAndSetRuleSectionList(it.ruleSections, listOfRuleSections, ruleSectionDao)
                categoryDataService.checkAndSetSkillList(it.skills, listOfSkills, skillDao)
                categoryDataService.checkAndSetSpellList(it.spells, listOfSpells, spellDao)
                categoryDataService.checkAndSetSubclassList(it.subclasses, listOfSubclasses, subclassDao)
                categoryDataService.checkAndSetSubraceList(it.subraces, listOfSubraces, subraceDao)
                categoryDataService.checkAndSetTraitList(it.traits, listOfTraits, traitDao)
                categoryDataService.checkAndSetWeaponPropertyList(it.weaponProperties, listOfWeaponProperties, weaponPropertyDao)

                delay(5000)
                setLoading(false)
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }
}

class MainVMFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(application)
    }
}