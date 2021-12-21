package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.DamageType

@Dao
interface DamageTypeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(damageType: DamageType)

    @Update
    suspend fun update(damageType: DamageType)

    @Delete
    suspend fun delete(damageType: DamageType)

    @Query("SELECT * FROM damageType")
    suspend fun getListOfDamageTypes(): List<DamageType>?
}