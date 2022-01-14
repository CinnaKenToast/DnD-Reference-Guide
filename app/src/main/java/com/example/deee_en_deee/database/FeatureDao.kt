package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType
import com.example.deee_en_deee.infoTypes.Feature

@Dao
interface FeatureDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(feature: Feature)

    @Update
    suspend fun update(feature: Feature)

    @Delete
    suspend fun delete(feature: Feature)

    @Query("SELECT * FROM feature WHERE (:index == `index`)")
    suspend fun getFeature(index: String): Feature

    @Query("SELECT * FROM feature")
    suspend fun getListOfFeatures(): List<Feature>?

    @Query("SELECT COUNT(*) == 0 FROM feature")
    suspend fun tableIsEmpty(): Boolean
}