package com.example.deee_en_deee.ui

import android.util.Log
import androidx.compose.runtime.getValue
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
        return client.get("$BASE_URL/$url", listOf(UrlParameter(key = "", value = Any())))
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