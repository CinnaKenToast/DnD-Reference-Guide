package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Subclass

@Dao
interface SubclassDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(subclass: Subclass)

    @Update
    suspend fun update(subclass: Subclass)

    @Delete
    suspend fun delete(subclass: Subclass)

    @Query("SELECT * FROM subclass")
    suspend fun getListOfSubclasses(): List<Subclass>?

    @Query("SELECT COUNT(*) == 0 FROM subclass")
    suspend fun tableIsEmpty(): Boolean
}