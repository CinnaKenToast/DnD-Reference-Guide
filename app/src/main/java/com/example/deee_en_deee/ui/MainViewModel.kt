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
import com.example.deee_en_deee.useCase.CategoryFetcherUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val categoryFetcherUseCase = CategoryFetcherUseCase()
    val isLoading = mutableStateOf(true)

    val alignmentDao = MainDatabase.getInstance(application.applicationContext).alignmentDao()
    val classDao = MainDatabase.getInstance(application.applicationContext).classDao()
    val conditionDao = MainDatabase.getInstance(application.applicationContext).conditionDao()
    val damageTypeDao = MainDatabase.getInstance(application.applicationContext).damageTypeDao()
    val equipmentCategoryDao = MainDatabase.getInstance(application.applicationContext).equipmentCategoryDao()
    val equipmentDao = MainDatabase.getInstance(application.applicationContext).equipmentDao()
    val featDao = MainDatabase.getInstance(application.applicationContext).featDao()
    val featureDao = MainDatabase.getInstance(application.applicationContext).featureDao()
    val languageDao = MainDatabase.getInstance(application.applicationContext).languageDao()
    val magicItemDao = MainDatabase.getInstance(application.applicationContext).magicItemDao()
    val magicSchoolDao = MainDatabase.getInstance(application.applicationContext).magicSchoolDao()
    val monsterDao = MainDatabase.getInstance(application.applicationContext).monsterDao()
    val proficiencyDao = MainDatabase.getInstance(application.applicationContext).proficiencyDao()
    val raceDao = MainDatabase.getInstance(application.applicationContext).raceDao()
    val ruleDao = MainDatabase.getInstance(application.applicationContext).ruleDao()
    val ruleSectionDao = MainDatabase.getInstance(application.applicationContext).ruleSectionDao()
    val skillDao = MainDatabase.getInstance(application.applicationContext).skillDao()
    val spellDao = MainDatabase.getInstance(application.applicationContext).spellDao()
    val subclassDao = MainDatabase.getInstance(application.applicationContext).subclassDao()
    val subraceDao = MainDatabase.getInstance(application.applicationContext).subraceDao()
    val traitDao = MainDatabase.getInstance(application.applicationContext).traitDao()
    val weaponPropertyDao = MainDatabase.getInstance(application.applicationContext).weaponPropertyDao()

    val listOfCategory = mutableStateOf(InitialReferences())

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

    init {
        viewModelScope.launch {
            categoryFetcherUseCase.getCategoryList(listOfCategory)
        }
    }

    private fun setLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }

    private suspend fun isAlignmentEmpty(): Boolean {
        return alignmentDao.tableIsEmpty()
    }

    fun getAlignmentType(index: String): AlignmentType {
        val alignmentType: AlignmentType
        runBlocking {
            setLoading(true)
            alignmentType = alignmentDao.getAlignment(index)
            setLoading(false)
        }
        return alignmentType
    }

    fun getAlignmentList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isAlignmentEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getAlignmentList(listOfCategory.value.alignments, listOfAlignments, alignmentDao)
            setLoading(false)
        }
    }

    private suspend fun isClassEmpty(): Boolean {
        return classDao.tableIsEmpty()
    }

    fun getClassType(index: String): ClassType {
        val classType: ClassType
        runBlocking {
            setLoading(true)
            classType = classDao.getClass(index)
            setLoading(false)
        }
        return classType
    }

    fun getClassList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isClassEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getClassList(listOfCategory.value.classes, listOfClasses, classDao)
            setLoading(false)
        }
    }

    private suspend fun isConditionEmpty(): Boolean {
        return conditionDao.tableIsEmpty()
    }

    fun getCondition(index: String): Condition {
        val condition: Condition
        runBlocking {
            setLoading(true)
            condition = conditionDao.getCondition(index)
            setLoading(false)
        }
        return condition
    }

    fun getConditionList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isConditionEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getConditionsList(listOfCategory.value.conditions, listOfConditions, conditionDao)
            setLoading(false)
        }
    }

    private suspend fun isDamageTypeEmpty(): Boolean {
        return damageTypeDao.tableIsEmpty()
    }

    fun getDamageType(index: String): DamageType {
        val damageType: DamageType
        runBlocking {
            setLoading(true)
            damageType = damageTypeDao.getDamageType(index)
            setLoading(false)
        }
        return damageType
    }

    fun getDamageTypeList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isDamageTypeEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getDamageTypeList(listOfCategory.value.damageTypes, listOfDamageTypes, damageTypeDao)
            setLoading(false)
        }
    }

    private suspend fun isEquipmentCategoryEmpty(): Boolean {
        return equipmentCategoryDao.tableIsEmpty()
    }

    fun getEquipmentCategory(index: String): EquipmentCategory {
        val equipmentCategory: EquipmentCategory
        runBlocking {
            setLoading(true)
            equipmentCategory = equipmentCategoryDao.getEquipmentCategory(index)
            setLoading(false)
        }
        return equipmentCategory
    }

    fun getEquipmentCategoryList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isEquipmentCategoryEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getEquipmentCategoryList(listOfCategory.value.equipmentCategory, listOfEquipmentCategories, equipmentCategoryDao)
            setLoading(false)
        }
    }

    private suspend fun isEquipmentEmpty(): Boolean {
        return equipmentDao.tableIsEmpty()
    }

    fun getEquipment(index: String): Equipment {
        val equipment: Equipment
        runBlocking {
            setLoading(true)
            equipment = equipmentDao.getEquipment(index)
            setLoading(false)
        }
        return equipment
    }

    fun getEquipmentList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isEquipmentEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getEquipmentList(listOfCategory.value.equipment, listOfEquipments, equipmentDao)
            setLoading(false)
        }
    }

    private suspend fun isFeatEmpty(): Boolean {
        return featDao.tableIsEmpty()
    }

    fun getFeat(index: String): Feat {
        val feat: Feat
        runBlocking {
            setLoading(true)
            feat = featDao.getFeat(index)
            setLoading(false)
        }
        return feat
    }


    fun getFeatList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isFeatEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getFeatList(listOfCategory.value.feats, listOfFeats, featDao)
            setLoading(false)
        }
    }

    private suspend fun isFeatureEmpty(): Boolean {
        return featureDao.tableIsEmpty()
    }

    fun getFeature(index: String): Feature {
        val feature: Feature
        runBlocking {
            setLoading(true)
            feature = featureDao.getFeature(index)
            setLoading(false)
        }
        return feature
    }

    fun getFeatureList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isFeatureEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getFeatureList(listOfCategory.value.features, listOfFeatures, featureDao)
            setLoading(false)
        }
    }

    private suspend fun isLanguageEmpty(): Boolean {
        return languageDao.tableIsEmpty()
    }

    fun getLanguage(index: String): Language {
        val language: Language
        runBlocking {
            setLoading(true)
            language = languageDao.getLanguage(index)
            setLoading(false)
        }
        return language
    }

    fun getLanguageList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isLanguageEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getLanguageList(listOfCategory.value.languages, listOfLanguages, languageDao)
            setLoading(false)
        }
    }

    private suspend fun isMagicItemEmpty(): Boolean {
        return magicItemDao.tableIsEmpty()
    }

    fun getMagicItem(index: String): MagicItem {
        val magicItem: MagicItem
        runBlocking {
            setLoading(true)
            magicItem = magicItemDao.getMagicItem(index)
            setLoading(false)
        }
        return magicItem
    }

    fun getMagicItemList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isMagicItemEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getMagicItemList(listOfCategory.value.magicItems, listOfMagicItems, magicItemDao)
            setLoading(false)
        }
    }

    private suspend fun isMagicSchoolEmpty(): Boolean {
        return magicSchoolDao.tableIsEmpty()
    }

    fun getMagicSchool(index: String): MagicSchool {
        val magicSchool: MagicSchool
        runBlocking {
            setLoading(true)
            magicSchool = magicSchoolDao.getMagicSchool(index)
            setLoading(false)
        }
        return magicSchool
    }

    fun getMagicSchoolList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isMagicSchoolEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getMagicSchoolList(listOfCategory.value.magicSchools, listOfMagicSchools, magicSchoolDao)
            setLoading(false)
        }
    }

    private suspend fun isMonsterEmpty(): Boolean {
        return monsterDao.tableIsEmpty()
    }

    fun getMonster(index: String): Monster {
        val monster: Monster
        runBlocking {
            setLoading(true)
            monster = monsterDao.getMonster(index)
            setLoading(false)
        }
        return monster
    }

    fun getMonsterList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isMonsterEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getMonsterList(listOfCategory.value.monsters, listOfMonsters, monsterDao)
            setLoading(false)
        }
    }

    private suspend fun isProficiencyEmpty(): Boolean {
        return proficiencyDao.tableIsEmpty()
    }

    fun getProficiency(index: String): Proficiency {
        val proficiency: Proficiency
        runBlocking {
            setLoading(true)
            proficiency = proficiencyDao.getProficiency(index)
            setLoading(false)
        }
        return proficiency
    }

    fun getProficiencyList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isProficiencyEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getProficiencyList(listOfCategory.value.abilityScore, listOfProficiencies, proficiencyDao)
            setLoading(false)
        }
    }

    private suspend fun isRaceEmpty(): Boolean {
        return raceDao.tableIsEmpty()
    }

    fun getRace(index: String): Race {
        val race: Race
        runBlocking {
            setLoading(true)
            race = raceDao.getRace(index)
            setLoading(false)
        }
        return race
    }

    fun getRaceList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isRaceEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getRaceList(listOfCategory.value.races, listOfRaces, raceDao)
            setLoading(false)
        }
    }

    private suspend fun isRuleEmpty(): Boolean {
        return ruleDao.tableIsEmpty()
    }

    fun getRule(index: String): Rule {
        val rule: Rule
        runBlocking {
            setLoading(true)
            rule = ruleDao.getRule(index)
            setLoading(false)
        }
        return rule
    }

    fun getRuleList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isRuleEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getRuleList(listOfCategory.value.rules, listOfRules, ruleDao)
            setLoading(false)
        }
    }

    private suspend fun isRuleSectionEmpty(): Boolean {
        return ruleSectionDao.tableIsEmpty()
    }

    fun getRuleSection(index: String): RuleSection {
        val ruleSection: RuleSection
        runBlocking {
            setLoading(true)
            ruleSection = ruleSectionDao.getRuleSection(index)
            setLoading(false)
        }
        return ruleSection
    }

    fun getRuleSectionList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isRuleSectionEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getRuleSectionList(listOfCategory.value.ruleSections, listOfRuleSections, ruleSectionDao)
            setLoading(false)
        }
    }

    private suspend fun isSkillEmpty(): Boolean {
        return skillDao.tableIsEmpty()
    }

    fun getSkill(index: String): Skill {
        val skill: Skill
        runBlocking {
            setLoading(true)
            skill = skillDao.getSkill(index)
            setLoading(false)
        }
        return skill
    }

    fun getSkillList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isSkillEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getSkillList(listOfCategory.value.skills, listOfSkills, skillDao)
            setLoading(false)
        }
    }

    private suspend fun isSpellsEmpty(): Boolean {
        return spellDao.tableIsEmpty()
    }

    fun getSpell(index: String): Spell {
        val spell: Spell
        runBlocking {
            setLoading(true)
            spell = spellDao.getSpell(index)
            setLoading(false)
        }
        return spell
    }

    fun getSpellList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isSpellsEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getSpellList(listOfCategory.value.spells, listOfSpells, spellDao)
            setLoading(false)
        }
    }

    private suspend fun isSubclassEmpty(): Boolean {
        return subclassDao.tableIsEmpty()
    }

    fun getSubclass(index: String): Subclass {
        val subclass: Subclass
        runBlocking {
            setLoading(true)
            subclass = subclassDao.getSubclass(index)
            setLoading(false)
        }
        return subclass
    }

    fun getSubclassList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isSubclassEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getSubclassList(listOfCategory.value.subclasses, listOfSubclasses, subclassDao)
            setLoading(false)
        }
    }

    private suspend fun isSubraceEmpty(): Boolean {
        return subraceDao.tableIsEmpty()
    }

    fun getSubrace(index: String): Subrace {
        val subrace: Subrace
        runBlocking {
            setLoading(true)
            subrace = subraceDao.getSubrace(index)
            setLoading(false)
        }
        return subrace
    }

    fun getSubraceList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isSubraceEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getSubraceList(listOfCategory.value.subraces, listOfSubraces, subraceDao)
            setLoading(false)
        }
    }

    private suspend fun isTraitEmpty(): Boolean {
        return traitDao.tableIsEmpty()
    }

    fun getTrait(index: String): Trait {
        val trait: Trait
        runBlocking {
            setLoading(true)
            trait = traitDao.getTrait(index)
            setLoading(false)
        }
        return trait
    }

    fun getTraitList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isTraitEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getTraitList(listOfCategory.value.traits, listOfTraits, traitDao)
            setLoading(false)
        }
    }

    private suspend fun isWeaponPropertyEmpty(): Boolean {
        return weaponPropertyDao.tableIsEmpty()
    }

    fun getWeaponProperty(index: String): WeaponProperty {
        val weaponProperty: WeaponProperty
        runBlocking {
            setLoading(true)
            weaponProperty = weaponPropertyDao.getWeaponProperty(index)
            setLoading(false)
        }
        return weaponProperty
    }

    fun getWeaponPropertyList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isWeaponPropertyEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getWeaponProperty(listOfCategory.value.weaponProperties, listOfWeaponProperties, weaponPropertyDao)
            setLoading(false)
        }
    }
}

class MainViewModelFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(application)
    }
}