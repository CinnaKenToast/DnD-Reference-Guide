package com.example.deee_en_deee.services

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.deee_en_deee.database.*
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.ui.components.capitalize

class CategoryDataServiceRepository: CategoryDataService {
    private val getter = APIGetter()

    override suspend fun checkAndSetAbilityScoreList(url: String, abilityScoreList: MutableState<List<AbilityScore>>, abilityScoreDao: AbilityScoreDao) {
        Log.d("debug2", "CHECKING ABILITY SCORE")
        if (abilityScoreList.value.isEmpty()) {
            abilityScoreList.value = abilityScoreDao.getListOfAbilityScores()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ABILITY SCORE WAS EMPTY")

            if (abilityScoreList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                abilityScoreList.value = getAbilityScores(url).getOrThrow()

                abilityScoreList.value.forEach { abilityScore ->
                    abilityScoreDao.insert(abilityScore)
                }
            }
        }
    }

    override suspend fun checkAndSetAlignmentList(url: String, alignmentList: MutableState<List<AlignmentType>>, alignmentDao: AlignmentDao) {
        if (alignmentList.value.isEmpty()) {
            alignmentList.value = alignmentDao.getListOfAlignments()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (alignmentList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                alignmentList.value = getAlignments(url).getOrThrow()

                alignmentList.value.forEach { alignment ->
                    alignmentDao.insert(alignment)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetClassList(url: String, classList: MutableState<List<ClassType>>, classDao: ClassDao) {
        if (classList.value.isEmpty()) {
            classList.value = classDao.getListOfClasses()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (classList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                classList.value = getClasses(url).getOrThrow()

                classList.value.forEach { classType ->
                    classDao.insert(classType)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetConditionList(url: String, conditionList: MutableState<List<Condition>>, conditionDao: ConditionDao) {
        if (conditionList.value.isEmpty()) {
            conditionList.value = conditionDao.getListOfConditions()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (conditionList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                conditionList.value = getConditions(url).getOrThrow()

                conditionList.value.forEach { condition ->
                    conditionDao.insert(condition)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetDamageTypeList(url: String, damageTypeList: MutableState<List<DamageType>>, damageTypeDao: DamageTypeDao) {
        if (damageTypeList.value.isEmpty()) {
            damageTypeList.value = damageTypeDao.getListOfDamageTypes()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (damageTypeList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                damageTypeList.value = getDamageTypes(url).getOrThrow()

                damageTypeList.value.forEach { damageType ->
                    damageTypeDao.insert(damageType)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetEquipmentCategoryList(url: String, equipmentCategoryList: MutableState<List<EquipmentCategory>>, equipmentCategoryDao: EquipmentCategoryDao) {
        if (equipmentCategoryList.value.isEmpty()) {
            equipmentCategoryList.value = equipmentCategoryDao.getListOfEquipmentCategories()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (equipmentCategoryList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                equipmentCategoryList.value = getEquipmentCategories(url).getOrThrow()

                equipmentCategoryList.value.forEach { equipmentCategory ->
                    equipmentCategoryDao.insert(equipmentCategory)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetEquipmentList(url: String, equipmentList: MutableState<List<Equipment>>, equipmentDao: EquipmentDao) {
        if (equipmentList.value.isEmpty()) {
            equipmentList.value = equipmentDao.getListOfEquipments()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (equipmentList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                equipmentList.value = getEquipments(url).getOrThrow()

                equipmentList.value.forEach { equipment ->
                    equipmentDao.insert(equipment)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetFeatList(url: String, featList: MutableState<List<Feat>>, featDao: FeatDao) {
        if (featList.value.isEmpty()) {
            featList.value = featDao.getListOfFeats()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (featList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                featList.value = getFeats(url).getOrThrow()

                featList.value.forEach { feat ->
                    featDao.insert(feat)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetFeatureList(url: String, featureList: MutableState<List<Feature>>, featureDao: FeatureDao) {
        if (featureList.value.isEmpty()) {
            featureList.value = featureDao.getListOfFeatures()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (featureList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                featureList.value = getFeatures(url).getOrThrow()

                featureList.value.forEach { feature ->
                    featureDao.insert(feature)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetLanguageList(url: String, languageList: MutableState<List<Language>>, languageDao: LanguageDao) {
        if (languageList.value.isEmpty()) {
            languageList.value = languageDao.getListOfLanguages()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (languageList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                languageList.value = getLanguages(url).getOrThrow()

                languageList.value.forEach { language ->
                    languageDao.insert(language)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetMagicItemList(url: String, magicItemList: MutableState<List<MagicItem>>, magicItemDao: MagicItemDao) {
        if (magicItemList.value.isEmpty()) {
            magicItemList.value = magicItemDao.getListOfMagicItems()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (magicItemList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                magicItemList.value = getMagicItems(url).getOrThrow()

                magicItemList.value.forEach { magicItem ->
                    magicItemDao.insert(magicItem)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetMagicSchoolList(url: String, magicSchoolList: MutableState<List<MagicSchool>>, magicSchoolDao: MagicSchoolDao) {
        if (magicSchoolList.value.isEmpty()) {
            magicSchoolList.value = magicSchoolDao.getListOfMagicSchools()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (magicSchoolList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                magicSchoolList.value = getMagicSchool(url).getOrThrow()

                magicSchoolList.value.forEach { magicSchool ->
                    magicSchoolDao.insert(magicSchool)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetMonsterList(url: String, monsterList: MutableState<List<Monster>>, monsterDao: MonsterDao) {
        if (monsterList.value.isEmpty()) {
            monsterList.value = monsterDao.getListOfMonsters()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (monsterList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                monsterList.value = getMonsters(url).getOrThrow()

                monsterList.value.forEach { monster ->
                    monsterDao.insert(monster)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetProficiencyList(url: String, proficiencyList: MutableState<List<Proficiency>>, proficiencyDao: ProficiencyDao) {
        if (proficiencyList.value.isEmpty()) {
            proficiencyList.value = proficiencyDao.getListOfProficiencies()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (proficiencyList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                proficiencyList.value = getProficiencies(url).getOrThrow()

                proficiencyList.value.forEach { proficiency ->
                    proficiencyDao.insert(proficiency)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetRaceList(url: String, raceList: MutableState<List<Race>>, raceDao: RaceDao) {
        if (raceList.value.isEmpty()) {
            raceList.value = raceDao.getListOfRaces()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (raceList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                raceList.value = getRaces(url).getOrThrow()

                raceList.value.forEach { race ->
                    raceDao.insert(race)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetRuleList(url: String, ruleList: MutableState<List<Rule>>, ruleDao: RuleDao) {
        if (ruleList.value.isEmpty()) {
            ruleList.value = ruleDao.getListOfRules()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (ruleList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                ruleList.value = getRules(url).getOrThrow()

                ruleList.value.forEach { rule ->
                    ruleDao.insert(rule)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetRuleSectionList(url: String, ruleSectionList: MutableState<List<RuleSection>>, ruleSectionDao: RuleSectionDao) {
        if (ruleSectionList.value.isEmpty()) {
            ruleSectionList.value = ruleSectionDao.getListOfRuleSections()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (ruleSectionList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                ruleSectionList.value = getRuleSections(url).getOrThrow()

                ruleSectionList.value.forEach { ruleSection ->
                    ruleSectionDao.insert(ruleSection)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetSkillList(url: String, skillList: MutableState<List<Skill>>, skillDao: SkillDao) {
        if (skillList.value.isEmpty()) {
            skillList.value = skillDao.getListOfSkills()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (skillList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                skillList.value = getSkills(url).getOrThrow()

                skillList.value.forEach { skill ->
                    skillDao.insert(skill)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetSpellList(url: String, spellList: MutableState<List<Spell>>, spellDao: SpellDao) {
        if (spellList.value.isEmpty()) {
            spellList.value = spellDao.getListOfSpells()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (spellList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                spellList.value = getSpells(url).getOrThrow()

                spellList.value.forEach { spell ->
                    spellDao.insert(spell)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetSubclassList(url: String, subclassList: MutableState<List<Subclass>>, subclassDao: SubclassDao) {
        if (subclassList.value.isEmpty()) {
            subclassList.value = subclassDao.getListOfSubclasses()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (subclassList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                subclassList.value = getSubclasses(url).getOrThrow()

                subclassList.value.forEach { subclass ->
                    subclassDao.insert(subclass)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetSubraceList(url: String, subraceList: MutableState<List<Subrace>>, subraceDao: SubraceDao) {
        if (subraceList.value.isEmpty()) {
            subraceList.value = subraceDao.getListOfSubraces()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (subraceList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                subraceList.value = getSubraces(url).getOrThrow()

                subraceList.value.forEach { subrace ->
                    subraceDao.insert(subrace)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetTraitList(url: String, traitList: MutableState<List<Trait>>, traitDao: TraitDao) {
        if (traitList.value.isEmpty()) {
            traitList.value = traitDao.getListOfTraits()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (traitList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                traitList.value = getTraits(url).getOrThrow()

                traitList.value.forEach { trait ->
                    traitDao.insert(trait)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun checkAndSetWeaponPropertyList(url: String, weaponPropertyList: MutableState<List<WeaponProperty>>, weaponPropertyDao: WeaponPropertyDao) {
        if (weaponPropertyList.value.isEmpty()) {
            weaponPropertyList.value = weaponPropertyDao.getListOfWeaponProperties()?.toMutableList() ?: mutableListOf()

            Log.d("debug2", "ALIGNMENT WAS EMPTY")

            if (weaponPropertyList.value.isEmpty()) {
                Log.d("debug2", "DATABASE WAS EMPTY")
                weaponPropertyList.value = getWeaponProperties(url).getOrThrow()

                weaponPropertyList.value.forEach { weaponProperty ->
                    weaponPropertyDao.insert(weaponProperty)
                }
            } else {
                Log.d("debug2", "DATABASE WAS FULL")
            }
        } else {
            Log.d("debug2", "ALIGNMENT WAS FILLED")
        }
    }

    override suspend fun getCategories(): Result<InitialReferences> {
        getter.getInitialReferences().onSuccess { categoryResults ->
            return Result.success(categoryResults)
        }.onFailure {
            return Result.failure(it)
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something weird happened trying to get categories"))
    }

    private suspend fun getAbilityScores(url: String): Result<List<AbilityScore>> {
        val abilityList = mutableListOf<AbilityScore>()

        getter.getCategoryResults(url).onSuccess { abilityScoreResults ->
            Log.d("debug", "ADDING CARDS")
            abilityScoreResults.results!!.forEach { result ->
                val abilityScore = getter.getAbilityScore(result.url!!).getOrThrow()
                abilityList.add(abilityScore)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(abilityList)
    }

    private suspend fun getAlignments(url: String): Result<List<AlignmentType>> {
        val alignmentList = mutableListOf<AlignmentType>()

        getter.getCategoryResults(url).onSuccess { alignmentResults ->
            Log.d("debug", "ADDING CARDS")
            alignmentResults.results!!.forEach { result ->
                val abilityScore = getter.getAlignment(result.url!!).getOrThrow()
                alignmentList.add(abilityScore)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(alignmentList)
    }

    private suspend fun getClasses(url: String): Result<List<ClassType>> {
        val classList = mutableListOf<ClassType>()

        getter.getCategoryResults(url).onSuccess { classResults ->
            Log.d("debug", "ADDING CARDS")
            classResults.results!!.forEach { result ->
                val classResult = getter.getClass(result.url!!).getOrThrow()
                classList.add(classResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(classList)
    }

    private suspend fun getConditions(url: String): Result<List<Condition>> {
        val conditionList = mutableListOf<Condition>()

        getter.getCategoryResults(url).onSuccess { conditionResults ->
            Log.d("debug", "ADDING CARDS")
            conditionResults.results!!.forEach { result ->
                val conditionResult = getter.getCondition(result.url!!).getOrThrow()
                conditionList.add(conditionResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(conditionList)
    }

    private suspend fun getDamageTypes(url: String): Result<List<DamageType>>  {
        val damageTypeList = mutableListOf<DamageType>()

        getter.getCategoryResults(url).onSuccess { damageTypeResults ->
            Log.d("debug", "ADDING CARDS")
            damageTypeResults.results!!.forEach { result ->
                val damageTypeResult = getter.getDamageType(result.url!!).getOrThrow()
                damageTypeList.add(damageTypeResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(damageTypeList)
    }

    private suspend fun getEquipmentCategories(url: String): Result<List<EquipmentCategory>> {
        val equipmentCategoryList = mutableListOf<EquipmentCategory>()

        getter.getCategoryResults(url).onSuccess { equipmentCategoriesResults ->
            Log.d("debug", "ADDING CARDS")
            equipmentCategoriesResults.results!!.forEach { result ->
                val equipmentCategoryResult = getter.getEquipmentCategory(result.url!!).getOrThrow()
                equipmentCategoryList.add(equipmentCategoryResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(equipmentCategoryList)
    }

    private suspend fun getEquipments(url: String): Result<List<Equipment>> {
        val equipmentList = mutableListOf<Equipment>()

        getter.getCategoryResults(url).onSuccess { equipmentResults ->
            Log.d("debug", "ADDING CARDS")
            equipmentResults.results!!.forEach { result ->
                val equipmentResult = getter.getEquipment(result.url!!).getOrThrow()
                equipmentList.add(equipmentResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(equipmentList)
    }

    private suspend fun getFeats(url: String): Result<List<Feat>> {
        val featList = mutableListOf<Feat>()

        getter.getCategoryResults(url).onSuccess { featResults ->
            Log.d("debug", "ADDING CARDS")
            featResults.results!!.forEach { result ->
                val featResult = getter.getFeat(result.url!!).getOrThrow()
                featList.add(featResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(featList)
    }

    private suspend fun getFeatures(url: String): Result<List<Feature>> {
        val featureList = mutableListOf<Feature>()

        getter.getCategoryResults(url).onSuccess { featureResults ->
            Log.d("debug", "ADDING CARDS")
            featureResults.results!!.forEach { result ->
                val featureResult = getter.getFeature(result.url!!).getOrThrow()
                featureList.add(featureResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(featureList)
    }

    private suspend fun getLanguages(url: String): Result<List<Language>> {
        val languageList = mutableListOf<Language>()

        getter.getCategoryResults(url).onSuccess { languageResults ->
            Log.d("debug", "ADDING CARDS")
            languageResults.results!!.forEach { result ->
                val languageResult = getter.getLanguage(result.url!!).getOrThrow()
                languageList.add(languageResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(languageList)
    }

    private suspend fun getMagicItems(url: String): Result<List<MagicItem>> {
        val magicItemList = mutableListOf<MagicItem>()

        getter.getCategoryResults(url).onSuccess { magicItemResults ->
            Log.d("debug", "ADDING CARDS")
            magicItemResults.results!!.forEach { result ->
                val magicItemResult = getter.getMagicItem(result.url!!).getOrThrow()
                magicItemList.add(magicItemResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(magicItemList)
    }

    private suspend fun getMagicSchool(url: String): Result<List<MagicSchool>> {
        val magicSchoolList = mutableListOf<MagicSchool>()

        getter.getCategoryResults(url).onSuccess { magicSchoolResults ->
            Log.d("debug", "ADDING CARDS")
            magicSchoolResults.results!!.forEach { result ->
                val magicSchoolResult = getter.getMagicSchool(result.url!!).getOrThrow()
                magicSchoolList.add(magicSchoolResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(magicSchoolList)
    }

    private suspend fun getMonsters(url: String): Result<List<Monster>> {
        val monsterList = mutableListOf<Monster>()

        getter.getCategoryResults(url).onSuccess { monsterResults ->
            Log.d("debug", "ADDING CARDS")
            monsterResults.results!!.forEach { result ->
                val monsterResult = getter.getMonster(result.url!!).getOrThrow()
                monsterList.add(monsterResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(monsterList)
    }

    private suspend fun getProficiencies(url: String): Result<List<Proficiency>> {
        val proficiencyList = mutableListOf<Proficiency>()

        getter.getCategoryResults(url).onSuccess { proficiencyResults ->
            Log.d("debug", "ADDING CARDS")
            proficiencyResults.results!!.forEach { result ->
                val proficiencyResult = getter.getProficiency(result.url!!).getOrThrow()
                proficiencyList.add(proficiencyResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(proficiencyList)
    }

    private suspend fun getRaces(url: String): Result<List<Race>> {
        val raceList = mutableListOf<Race>()

        getter.getCategoryResults(url).onSuccess { raceResutls ->
            Log.d("debug", "ADDING CARDS")
            raceResutls.results!!.forEach { result ->
                val raceResult = getter.getRace(result.url!!).getOrThrow()
                raceList.add(raceResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(raceList)
    }

    private suspend fun getRules(url: String): Result<List<Rule>> {
        val ruleList = mutableListOf<Rule>()

        getter.getCategoryResults(url).onSuccess { ruleResults ->
            Log.d("debug", "ADDING CARDS")
            ruleResults.results!!.forEach { result ->
                val ruleResult = getter.getRule(result.url!!).getOrThrow()
                ruleList.add(ruleResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(ruleList)
    }

    private suspend fun getRuleSections(url: String): Result<List<RuleSection>> {
        val ruleSectionList = mutableListOf<RuleSection>()

        getter.getCategoryResults(url).onSuccess { ruleSectionResults ->
            Log.d("debug", "ADDING CARDS")
            ruleSectionResults.results!!.forEach { result ->
                val ruleSectionResult = getter.getRuleSection(result.url!!).getOrThrow()
                ruleSectionList.add(ruleSectionResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(ruleSectionList)
    }

    private suspend fun getSkills(url: String): Result<List<Skill>> {
        val skillList = mutableListOf<Skill>()

        getter.getCategoryResults(url).onSuccess { skillResults ->
            Log.d("debug", "ADDING CARDS")
            skillResults.results!!.forEach { result ->
                val skillResult = getter.getSkill(result.url!!).getOrThrow()
                skillList.add(skillResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(skillList)
    }

    private suspend fun getSpells(url: String): Result<List<Spell>> {
        val spellList = mutableListOf<Spell>()

        getter.getCategoryResults(url).onSuccess { spellResults ->
            Log.d("debug", "ADDING CARDS")
            spellResults.results!!.forEach { result ->
                val spell = getter.getSpell(result.url!!).getOrThrow()
                spellList.add(spell)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(spellList)
    }

    private suspend fun getSubclasses(url: String): Result<List<Subclass>> {
        val subclassList = mutableListOf<Subclass>()

        getter.getCategoryResults(url).onSuccess { subclassResults ->
            Log.d("debug", "ADDING CARDS")
            subclassResults.results!!.forEach { result ->
                val subclassResult = getter.getSubclass(result.url!!).getOrThrow()
                subclassList.add(subclassResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(subclassList)
    }

    private suspend fun getSubraces(url: String): Result<List<Subrace>> {
        val subraceList = mutableListOf<Subrace>()

        getter.getCategoryResults(url).onSuccess { subraceResults ->
            Log.d("debug", "ADDING CARDS")
            subraceResults.results!!.forEach { result ->
                val subraceResult = getter.getSubrace(result.url!!).getOrThrow()
                subraceList.add(subraceResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(subraceList)
    }

    private suspend fun getTraits(url: String): Result<List<Trait>> {
        val traitList = mutableListOf<Trait>()

        getter.getCategoryResults(url).onSuccess { traitResults ->
            Log.d("debug", "ADDING CARDS")
            traitResults.results!!.forEach { result ->
                val traitResult = getter.getTrait(result.url!!).getOrThrow()
                traitList.add(traitResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(traitList)
    }

    private suspend fun getWeaponProperties(url: String): Result<List<WeaponProperty>> {
        val weaponPropertyList = mutableListOf<WeaponProperty>()

        getter.getCategoryResults(url).onSuccess { weaponPropertyResults ->
            Log.d("debug", "ADDING CARDS")
            weaponPropertyResults.results!!.forEach { result ->
                val weaponPropertyResult = getter.getWeaponProperty(result.url!!).getOrThrow()
                weaponPropertyList.add(weaponPropertyResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            return Result.failure(it)
        }

        return Result.success(weaponPropertyList)
    }
}