package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Feature

@Dao
interface FeatureDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(feature: Feature)

    @Update
    suspend fun update(feature: Feature)

    @Delete
    suspend fun delete(feature: Feature)

    @Query("SELECT * FROM feature")
    suspend fun getListOfFeatures(): List<Feature>?
}