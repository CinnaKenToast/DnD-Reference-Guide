package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AbilityScore

@Dao
interface AbilityScoreDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(abilityScore: AbilityScore)

    @Update
    suspend fun update(abilityScore: AbilityScore)

    @Delete
    suspend fun delete(abilityScore: AbilityScore)

    @Query("SELECT * FROM abilityScore")
    suspend fun getListOfAbilityScores(): List<AbilityScore>?

    @Query("SELECT COUNT(*) == 0 FROM abilityScore")
    suspend fun tableIsEmpty(): Boolean
}