package com.example.deee_en_deee.useCase

import androidx.compose.runtime.MutableState
import com.example.deee_en_deee.database.*
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.services.CategoryDataServiceRepository

class CategoryFetcherUseCase(private val categoryDataService: CategoryDataServiceRepository) {

    suspend fun getCategoryList(categoryList: MutableState<InitialReferences>) {
        categoryList.value = categoryDataService.getCategories().getOrThrow()
    }

    suspend fun getAbilityScoreList(url: String, abilityScoreList: MutableState<List<AbilityScore>>, abilityScoreDao: AbilityScoreDao) {
        categoryDataService.checkAndSetAbilityScoreList(url, abilityScoreList, abilityScoreDao)
    }

    suspend fun getAlignmentList(url: String, alignmentList: MutableState<List<AlignmentType>>, alignmentDao: AlignmentDao) {
        categoryDataService.checkAndSetAlignmentList(url, alignmentList, alignmentDao)
    }

    suspend fun getClassList(url: String, classList: MutableState<List<ClassType>>, classDao: ClassDao) {
        categoryDataService.checkAndSetClassList(url, classList, classDao)
    }

    suspend fun getConditionsList(url: String, conditionList: MutableState<List<Condition>>, conditionDao: ConditionDao) {
        categoryDataService.checkAndSetConditionList(url, conditionList, conditionDao)
    }

    suspend fun getDamageTypeList(url: String, damageTypeList: MutableState<List<DamageType>>, damageTypeDao: DamageTypeDao) {
        categoryDataService.checkAndSetDamageTypeList(url, damageTypeList, damageTypeDao)
    }

    suspend fun getEquipmentCategoryList(url: String, equipmentCategoryList: MutableState<List<EquipmentCategory>>, equipmentCategoryDao: EquipmentCategoryDao) {
        categoryDataService.checkAndSetEquipmentCategoryList(url, equipmentCategoryList, equipmentCategoryDao)
    }

    suspend fun getEquipmentList(url: String, equipmentList: MutableState<List<Equipment>>, equipmentDao: EquipmentDao) {
        categoryDataService.checkAndSetEquipmentList(url, equipmentList, equipmentDao)
    }

    suspend fun getFeatList(url: String, featList: MutableState<List<Feat>>, featDao: FeatDao) {
        categoryDataService.checkAndSetFeatList(url, featList, featDao)
    }

    suspend fun getFeatureList(url: String, featureList: MutableState<List<Feature>>, featureDao: FeatureDao) {
        categoryDataService.checkAndSetFeatureList(url, featureList, featureDao)
    }

    suspend fun getLanguageList(url: String, languageList: MutableState<List<Language>>, languageDao: LanguageDao) {
        categoryDataService.checkAndSetLanguageList(url, languageList, languageDao)
    }

    suspend fun getMagicItemList(url: String, magicItemList: MutableState<List<MagicItem>>, magicItemDao: MagicItemDao) {
        categoryDataService.checkAndSetMagicItemList(url, magicItemList, magicItemDao)
    }

    suspend fun getMagicSchoolList(url: String, magicSchoolList: MutableState<List<MagicSchool>>, magicSchoolDao: MagicSchoolDao) {
        categoryDataService.checkAndSetMagicSchoolList(url, magicSchoolList, magicSchoolDao)
    }

    suspend fun getMonsterList(url: String, monsterList: MutableState<List<Monster>>, monsterDao: MonsterDao) {
        categoryDataService.checkAndSetMonsterList(url, monsterList, monsterDao)
    }

    suspend fun getProficiencyList(url: String, proficiencyList: MutableState<List<Proficiency>>, proficiencyDao: ProficiencyDao) {
        categoryDataService.checkAndSetProficiencyList(url, proficiencyList, proficiencyDao)
    }

    suspend fun getRaceList(url: String, raceList: MutableState<List<Race>>, raceDao: RaceDao) {
        categoryDataService.checkAndSetRaceList(url, raceList, raceDao)
    }

    suspend fun getRuleList(url: String, ruleList: MutableState<List<Rule>>, ruleDao: RuleDao) {
        categoryDataService.checkAndSetRuleList(url, ruleList, ruleDao)
    }

    suspend fun getRuleSectionList(url: String, ruleSectionList: MutableState<List<RuleSection>>, ruleSectionDao: RuleSectionDao) {
        categoryDataService.checkAndSetRuleSectionList(url, ruleSectionList, ruleSectionDao)
    }

    suspend fun getSkillList(url: String, skillList: MutableState<List<Skill>>, skillDao: SkillDao) {
        categoryDataService.checkAndSetSkillList(url, skillList, skillDao)
    }

    suspend fun getSpellList(url: String, spellList: MutableState<List<Spell>>, spellDao: SpellDao) {
        categoryDataService.checkAndSetSpellList(url, spellList, spellDao)
    }

    suspend fun getSubclassList(url: String, subclassList: MutableState<List<Subclass>>, subclassDao: SubclassDao) {
        categoryDataService.checkAndSetSubclassList(url, subclassList, subclassDao)
    }

    suspend fun getSubraceList(url: String, subraceList: MutableState<List<Subrace>>, subraceDao: SubraceDao) {
        categoryDataService.checkAndSetSubraceList(url, subraceList, subraceDao)
    }

    suspend fun getTraitList(url: String, traitList: MutableState<List<Trait>>, traitDao: TraitDao) {
        categoryDataService.checkAndSetTraitList(url, traitList, traitDao)
    }

    suspend fun getWeaponProperty(url: String, weaponPropertyList: MutableState<List<WeaponProperty>>, weaponPropertyDao: WeaponPropertyDao) {
        categoryDataService.checkAndSetWeaponPropertyList(url, weaponPropertyList, weaponPropertyDao)
    }
}