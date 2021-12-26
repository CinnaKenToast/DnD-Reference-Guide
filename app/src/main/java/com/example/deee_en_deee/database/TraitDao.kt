package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Trait

@Dao
interface TraitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trait: Trait)

    @Update
    suspend fun update(trait: Trait)

    @Delete
    suspend fun delete(trait: Trait)

    @Query("SELECT * FROM trait")
    suspend fun getListOfTraits(): List<Trait>?

    @Query("SELECT COUNT(*) == 0 FROM trait")
    suspend fun tableIsEmpty(): Boolean
}