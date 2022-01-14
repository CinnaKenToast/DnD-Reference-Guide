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

    @Query("SELECT * FROM feat WHERE (:index == `index`)")
    suspend fun getFeat(index: String): Feat

    @Query("SELECT * FROM feat")
    suspend fun getListOfFeats(): List<Feat>?

    @Query("SELECT COUNT(*) == 0 FROM feat")
    suspend fun tableIsEmpty(): Boolean
}