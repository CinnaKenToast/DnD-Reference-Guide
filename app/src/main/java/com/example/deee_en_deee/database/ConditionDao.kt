package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType
import com.example.deee_en_deee.infoTypes.Condition

@Dao
interface ConditionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(condition: Condition)

    @Update
    suspend fun update(condition: Condition)

    @Delete
    suspend fun delete(condition: Condition)

    @Query("SELECT * FROM condition WHERE (:index == `index`)")
    suspend fun getCondition(index: String): Condition

    @Query("SELECT * FROM condition")
    suspend fun getListOfConditions(): List<Condition>?

    @Query("SELECT COUNT(*) == 0 FROM condition")
    suspend fun tableIsEmpty(): Boolean
}