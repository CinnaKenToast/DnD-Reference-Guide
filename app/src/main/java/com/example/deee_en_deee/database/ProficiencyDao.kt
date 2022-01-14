package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType
import com.example.deee_en_deee.infoTypes.Proficiency

@Dao
interface ProficiencyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(proficiency: Proficiency)

    @Update
    suspend fun update(proficiency: Proficiency)

    @Delete
    suspend fun delete(proficiency: Proficiency)

    @Query("SELECT * FROM proficiency WHERE (:index == `index`)")
    suspend fun getProficiency(index: String): Proficiency

    @Query("SELECT * FROM proficiency")
    suspend fun getListOfProficiencies(): List<Proficiency>?

    @Query("SELECT COUNT(*) == 0 FROM proficiency")
    suspend fun tableIsEmpty(): Boolean
}