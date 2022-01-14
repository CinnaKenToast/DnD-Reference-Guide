package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType
import com.example.deee_en_deee.infoTypes.Race
import com.example.deee_en_deee.infoTypes.Rule

@Dao
interface RuleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(rule: Rule)

    @Update
    suspend fun update(rule: Rule)

    @Delete
    suspend fun delete(rule: Rule)

    @Query("SELECT * FROM rule WHERE (:index == `index`)")
    suspend fun getRule(index: String): Rule

    @Query("SELECT * FROM rule")
    suspend fun getListOfRules(): List<Rule>?

    @Query("SELECT COUNT(*) == 0 FROM rule")
    suspend fun tableIsEmpty(): Boolean
}