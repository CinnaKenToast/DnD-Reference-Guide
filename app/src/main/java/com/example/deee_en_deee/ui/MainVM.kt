package com.example.deee_en_deee.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.utils.UrlParameter
import com.example.deee_en_deee.utils.get
import io.ktor.client.*
import io.ktor.client.engine.android.*

private const val STARTER_URL = "https://www.dnd5eapi.co/api/"
private const val BASE_URL = "https://www.dnd5eapi.co"

class MainVM: ViewModel() {
    private val getter = APIGetter()
    val isLoading = mutableStateOf(true)

    private val listOfAbilityScores: MutableList<AbilityScore> = mutableListOf()
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
    private val listOfWeaponProperties: MutableList<WeaponProperty> = mutableListOf()

    suspend fun getCategories(): Result<InitialReferences> {
        return getter.getInitialReferences()
    }

    suspend fun getAbilityScores(url: String): Result<List<AbilityScore>> {
        isLoading.value = true

        if (listOfAbilityScores.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfAbilityScores)
        } else {
            getter.getCategoryResults(url).onSuccess { abilityScoreResults ->
                Log.d("debug", "ADDING CARDS")
                abilityScoreResults.results!!.forEach { result ->
                    val abilityScore = getter.getAbilityScore(result.url!!).getOrThrow()
                    listOfAbilityScores.add(abilityScore)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfAbilityScores)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getAlignments(url: String): Result<List<AlignmentType>> {
        isLoading.value = true

        if (listOfAlignments.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfAlignments)
        } else {
            getter.getCategoryResults(url).onSuccess { alignmentResults ->
                Log.d("debug", "ADDING CARDS")
                alignmentResults.results!!.forEach { result ->
                    val abilityScore = getter.getAlignment(result.url!!).getOrThrow()
                    listOfAlignments.add(abilityScore)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfAlignments)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getClasses(url: String): Result<List<ClassType>> {
        isLoading.value = true

        if (listOfClasses.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfClasses)
        } else {
            getter.getCategoryResults(url).onSuccess { classResults ->
                Log.d("debug", "ADDING CARDS")
                classResults.results!!.forEach { result ->
                    val classResult = getter.getClass(result.url!!).getOrThrow()
                    listOfClasses.add(classResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfClasses)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getConditions(url: String): Result<List<Condition>> {
        isLoading.value = true

        if (listOfConditions.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfConditions)
        } else {
            getter.getCategoryResults(url).onSuccess { conditionResults ->
                Log.d("debug", "ADDING CARDS")
                conditionResults.results!!.forEach { result ->
                    val conditionResult = getter.getCondition(result.url!!).getOrThrow()
                    listOfConditions.add(conditionResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfConditions)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getDamageTypes(url: String): Result<List<DamageType>> {
        isLoading.value = true

        if (listOfDamageTypes.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfDamageTypes)
        } else {
            getter.getCategoryResults(url).onSuccess { damageTypeResults ->
                Log.d("debug", "ADDING CARDS")
                damageTypeResults.results!!.forEach { result ->
                    val damageTypeResult = getter.getDamageType(result.url!!).getOrThrow()
                    listOfDamageTypes.add(damageTypeResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfDamageTypes)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getEquipmentCategories(url: String): Result<List<EquipmentCategory>> {
        isLoading.value = true

        if (listOfEquipmentCategories.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfEquipmentCategories)
        } else {
            getter.getCategoryResults(url).onSuccess { equipmentCategoriesResults ->
                Log.d("debug", "ADDING CARDS")
                equipmentCategoriesResults.results!!.forEach { result ->
                    val equipmentCategoryResult = getter.getEquipmentCategory(result.url!!).getOrThrow()
                    listOfEquipmentCategories.add(equipmentCategoryResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfEquipmentCategories)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getEquipments(url: String): Result<List<Equipment>> {
        isLoading.value = true

        if (listOfEquipments.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfEquipments)
        } else {
            getter.getCategoryResults(url).onSuccess { equipmentResults ->
                Log.d("debug", "ADDING CARDS")
                equipmentResults.results!!.forEach { result ->
                    val equipmentResult = getter.getEquipment(result.url!!).getOrThrow()
                    listOfEquipments.add(equipmentResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfEquipments)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getFeats(url: String): Result<List<Feat>> {
        isLoading.value = true

        if (listOfFeats.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfFeats)
        } else {
            getter.getCategoryResults(url).onSuccess { featResults ->
                Log.d("debug", "ADDING CARDS")
                featResults.results!!.forEach { result ->
                    val featResult = getter.getFeat(result.url!!).getOrThrow()
                    listOfFeats.add(featResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfFeats)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getFeatures(url: String): Result<List<Feature>> {
        isLoading.value = true

        if (listOfFeatures.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfFeatures)
        } else {
            getter.getCategoryResults(url).onSuccess { featureResults ->
                Log.d("debug", "ADDING CARDS")
                featureResults.results!!.forEach { result ->
                    val featureResult = getter.getFeature(result.url!!).getOrThrow()
                    listOfFeatures.add(featureResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfFeatures)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getLanguages(url: String): Result<List<Language>> {
        isLoading.value = true

        if (listOfLanguages.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfLanguages)
        } else {
            getter.getCategoryResults(url).onSuccess { languageResults ->
                Log.d("debug", "ADDING CARDS")
                languageResults.results!!.forEach { result ->
                    val languageResult = getter.getLanguage(result.url!!).getOrThrow()
                    listOfLanguages.add(languageResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfLanguages)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getMagicItems(url: String): Result<List<MagicItem>> {
        isLoading.value = true

        if (listOfMagicItems.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfMagicItems)
        } else {
            getter.getCategoryResults(url).onSuccess { magicItemResults ->
                Log.d("debug", "ADDING CARDS")
                magicItemResults.results!!.forEach { result ->
                    val magicItemResult = getter.getMagicItem(result.url!!).getOrThrow()
                    listOfMagicItems.add(magicItemResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfMagicItems)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getMagicSchool(url: String): Result<List<MagicSchool>> {
        isLoading.value = true

        if (listOfMagicSchools.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfMagicSchools)
        } else {
            getter.getCategoryResults(url).onSuccess { magicSchoolResults ->
                Log.d("debug", "ADDING CARDS")
                magicSchoolResults.results!!.forEach { result ->
                    val magicSchoolResult = getter.getMagicSchool(result.url!!).getOrThrow()
                    listOfMagicSchools.add(magicSchoolResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfMagicSchools)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getMonsters(url: String): Result<List<Monster>> {
        isLoading.value = true

        if (listOfMonsters.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfMonsters)
        } else {
            getter.getCategoryResults(url).onSuccess { monsterResults ->
                Log.d("debug", "ADDING CARDS")
                monsterResults.results!!.forEach { result ->
                    val monsterResult = getter.getMonster(result.url!!).getOrThrow()
                    listOfMonsters.add(monsterResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfMonsters)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getProficiencies(url: String): Result<List<Proficiency>> {
        isLoading.value = true

        if (listOfProficiencies.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfProficiencies)
        } else {
            getter.getCategoryResults(url).onSuccess { proficiencyResults ->
                Log.d("debug", "ADDING CARDS")
                proficiencyResults.results!!.forEach { result ->
                    val proficiencyResult = getter.getProficiency(result.url!!).getOrThrow()
                    listOfProficiencies.add(proficiencyResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfProficiencies)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getRaces(url: String): Result<List<Race>> {
        isLoading.value = true

        if (listOfRaces.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfRaces)
        } else {
            getter.getCategoryResults(url).onSuccess { raceResutls ->
                Log.d("debug", "ADDING CARDS")
                raceResutls.results!!.forEach { result ->
                    val raceResult = getter.getRace(result.url!!).getOrThrow()
                    listOfRaces.add(raceResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfRaces)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getRules(url: String): Result<List<Rule>> {
        isLoading.value = true

        if (listOfRules.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfRules)
        } else {
            getter.getCategoryResults(url).onSuccess { ruleResults ->
                Log.d("debug", "ADDING CARDS")
                ruleResults.results!!.forEach { result ->
                    val RuleResult = getter.getRule(result.url!!).getOrThrow()
                    listOfRules.add(RuleResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfRules)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getRuleSections(url: String): Result<List<RuleSection>> {
        isLoading.value = true

        if (listOfRuleSections.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfRuleSections)
        } else {
            getter.getCategoryResults(url).onSuccess { ruleSectionResults ->
                Log.d("debug", "ADDING CARDS")
                ruleSectionResults.results!!.forEach { result ->
                    val ruleSectionResult = getter.getRuleSection(result.url!!).getOrThrow()
                    listOfRuleSections.add(ruleSectionResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfRuleSections)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getSkills(url: String): Result<List<Skill>> {
        isLoading.value = true

        if (listOfSkills.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfSkills)
        } else {
            getter.getCategoryResults(url).onSuccess { skillResults ->
                Log.d("debug", "ADDING CARDS")
                skillResults.results!!.forEach { result ->
                    val skillResult = getter.getSkill(result.url!!).getOrThrow()
                    listOfSkills.add(skillResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfSkills)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getSpells(url: String): Result<List<Spell>> {
        isLoading.value = true

        if (listOfSpells.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfSpells)
        } else {
            getter.getCategoryResults(url).onSuccess { spellResults ->
                Log.d("debug", "ADDING CARDS")
                spellResults.results!!.forEach { result ->
                    val spell = getter.getSpell(result.url!!).getOrThrow()
                    listOfSpells.add(spell)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfSpells)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getSubclasses(url: String): Result<List<Subclass>> {
        isLoading.value = true

        if (listOfSubclasses.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfSubclasses)
        } else {
            getter.getCategoryResults(url).onSuccess { subclassResults ->
                Log.d("debug", "ADDING CARDS")
                subclassResults.results!!.forEach { result ->
                    val subclassResult = getter.getSubclass(result.url!!).getOrThrow()
                    listOfSubclasses.add(subclassResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfSubclasses)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getSubraces(url: String): Result<List<Subrace>> {
        isLoading.value = true

        if (listOfSubraces.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfSubraces)
        } else {
            getter.getCategoryResults(url).onSuccess { subraceResults ->
                Log.d("debug", "ADDING CARDS")
                subraceResults.results!!.forEach { result ->
                    val subraceResult = getter.getSubrace(result.url!!).getOrThrow()
                    listOfSubraces.add(subraceResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfSubraces)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getTraits(url: String): Result<List<Trait>> {
        isLoading.value = true

        if (listOfTraits.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfTraits)
        } else {
            getter.getCategoryResults(url).onSuccess { traitResults ->
                Log.d("debug", "ADDING CARDS")
                traitResults.results!!.forEach { result ->
                    val traitResult = getter.getTrait(result.url!!).getOrThrow()
                    listOfTraits.add(traitResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfTraits)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }

    suspend fun getWeaponProperties(url: String): Result<List<WeaponProperty>> {
        isLoading.value = true

        if (listOfWeaponProperties.isNotEmpty()) {
            isLoading.value = false
            return Result.success(listOfWeaponProperties)
        } else {
            getter.getCategoryResults(url).onSuccess { weaponPropertyResults ->
                Log.d("debug", "ADDING CARDS")
                weaponPropertyResults.results!!.forEach { result ->
                    val weaponPropertyResult = getter.getWeaponProperty(result.url!!).getOrThrow()
                    listOfWeaponProperties.add(weaponPropertyResult)
                }
                Log.d("debug", "FINISHED ADDING CARDS")
                isLoading.value = false
                return Result.success(listOfWeaponProperties)
            }.onFailure {
                return Result.failure(it)
            }
        }

        return Result.failure(Throwable("${this::class.java.simpleName}: Something happened while trying to get the spells"))
    }
}

class APIGetter {
    private val client: HttpClient
        get() = HttpClient(Android)

    suspend fun getAPIReference(url: String): Result<APIReference> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getInitialReferences(): Result<InitialReferences> {
        return client.get(STARTER_URL, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getCategoryResults(url: String): Result<ResourceList> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getAbilityScore(url: String): Result<AbilityScore> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getAlignment(url: String): Result<AlignmentType> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getClass(url: String): Result<ClassType> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getCondition(url: String): Result<Condition> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getDamageType(url: String): Result<DamageType> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getEquipmentCategory(url: String): Result<EquipmentCategory> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getEquipment(url: String): Result<Equipment> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getFeat(url: String): Result<Feat> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getFeature(url: String): Result<Feature> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getLanguage(url: String): Result<Language> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getMagicItem(url: String): Result<MagicItem> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getMagicSchool(url: String): Result<MagicSchool> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getMonster(url: String): Result<Monster> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getProficiency(url: String): Result<Proficiency> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getRace(url: String): Result<Race> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getRule(url: String): Result<Rule> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getRuleSection(url: String): Result<RuleSection> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getSkill(url: String): Result<Skill> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getSpell(url: String): Result<Spell> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getSubclass(url: String): Result<Subclass> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getSubrace(url: String): Result<Subrace> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getTrait(url: String): Result<Trait> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }

    suspend fun getWeaponProperty(url: String): Result<WeaponProperty> {
        return client.get(BASE_URL + url, listOf(UrlParameter(key = "", value = Any())))
    }
}