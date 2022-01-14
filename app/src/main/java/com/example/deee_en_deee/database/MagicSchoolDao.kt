package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.MagicSchool

@Dao
interface MagicSchoolDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(magicSchool: MagicSchool)

    @Update
    suspend fun update(magicSchool: MagicSchool)

    @Delete
    suspend fun delete(magicSchool: MagicSchool)

    @Query("SELECT * FROM magicSchool WHERE (:index == `index`)")
    suspend fun getMagicSchool(index: String): MagicSchool

    @Query("SELECT * FROM magicSchool")
    suspend fun getListOfMagicSchools(): List<MagicSchool>?

    @Query("SELECT COUNT(*) == 0 FROM magicSchool")
    suspend fun tableIsEmpty(): Boolean
}