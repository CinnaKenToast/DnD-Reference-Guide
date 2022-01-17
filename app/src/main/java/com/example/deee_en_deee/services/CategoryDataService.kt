package com.example.deee_en_deee.services

import androidx.compose.runtime.MutableState
import com.example.deee_en_deee.database.*
import com.example.deee_en_deee.infoTypes.*

interface CategoryDataService {
    suspend fun getCategories(): Result<InitialReferences>
    suspend fun checkAndSetAbilityScoreList(url: String, abilityScoreList: MutableState<List<AbilityScore>>, abilityScoreDao: AbilityScoreDao)
    suspend fun checkAndSetAlignmentList(url: String, alignmentList: MutableState<List<AlignmentType>>, alignmentDao: AlignmentDao)
    suspend fun checkAndSetClassList(url: String, classList: MutableState<List<ClassType>>, classDao: ClassDao)
    suspend fun checkAndSetConditionList(url: String, conditionList: MutableState<List<Condition>>, conditionDao: ConditionDao)
    suspend fun checkAndSetDamageTypeList(url: String, damageTypeList: MutableState<List<DamageType>>, damageTypeDao: DamageTypeDao)
    suspend fun checkAndSetEquipmentCategoryList(url: String, equipmentCategoryList: MutableState<List<EquipmentCategory>>, equipmentCategoryDao: EquipmentCategoryDao)
    suspend fun checkAndSetEquipmentList(url: String, equipmentList: MutableState<List<Equipment>>, equipmentDao: EquipmentDao)
    suspend fun checkAndSetFeatList(url: String, featList: MutableState<List<Feat>>, featDao: FeatDao)
    suspend fun checkAndSetFeatureList(url: String, featureList: MutableState<List<Feature>>, featureDao: FeatureDao)
    suspend fun checkAndSetLanguageList(url: String, languageList: MutableState<List<Language>>, languageDao: LanguageDao)
    suspend fun checkAndSetMagicItemList(url: String, magicItemList: MutableState<List<MagicItem>>, magicItemDao: MagicItemDao)
    suspend fun checkAndSetMagicSchoolList(url: String, magicSchoolList: MutableState<List<MagicSchool>>, magicSchoolDao: MagicSchoolDao)
    suspend fun checkAndSetMonsterList(url: String, monsterList: MutableState<List<Monster>>, monsterDao: MonsterDao)
    suspend fun checkAndSetProficiencyList(url: String, proficiencyList: MutableState<List<Proficiency>>, proficiencyDao: ProficiencyDao)
    suspend fun checkAndSetRaceList(url: String, raceList: MutableState<List<Race>>, raceDao: RaceDao)
    suspend fun checkAndSetRuleList(url: String, ruleList: MutableState<List<Rule>>, ruleDao: RuleDao)
    suspend fun checkAndSetRuleSectionList(url: String, ruleSectionList: MutableState<List<RuleSection>>, ruleSectionDao: RuleSectionDao)
    suspend fun checkAndSetSkillList(url: String, skillList: MutableState<List<Skill>>, skillDao: SkillDao)
    suspend fun checkAndSetSpellList(url: String, spellList: MutableState<List<Spell>>, spellDao: SpellDao)
    suspend fun checkAndSetSubclassList(url: String, subclassList: MutableState<List<Subclass>>, subclassDao: SubclassDao)
    suspend fun checkAndSetSubraceList(url: String, subraceList: MutableState<List<Subrace>>, subraceDao: SubraceDao)
    suspend fun checkAndSetTraitList(url: String, traitList: MutableState<List<Trait>>, traitDao: TraitDao)
    suspend fun checkAndSetWeaponPropertyList(url: String, weaponPropertyList: MutableState<List<WeaponProperty>>, weaponPropertyDao: WeaponPropertyDao)
}