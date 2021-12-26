package com.example.deee_en_deee.database

import androidx.room.TypeConverter
import com.example.deee_en_deee.infoTypes.*
import com.example.deee_en_deee.utils.fromJsonString
import com.example.deee_en_deee.utils.toJsonString

class Converters {
    @TypeConverter
    fun apiReferenceFromString(string: String?): APIReference? {
        return string?.fromJsonString<APIReference>()
    }

    @TypeConverter
    fun apiReferenceToString(apiReference: APIReference?): String? {
        return apiReference?.toJsonString()
    }

    @TypeConverter
    fun armorClassFromString(string: String?): ArmorClass? {
        return string?.fromJsonString<ArmorClass>()
    }

    @TypeConverter
    fun armorClassToString(armorClass: ArmorClass?): String? {
        return armorClass?.toJsonString()
    }

    @TypeConverter
    fun contentsFromString(string: String?): List<Content>? {
        return string?.fromJsonString<List<Content>>()
    }

    @TypeConverter
    fun contentsToString(content: List<Content>?): String? {
        return content?.toJsonString()
    }

    @TypeConverter
    fun featPrerequisitesFromString(string: String?): List<FeatPrerequisite>? {
        return string?.fromJsonString<List<FeatPrerequisite>>()
    }

    @TypeConverter
    fun featPrerequisitesToString(featPrerequisite: List<FeatPrerequisite>?): String? {
        return featPrerequisite?.toJsonString()
    }

    @TypeConverter
    fun costFromString(string: String?): Cost? {
        return string?.fromJsonString<Cost>()
    }

    @TypeConverter
    fun costToString(cost: Cost?): String? {
        return cost?.toJsonString()
    }

    @TypeConverter
    fun damageFromString(string: String?): Damage? {
        return string?.fromJsonString<Damage>()
    }

    @TypeConverter
    fun damageToString(damage: Damage?): String? {
        return damage?.toJsonString()
    }

    @TypeConverter
    fun rangeFromString(string: String?): Range? {
        return string?.fromJsonString<Range>()
    }

    @TypeConverter
    fun rangeToString(range: Range?): String? {
        return range?.toJsonString()
    }


    @TypeConverter
    fun stringsFromString(string: String?): List<String>? {
        return string?.fromJsonString<List<String>>()
    }

    @TypeConverter
    fun stringsToString(strings: List<String>?): String? {
        return strings?.toJsonString()
    }

    @TypeConverter
    fun featureSpecificFromString(string: String?): FeatureSpecific? {
        return string?.fromJsonString<FeatureSpecific>()
    }

    @TypeConverter
    fun featureSpecificsToString(featureSpecific: FeatureSpecific?): String? {
        return featureSpecific?.toJsonString()
    }

    @TypeConverter
    fun choicesFromString(string: String?): List<Choice>? {
        return string?.fromJsonString<List<Choice>>()
    }

    @TypeConverter
    fun choicesToString(choices: List<Choice>?): String? {
        return choices?.toJsonString()
    }

    @TypeConverter
    fun choiceFromString(string: String?): Choice? {
        return string?.fromJsonString<Choice>()
    }

    @TypeConverter
    fun choiceToString(choice: Choice?): String? {
        return choice?.toJsonString()
    }

    @TypeConverter
    fun apiReferencesFromString(string: String?): List<APIReference>? {
        return string?.fromJsonString<List<APIReference>>()
    }

    @TypeConverter
    fun apiReferencesToString(apiReferences: List<APIReference>?): String? {
        return apiReferences?.toJsonString()
    }

    @TypeConverter
    fun startingEquipmentFromString(string: String?): List<Inventory>? {
        return string?.fromJsonString<List<Inventory>>()
    }

    @TypeConverter
    fun startingEquipmentToString(startingEquipment: List<Inventory>?): String? {
        return startingEquipment?.toJsonString()
    }

    @TypeConverter
    fun multiclassFromString(string: String?): Multiclass? {
        return string?.fromJsonString<Multiclass>()
    }

    @TypeConverter
    fun multiclassToString(multiclass: Multiclass?): String? {
        return multiclass?.toJsonString()
    }

    @TypeConverter
    fun spellcastingFromString(string: String?): Spellcasting? {
        return string?.fromJsonString<Spellcasting>()
    }

    @TypeConverter
    fun spellcastingToString(spellcasting: Spellcasting?): String? {
        return spellcasting?.toJsonString()
    }

    @TypeConverter
    fun speedFromString(string: String?): Speed? {
        return string?.fromJsonString<Speed>()
    }

    @TypeConverter
    fun speedToString(speed: Speed?): String? {
        return speed?.toJsonString()
    }

    @TypeConverter
    fun monsterProficienciesFromString(string: String?): List<MonsterProficiency>? {
        return string?.fromJsonString<List<MonsterProficiency>>()
    }

    @TypeConverter
    fun monsterProficienciesToString(monsterProficiencies: List<MonsterProficiency>?): String? {
        return monsterProficiencies?.toJsonString()
    }

    @TypeConverter
    fun sensesFromString(string: String?): Senses? {
        return string?.fromJsonString<Senses>()
    }

    @TypeConverter
    fun sensesToString(senses: Senses?): String? {
        return senses?.toJsonString()
    }

    @TypeConverter
    fun specialAbilitiesFromString(string: String?): List<SpecialAbility>? {
        return string?.fromJsonString<List<SpecialAbility>>()
    }

    @TypeConverter
    fun specialAbilitiesToString(specialAbilities: List<SpecialAbility>?): String? {
        return specialAbilities?.toJsonString()
    }

    @TypeConverter
    fun monsterAbilitiesFromString(string: String?): List<MonsterAction>? {
        return string?.fromJsonString<List<MonsterAction>>()
    }

    @TypeConverter
    fun monsterAbilitiesToString(monsterAbilities: List<MonsterAction>?): String? {
        return monsterAbilities?.toJsonString()
    }
    @TypeConverter
    fun abilityBonusesFromString(string: String?): List<AbilityBonus>? {
        return string?.fromJsonString<List<AbilityBonus>>()
    }

    @TypeConverter
    fun abilityBonusesToString(abilityBonuses: List<AbilityBonus>?): String? {
        return abilityBonuses?.toJsonString()
    }

    @TypeConverter
    fun traitSpecificFromString(string: String?): TraitSpecific? {
        return string?.fromJsonString<TraitSpecific>()
    }

    @TypeConverter
    fun traitSpecificToString(traitSpecific: TraitSpecific?): String? {
        return traitSpecific?.toJsonString()
    }

    @TypeConverter
    fun subclassSpellFromString(string: String?): List<SubclassSpell>? {
        return string?.fromJsonString<List<SubclassSpell>>()
    }

    @TypeConverter
    fun subclassSpellToString(subclassSpell: List<SubclassSpell>?): String? {
        return subclassSpell?.toJsonString()
    }

    @TypeConverter
    fun startingEquipmentChoicesFromString(string: String?): List<StartingEquipmentChoice>? {
        return string?.fromJsonString<List<StartingEquipmentChoice>>()
    }

    @TypeConverter
    fun startingEquipmentChoiceToString(startingEquipmentChoice: List<StartingEquipmentChoice>?): String? {
        return startingEquipmentChoice?.toJsonString()
    }
}