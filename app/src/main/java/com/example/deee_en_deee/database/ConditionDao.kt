package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Condition

@Dao
interface ConditionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(condition: Condition)

    @Update
    suspend fun update(condition: Condition)

    @Delete
    suspend fun delete(condition: Condition)

    @Query("SELECT * FROM condition")
    suspend fun getListOfConditions(): List<Condition>?
}