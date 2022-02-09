package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.*
import com.example.deee_en_deee.infoTypes.*

@Database(entities = [
    AbilityScore::class,
    AlignmentType::class,
    ClassType::class,
    Condition::class,
    DamageType::class,
    EquipmentCategory::class,
    Equipment::class,
    Feat::class,
    Feature::class,
    Language::class,
    MagicItem::class,
    MagicSchool::class,
    Monster::class,
    Proficiency::class,
    Race::class,
    Rule::class,
    RuleSection::class,
    Skill::class,
    Spell::class,
    Subclass::class,
    Subrace::class,
    Trait::class,
    WeaponProperty::class
                     ], version = 1)
@TypeConverters(Converters::class)
abstract class MainDatabase: RoomDatabase() {

    abstract fun abilityScoreDao(): AbilityScoreDao
    abstract fun alignmentDao(): AlignmentDao
    abstract fun classDao(): ClassDao
    abstract fun conditionDao(): ConditionDao
    abstract fun damageTypeDao(): DamageTypeDao
    abstract fun equipmentCategoryDao(): EquipmentCategoryDao
    abstract fun equipmentDao(): EquipmentDao
    abstract fun featDao(): FeatDao
    abstract fun featureDao(): FeatureDao
    abstract fun languageDao(): LanguageDao
    abstract fun magicItemDao(): MagicItemDao
    abstract fun magicSchoolDao(): MagicSchoolDao
    abstract fun monsterDao(): MonsterDao
    abstract fun proficiencyDao(): ProficiencyDao
    abstract fun raceDao(): RaceDao
    abstract fun ruleDao(): RuleDao
    abstract fun ruleSectionDao(): RuleSectionDao
    abstract fun skillDao(): SkillDao
    abstract fun spellDao(): SpellDao
    abstract fun subclassDao(): SubclassDao
    abstract fun subraceDao(): SubraceDao
    abstract fun traitDao(): TraitDao
    abstract fun weaponPropertyDao(): WeaponPropertyDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null
        fun getInstance(context: Context): MainDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    MainDatabase::class.java,
                    "mainDatabase.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }


}