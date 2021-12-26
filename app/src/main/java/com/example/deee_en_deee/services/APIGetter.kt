package com.example.deee_en_deee.services

import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.utils.UrlParameter
import com.example.deee_en_deee.utils.get
import io.ktor.client.*
import io.ktor.client.engine.android.*

private const val STARTER_URL = "https://www.dnd5eapi.co/api/"
private const val BASE_URL = "https://www.dnd5eapi.co"

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