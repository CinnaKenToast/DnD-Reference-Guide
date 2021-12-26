package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.ClassType

@Dao
interface ClassDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(classType: ClassType)

    @Update
    suspend fun update(classType: ClassType)

    @Delete
    suspend fun delete(classType: ClassType)

    @Query("SELECT * FROM classType")
    suspend fun getListOfClasses(): List<ClassType>?

    @Query("SELECT COUNT(*) == 0 FROM classType")
    suspend fun tableIsEmpty(): Boolean
}