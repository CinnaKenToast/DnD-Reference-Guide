package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Subrace

@Dao
interface SubraceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(subrace: Subrace)

    @Update
    suspend fun update(subrace: Subrace)

    @Delete
    suspend fun delete(subrace: Subrace)

    @Query("SELECT * FROM subrace")
    suspend fun getListOfSubraces(): List<Subrace>?
}