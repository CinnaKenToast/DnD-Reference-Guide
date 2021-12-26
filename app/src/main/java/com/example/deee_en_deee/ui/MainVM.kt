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

    val listOfCategory = mutableStateOf(InitialReferences())

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

//    val loadedCategories = mutableStateOf(0)
//    val downloadingCategoryTitle = mutableStateOf("")

    init {
        viewModelScope.launch {
            listOfCategory.value = categoryDataService.getCategories().getOrThrow()
//            categoryDataService.getCategories().onSuccess { it ->
//                setLoading(true)
//
//                categoryDataService.checkAndSetAbilityScoreList(it.abilityScore, listOfAbilityScores, abilityScoreDao)
//                categoryDataService.checkAndSetAlignmentList(it.alignments, listOfAlignments, alignmentDao)
//                categoryDataService.checkAndSetClassList(it.classes, listOfClasses, classDao)
//                categoryDataService.checkAndSetConditionList(it.conditions, listOfConditions, conditionDao)
//                categoryDataService.checkAndSetDamageTypeList(it.damageTypes, listOfDamageTypes, damageTypeDao)
//                categoryDataService.checkAndSetEquipmentCategoryList(it.equipmentCategory, listOfEquipmentCategories, equipmentCategoryDao)
//                categoryDataService.checkAndSetEquipmentList(it.equipment, listOfEquipments, equipmentDao)
//                categoryDataService.checkAndSetFeatList(it.feats, listOfFeats, featDao)
//                categoryDataService.checkAndSetFeatureList(it.features, listOfFeatures, featureDao)
//                categoryDataService.checkAndSetLanguageList(it.languages, listOfLanguages, languageDao)
//                categoryDataService.checkAndSetMagicItemList(it.magicItems, listOfMagicItems, magicItemDao)
//                categoryDataService.checkAndSetMagicSchoolList(it.magicSchools, listOfMagicSchools, magicSchoolDao)
//                categoryDataService.checkAndSetMonsterList(it.monsters, listOfMonsters, monsterDao)
//                categoryDataService.checkAndSetProficiencyList(it.proficiencies, listOfProficiencies, proficiencyDao)
//                categoryDataService.checkAndSetRaceList(it.races, listOfRaces, raceDao)
//                categoryDataService.checkAndSetRuleList(it.rules, listOfRules, ruleDao)
//                categoryDataService.checkAndSetRuleSectionList(it.ruleSections, listOfRuleSections, ruleSectionDao)
//                categoryDataService.checkAndSetSkillList(it.skills, listOfSkills, skillDao)
//                categoryDataService.checkAndSetSpellList(it.spells, listOfSpells, spellDao)
//                categoryDataService.checkAndSetSubclassList(it.subclasses, listOfSubclasses, subclassDao)
//                categoryDataService.checkAndSetSubraceList(it.subraces, listOfSubraces, subraceDao)
//                categoryDataService.checkAndSetTraitList(it.traits, listOfTraits, traitDao)
//                categoryDataService.checkAndSetWeaponPropertyList(it.weaponProperties, listOfWeaponProperties, weaponPropertyDao)
//
//                setLoading(false)
//            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }

    private suspend fun isAbilityScoreEmpty(): Boolean {
        return abilityScoreDao.tableIsEmpty()
    }

    fun getAbilityScoreList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isAbilityScoreEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetAbilityScoreList(listOfCategory.value.abilityScore, listOfAbilityScores, abilityScoreDao)
                setLoading(false)
        }
    }

    private suspend fun isAlignmentEmpty(): Boolean {
        return alignmentDao.tableIsEmpty()
    }

    fun getAlignmentList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isAlignmentEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetAlignmentList(listOfCategory.value.alignments, listOfAlignments, alignmentDao)
                setLoading(false)
        }
    }

    private suspend fun isClassEmpty(): Boolean {
        return classDao.tableIsEmpty()
    }

    fun getClassList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isClassEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetClassList(listOfCategory.value.classes, listOfClasses, classDao)
                setLoading(false)
        }
    }

    private suspend fun isConditionEmpty(): Boolean {
        return conditionDao.tableIsEmpty()
    }

    fun getConditionList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isConditionEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetConditionList(listOfCategory.value.conditions, listOfConditions, conditionDao)
                setLoading(false)
        }
    }

    private suspend fun isDamageTypeEmpty(): Boolean {
        return damageTypeDao.tableIsEmpty()
    }

    fun getDamageTypeList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isDamageTypeEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetDamageTypeList(listOfCategory.value.damageTypes, listOfDamageTypes, damageTypeDao)
                setLoading(false)
        }
    }

    private suspend fun isEquipmentCategoryEmpty(): Boolean {
        return equipmentCategoryDao.tableIsEmpty()
    }

    fun getEquipmentCategoryList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isEquipmentCategoryEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetEquipmentCategoryList(listOfCategory.value.equipmentCategory, listOfEquipmentCategories, equipmentCategoryDao)
                setLoading(false)
        }
    }

    private suspend fun isEquipmentEmpty(): Boolean {
        return equipmentDao.tableIsEmpty()
    }

    fun getEquipmentList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isEquipmentEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetEquipmentList(listOfCategory.value.equipment, listOfEquipments, equipmentDao)
                setLoading(false)
        }
    }

    private suspend fun isFeatEmpty(): Boolean {
        return featDao.tableIsEmpty()
    }

    fun getFeatList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isFeatEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetFeatList(listOfCategory.value.feats, listOfFeats, featDao)
                setLoading(false)
        }
    }

    private suspend fun isFeatureEmpty(): Boolean {
        return featureDao.tableIsEmpty()
    }

    fun getFeatureList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isFeatureEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetFeatureList(listOfCategory.value.features, listOfFeatures, featureDao)
                setLoading(false)
        }
    }

    private suspend fun isLanguageEmpty(): Boolean {
        return languageDao.tableIsEmpty()
    }

    fun getLanguageList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isLanguageEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetLanguageList(listOfCategory.value.languages, listOfLanguages, languageDao)
                setLoading(false)
        }
    }

    private suspend fun isMagicItemEmpty(): Boolean {
        return magicItemDao.tableIsEmpty()
    }

    fun getMagicItemList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isMagicItemEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetMagicItemList(listOfCategory.value.magicItems, listOfMagicItems, magicItemDao)
                setLoading(false)
        }
    }

    private suspend fun isMagicSchoolEmpty(): Boolean {
        return magicSchoolDao.tableIsEmpty()
    }

    fun getMagicSchoolList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isMagicSchoolEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetMagicSchoolList(listOfCategory.value.magicSchools, listOfMagicSchools, magicSchoolDao)
                setLoading(false)
        }
    }

    private suspend fun isMonsterEmpty(): Boolean {
        return monsterDao.tableIsEmpty()
    }

    fun getMonsterList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isMonsterEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetMonsterList(listOfCategory.value.monsters, listOfMonsters, monsterDao)
                setLoading(false)
        }
    }

    private suspend fun isProficiencyEmpty(): Boolean {
        return proficiencyDao.tableIsEmpty()
    }

    fun getProficiencyList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isProficiencyEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetProficiencyList(listOfCategory.value.abilityScore, listOfProficiencies, proficiencyDao)
                setLoading(false)
        }
    }

    private suspend fun isRaceEmpty(): Boolean {
        return raceDao.tableIsEmpty()
    }

    fun getRaceList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isRaceEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetRaceList(listOfCategory.value.races, listOfRaces, raceDao)
                setLoading(false)
        }
    }

    private suspend fun isRuleEmpty(): Boolean {
        return ruleDao.tableIsEmpty()
    }

    fun getRuleList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isRuleEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetRuleList(listOfCategory.value.rules, listOfRules, ruleDao)
                setLoading(false)
        }
    }

    private suspend fun isRuleSectionEmpty(): Boolean {
        return ruleSectionDao.tableIsEmpty()
    }

    fun getRuleSectionList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isRuleSectionEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetRuleSectionList(listOfCategory.value.ruleSections, listOfRuleSections, ruleSectionDao)
                setLoading(false)
        }
    }

    private suspend fun isSkillEmpty(): Boolean {
        return skillDao.tableIsEmpty()
    }

    fun getSkillList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isSkillEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetSkillList(listOfCategory.value.skills, listOfSkills, skillDao)
                setLoading(false)
        }
    }

    private suspend fun isSpellsEmpty(): Boolean {
        return spellDao.tableIsEmpty()
    }

    fun getSpellList() {
        viewModelScope.launch {
                setLoading(true)
                categoryDataService.checkAndSetSpellList(listOfCategory.value.spells, listOfSpells, spellDao)
                setLoading(false)
        }
    }

    private suspend fun isSubclassEmpty(): Boolean {
        return subclassDao.tableIsEmpty()
    }

    fun getSubclassList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isSubclassEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetSubclassList(listOfCategory.value.subclasses, listOfSubclasses, subclassDao)
                setLoading(false)
        }
    }

    private suspend fun isSubraceEmpty(): Boolean {
        return subraceDao.tableIsEmpty()
    }

    fun getSubraceList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isSubraceEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetSubraceList(listOfCategory.value.subraces, listOfSubraces, subraceDao)
                setLoading(false)
        }
    }

    private suspend fun isTraitEmpty(): Boolean {
        return traitDao.tableIsEmpty()
    }

    fun getTraitList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isTraitEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetTraitList(listOfCategory.value.traits, listOfTraits, traitDao)
                setLoading(false)
        }
    }

    private suspend fun isWeaponPropertyEmpty(): Boolean {
        return weaponPropertyDao.tableIsEmpty()
    }

    fun getWeaponPropertyList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isWeaponPropertyEmpty()}")
                setLoading(true)
                categoryDataService.checkAndSetWeaponPropertyList(listOfCategory.value.weaponProperties, listOfWeaponProperties, weaponPropertyDao)
                setLoading(false)
        }
    }
}

class MainVMFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(application)
    }
}