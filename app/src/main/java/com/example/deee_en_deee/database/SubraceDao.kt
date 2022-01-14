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

    @Query("SELECT * FROM subrace WHERE (:index == `index`)")
    suspend fun getSubrace(index: String): Subrace

    @Query("SELECT * FROM subrace")
    suspend fun getListOfSubraces(): List<Subrace>?

    @Query("SELECT COUNT(*) == 0 FROM subrace")
    suspend fun tableIsEmpty(): Boolean
}