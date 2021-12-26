package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.RuleSection

@Dao
interface RuleSectionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ruleSection: RuleSection)

    @Update
    suspend fun update(ruleSection: RuleSection)

    @Delete
    suspend fun delete(ruleSection: RuleSection)

    @Query("SELECT * FROM ruleSection")
    suspend fun getListOfRuleSections(): List<RuleSection>?

    @Query("SELECT COUNT(*) == 0 FROM ruleSection")
    suspend fun tableIsEmpty(): Boolean
}