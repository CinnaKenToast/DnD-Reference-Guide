package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Feat

@Dao
interface FeatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(feat: Feat)

    @Update
    suspend fun update(feat: Feat)

    @Delete
    suspend fun delete(feat: Feat)

    @Query("SELECT * FROM feat")
    suspend fun getListOfFeats(): List<Feat>?
}