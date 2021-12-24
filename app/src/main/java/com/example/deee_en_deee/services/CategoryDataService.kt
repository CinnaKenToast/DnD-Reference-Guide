package com.example.deee_en_deee.services

import android.content.Context
import android.text.Layout
import android.util.Log
import androidx.compose.runtime.getValue
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.ui.components.capitalize

class CategoryDataService(context: Context) {
    private val getter = APIGetter()

    private fun getCategoryStringFromUrl(url: String): String {
        var newString = url.drop(5).replace("-", " ")
        newString = newString.split(" ").joinToString(" ") { it.capitalize() }.trimEnd()
        return newString
    }

    suspend fun getCategories(): Result<InitialReferences> {
        return getter.getInitialReferences()
    }

    suspend fun getAbilityScores(url: String): Result<List<AbilityScore>> {
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

    suspend fun getAlignments(url: String): Result<List<AlignmentType>> {
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

    suspend fun getClasses(url: String): Result<List<ClassType>> {
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

    suspend fun getConditions(url: String): Result<List<Condition>> {
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

    suspend fun getDamageTypes(url: String): Result<List<DamageType>>  {
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

    suspend fun getEquipmentCategories(url: String): Result<List<EquipmentCategory>> {
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

    suspend fun getEquipments(url: String): Result<List<Equipment>> {
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

    suspend fun getFeats(url: String): Result<List<Feat>> {
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

    suspend fun getFeatures(url: String): Result<List<Feature>> {
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

    suspend fun getLanguages(url: String): Result<List<Language>> {
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

    suspend fun getMagicItems(url: String): Result<List<MagicItem>> {
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

    suspend fun getMagicSchool(url: String): Result<List<MagicSchool>> {
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

    suspend fun getMonsters(url: String): Result<List<Monster>> {
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

    suspend fun getProficiencies(url: String): Result<List<Proficiency>> {
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

    suspend fun getRaces(url: String): Result<List<Race>> {
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

    suspend fun getRules(url: String): Result<List<Rule>> {
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

    suspend fun getRuleSections(url: String): Result<List<RuleSection>> {
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

    suspend fun getSkills(url: String): Result<List<Skill>> {
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

    suspend fun getSpells(url: String): Result<List<Spell>> {
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

    suspend fun getSubclasses(url: String): Result<List<Subclass>> {
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

    suspend fun getSubraces(url: String): Result<List<Subrace>> {
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

    suspend fun getTraits(url: String): Result<List<Trait>> {
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

    suspend fun getWeaponProperties(url: String): Result<List<WeaponProperty>> {
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