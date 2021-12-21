package com.example.deee_en_deee.ui

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.deee_en_deee.database.*
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.services.APIGetter
import com.example.deee_en_deee.ui.components.capitalize
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainVM(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    private val getter = APIGetter()
    val isLoading = mutableStateOf(true)

    val abilityScoreDao = AbilityScoreDatabase.getInstance(context).abilityScoreDao()
    val alignmentDao = AlignmentDatabase.getInstance(context).alignmentDao()
    val classDao = ClassDatabase.getInstance(context).classDao()
    val conditionDao = ConditionDatabase.getInstance(context).conditionDao()
    val damageTypeDao = DamageTypeDatabase.getInstance(context).damageTypeDao()
    val equipmentCategoryDao = EquipmentCategoryDatabase.getInstance(context).equipmentCategoryDao()
    val equipmentDao = EquipmentDatabase.getInstance(context).equipmentDao()
    val featDao = FeatDatabase.getInstance(context).featDao()

    /*private val listOfAbilityScores: MutableList<AbilityScore> = mutableListOf()
    private val listOfAlignments: MutableList<AlignmentType> = mutableListOf()
    private val listOfClasses: MutableList<ClassType> = mutableListOf()
    private val listOfConditions: MutableList<Condition> = mutableListOf()
    private val listOfDamageTypes: MutableList<DamageType> = mutableListOf()
    private val listOfEquipmentCategories: MutableList<EquipmentCategory> = mutableListOf()
    private val listOfEquipments: MutableList<Equipment> = mutableListOf()
    private val listOfFeats: MutableList<Feat> = mutableListOf()
    private val listOfFeatures: MutableList<Feature> = mutableListOf()
    private val listOfLanguages: MutableList<Language> = mutableListOf()
    private val listOfMagicItems: MutableList<MagicItem> = mutableListOf()
    private val listOfMagicSchools: MutableList<MagicSchool> = mutableListOf()
    private val listOfMonsters: MutableList<Monster> = mutableListOf()
    private val listOfProficiencies: MutableList<Proficiency> = mutableListOf()
    private val listOfRaces: MutableList<Race> = mutableListOf()
    private val listOfRules: MutableList<Rule> = mutableListOf()
    private val listOfRuleSections: MutableList<RuleSection> = mutableListOf()
    private val listOfSkills: MutableList<Skill> = mutableListOf()
    private val listOfSpells: MutableList<Spell> = mutableListOf()
    private val listOfSubclasses: MutableList<Subclass> = mutableListOf()
    private val listOfSubraces: MutableList<Subrace> = mutableListOf()
    private val listOfTraits: MutableList<Trait> = mutableListOf()
    private val listOfWeaponProperties: MutableList<WeaponProperty> = mutableListOf()*/

    val listOfAbilityScores = mutableStateOf(mutableListOf<AbilityScore>())
    val listOfAlignments = mutableStateOf(mutableListOf<AlignmentType>())
    val listOfClasses = mutableStateOf(mutableListOf<ClassType>())
    val listOfConditions = mutableStateOf(mutableListOf<Condition>())
    val listOfDamageTypes = mutableStateOf(mutableListOf<DamageType>())
    val listOfEquipmentCategories = mutableStateOf(mutableListOf<EquipmentCategory>())
    val listOfEquipments = mutableStateOf(mutableListOf<Equipment>())
    val listOfFeats = mutableStateOf(mutableListOf<Feat>())
    val listOfFeatures = mutableStateOf(mutableListOf<Feature>())
    val listOfLanguages = mutableStateOf(mutableListOf<Language>())
    val listOfMagicItems = mutableStateOf(mutableListOf<MagicItem>())
    val listOfMagicSchools = mutableStateOf(mutableListOf<MagicSchool>())
    val listOfMonsters = mutableStateOf(mutableListOf<Monster>())
    val listOfProficiencies = mutableStateOf(mutableListOf<Proficiency>())
    val listOfRaces = mutableStateOf(mutableListOf<Race>())
    val listOfRules = mutableStateOf(mutableListOf<Rule>())
    val listOfRuleSections = mutableStateOf(mutableListOf<RuleSection>())
    val listOfSkills = mutableStateOf(mutableListOf<Skill>())
    val listOfSpells = mutableStateOf(mutableListOf<Spell>())
    val listOfSubclasses = mutableStateOf(mutableListOf<Subclass>())
    val listOfSubraces = mutableStateOf(mutableListOf<Subrace>())
    val listOfTraits = mutableStateOf(mutableListOf<Trait>())
    val listOfWeaponProperties = mutableStateOf(mutableListOf<WeaponProperty>())

    val loadedCategories = mutableStateOf(0)
    val downloadingCategoryTitle = mutableStateOf("")

    init {
        viewModelScope.launch {
            getCategories().onSuccess { it ->
                setLoading(true)

//                if (listOfAbilityScores.value.isEmpty()) {
//                    listOfAbilityScores.value = abilityScoreDao.getListOfAbilityScores()?.toMutableList() ?: mutableListOf()
//
//                    Log.d("debug2", "ABILITY SCORE WAS EMPTY")
//
//                    if (listOfAbilityScores.value.isEmpty()) {
//                        Log.d("debug2", "DATABASE WAS EMPTY")
//                        downloadingCategoryTitle.value = getCategoryStringFromUrl(it.abilityScore)
//                        getAbilityScores(it.abilityScore)
//                        loadedCategories.value++
//
//                        listOfAbilityScores.value.forEach { abilityScore ->
//                            abilityScoreDao.insert(abilityScore)
//                        }
//                    } else {
//                        Log.d("debug2", "DATABASE WAS FULL")
//                    }
//                } else {
//                    Log.d("debug2", "ABILITY SCORE WAS FILLED")
//                }
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.alignments)
//                getAlignments(it.alignments)
//                loadedCategories.value++
//
//                listOfAlignments.value.forEach { alignmentType ->
//                    alignmentDao.insert(alignmentType)
//                }
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.classes)
//                getClasses(it.classes)
//                loadedCategories.value++
//
//                listOfClasses.value.forEach { classType ->
//                    classDao.insert(classType)
//                }
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.conditions)
//                getConditions(it.conditions)
//                loadedCategories.value++
//
//                listOfConditions.value.forEach { condition ->
//                    conditionDao.insert(condition)
//                }
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.damageTypes)
//                getDamageTypes(it.damageTypes)
//                loadedCategories.value++
//
//                listOfDamageTypes.value.forEach { damageType ->
//                    damageTypeDao.insert(damageType)
//                }
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.equipmentCategory)
//                getEquipmentCategories(it.equipmentCategory)
//                loadedCategories.value++
//
//                listOfEquipmentCategories.value.forEach { equipmentCategory ->
//                    equipmentCategoryDao.insert(equipmentCategory)
//                }
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.equipment)
//                getEquipments(it.equipment)
//                loadedCategories.value++
//
//                listOfEquipments.value.forEach { equipment ->
//                    equipmentDao.insert(equipment)
//                }

                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.feats)
                getFeats(it.feats)
                loadedCategories.value++

                listOfFeats.value.forEach { feat ->
                    featDao.insert(feat)
                }
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.features)
//                getFeatures(it.features)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.languages)
//                getLanguages(it.languages)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.magicItems)
//                getMagicItems(it.magicItems)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.magicSchools)
//                getMagicSchool(it.magicSchools)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.monsters)
//                getMonsters(it.monsters)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.proficiencies)
//                getProficiencies(it.proficiencies)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.races)
//                getRaces(it.races)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.rules)
//                getRules(it.rules)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.ruleSections)
//                getRuleSections(it.ruleSections)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.skills)
//                getSkills(it.skills)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.spells)
//                getSpells(it.spells)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.subclasses)
//                getSubclasses(it.subclasses)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.subraces)
//                getSubraces(it.subraces)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.traits)
//                getTraits(it.traits)
//                loadedCategories.value++
//
//                downloadingCategoryTitle.value = getCategoryStringFromUrl(it.weaponProperties)
//                getWeaponProperties(it.weaponProperties)
//                loadedCategories.value++

                delay(5000)
                setLoading(false)
            }
        }
    }

    private fun getCategoryStringFromUrl(url: String): String {
        var newString = url.drop(5).replace("-", " ")
        newString = newString.split(" ").joinToString(" ") { it.capitalize() }.trimEnd()
        return newString
    }

    fun setLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }

    suspend fun getCategories(): Result<InitialReferences> {
        return getter.getInitialReferences()
    }

    suspend fun getAbilityScores(url: String) {
        val abilityList by listOfAbilityScores

        getter.getCategoryResults(url).onSuccess { abilityScoreResults ->
            Log.d("debug", "ADDING CARDS")
            abilityScoreResults.results!!.forEach { result ->
                val abilityScore = getter.getAbilityScore(result.url!!).getOrThrow()
                abilityList.add(abilityScore)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getAlignments(url: String) {
        val alignmentList by listOfAlignments

        getter.getCategoryResults(url).onSuccess { alignmentResults ->
            Log.d("debug", "ADDING CARDS")
            alignmentResults.results!!.forEach { result ->
                val abilityScore = getter.getAlignment(result.url!!).getOrThrow()
                alignmentList.add(abilityScore)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getClasses(url: String) {
        val classList by listOfClasses

        getter.getCategoryResults(url).onSuccess { classResults ->
            Log.d("debug", "ADDING CARDS")
            classResults.results!!.forEach { result ->
                val classResult = getter.getClass(result.url!!).getOrThrow()
                classList.add(classResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getConditions(url: String) {
        val conditionList by listOfConditions

        getter.getCategoryResults(url).onSuccess { conditionResults ->
            Log.d("debug", "ADDING CARDS")
            conditionResults.results!!.forEach { result ->
                val conditionResult = getter.getCondition(result.url!!).getOrThrow()
                conditionList.add(conditionResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getDamageTypes(url: String) {
        val damageTypeList by listOfDamageTypes

        getter.getCategoryResults(url).onSuccess { damageTypeResults ->
            Log.d("debug", "ADDING CARDS")
            damageTypeResults.results!!.forEach { result ->
                val damageTypeResult = getter.getDamageType(result.url!!).getOrThrow()
                damageTypeList.add(damageTypeResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getEquipmentCategories(url: String) {
        val equipmentCategoryList by listOfEquipmentCategories

        getter.getCategoryResults(url).onSuccess { equipmentCategoriesResults ->
            Log.d("debug", "ADDING CARDS")
            equipmentCategoriesResults.results!!.forEach { result ->
                val equipmentCategoryResult = getter.getEquipmentCategory(result.url!!).getOrThrow()
                equipmentCategoryList.add(equipmentCategoryResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getEquipments(url: String) {
        val equipmentList by listOfEquipments

        getter.getCategoryResults(url).onSuccess { equipmentResults ->
            Log.d("debug", "ADDING CARDS")
            equipmentResults.results!!.forEach { result ->
                val equipmentResult = getter.getEquipment(result.url!!).getOrThrow()
                equipmentList.add(equipmentResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getFeats(url: String) {
        val featList by listOfFeats

        getter.getCategoryResults(url).onSuccess { featResults ->
            Log.d("debug", "ADDING CARDS")
            featResults.results!!.forEach { result ->
                val featResult = getter.getFeat(result.url!!).getOrThrow()
                featList.add(featResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getFeatures(url: String) {
        val featureList by listOfFeatures

        getter.getCategoryResults(url).onSuccess { featureResults ->
            Log.d("debug", "ADDING CARDS")
            featureResults.results!!.forEach { result ->
                val featureResult = getter.getFeature(result.url!!).getOrThrow()
                featureList.add(featureResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getLanguages(url: String) {
        val languageList by listOfLanguages

        getter.getCategoryResults(url).onSuccess { languageResults ->
            Log.d("debug", "ADDING CARDS")
            languageResults.results!!.forEach { result ->
                val languageResult = getter.getLanguage(result.url!!).getOrThrow()
                languageList.add(languageResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getMagicItems(url: String) {
        val magicItemList by listOfMagicItems

        getter.getCategoryResults(url).onSuccess { magicItemResults ->
            Log.d("debug", "ADDING CARDS")
            magicItemResults.results!!.forEach { result ->
                val magicItemResult = getter.getMagicItem(result.url!!).getOrThrow()
                magicItemList.add(magicItemResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getMagicSchool(url: String) {
        val magicSchoolList by listOfMagicSchools

        getter.getCategoryResults(url).onSuccess { magicSchoolResults ->
            Log.d("debug", "ADDING CARDS")
            magicSchoolResults.results!!.forEach { result ->
                val magicSchoolResult = getter.getMagicSchool(result.url!!).getOrThrow()
                magicSchoolList.add(magicSchoolResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getMonsters(url: String) {
        val monsterList by listOfMonsters

        getter.getCategoryResults(url).onSuccess { monsterResults ->
            Log.d("debug", "ADDING CARDS")
            monsterResults.results!!.forEach { result ->
                val monsterResult = getter.getMonster(result.url!!).getOrThrow()
                monsterList.add(monsterResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getProficiencies(url: String) {
        val proficiencyList by listOfProficiencies

        getter.getCategoryResults(url).onSuccess { proficiencyResults ->
            Log.d("debug", "ADDING CARDS")
            proficiencyResults.results!!.forEach { result ->
                val proficiencyResult = getter.getProficiency(result.url!!).getOrThrow()
                proficiencyList.add(proficiencyResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getRaces(url: String) {
        val raceList by listOfRaces

        getter.getCategoryResults(url).onSuccess { raceResutls ->
            Log.d("debug", "ADDING CARDS")
            raceResutls.results!!.forEach { result ->
                val raceResult = getter.getRace(result.url!!).getOrThrow()
                raceList.add(raceResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getRules(url: String) {
        val ruleList by listOfRules

        getter.getCategoryResults(url).onSuccess { ruleResults ->
            Log.d("debug", "ADDING CARDS")
            ruleResults.results!!.forEach { result ->
                val ruleResult = getter.getRule(result.url!!).getOrThrow()
                ruleList.add(ruleResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getRuleSections(url: String) {
        val ruleSectionList by listOfRuleSections

        getter.getCategoryResults(url).onSuccess { ruleSectionResults ->
            Log.d("debug", "ADDING CARDS")
            ruleSectionResults.results!!.forEach { result ->
                val ruleSectionResult = getter.getRuleSection(result.url!!).getOrThrow()
                ruleSectionList.add(ruleSectionResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getSkills(url: String) {
        val skillList by listOfSkills

        getter.getCategoryResults(url).onSuccess { skillResults ->
            Log.d("debug", "ADDING CARDS")
            skillResults.results!!.forEach { result ->
                val skillResult = getter.getSkill(result.url!!).getOrThrow()
                skillList.add(skillResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getSpells(url: String) {
        val spellList by listOfSpells

        getter.getCategoryResults(url).onSuccess { spellResults ->
            Log.d("debug", "ADDING CARDS")
            spellResults.results!!.forEach { result ->
                val spell = getter.getSpell(result.url!!).getOrThrow()
                spellList.add(spell)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getSubclasses(url: String) {
        val subclassList by listOfSubclasses

        getter.getCategoryResults(url).onSuccess { subclassResults ->
            Log.d("debug", "ADDING CARDS")
            subclassResults.results!!.forEach { result ->
                val subclassResult = getter.getSubclass(result.url!!).getOrThrow()
                subclassList.add(subclassResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getSubraces(url: String) {
        val subraceList by listOfSubraces

        getter.getCategoryResults(url).onSuccess { subraceResults ->
            Log.d("debug", "ADDING CARDS")
            subraceResults.results!!.forEach { result ->
                val subraceResult = getter.getSubrace(result.url!!).getOrThrow()
                subraceList.add(subraceResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getTraits(url: String) {
        val traitList by listOfTraits

        getter.getCategoryResults(url).onSuccess { traitResults ->
            Log.d("debug", "ADDING CARDS")
            traitResults.results!!.forEach { result ->
                val traitResult = getter.getTrait(result.url!!).getOrThrow()
                traitList.add(traitResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }

    suspend fun getWeaponProperties(url: String) {
        val weaponPropertyList by listOfWeaponProperties

        getter.getCategoryResults(url).onSuccess { weaponPropertyResults ->
            Log.d("debug", "ADDING CARDS")
            weaponPropertyResults.results!!.forEach { result ->
                val weaponPropertyResult = getter.getWeaponProperty(result.url!!).getOrThrow()
                weaponPropertyList.add(weaponPropertyResult)
            }
            Log.d("debug", "FINISHED ADDING CARDS")
        }.onFailure {
            throw(it)
        }
    }
}

class MainVMFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(application)
    }
}