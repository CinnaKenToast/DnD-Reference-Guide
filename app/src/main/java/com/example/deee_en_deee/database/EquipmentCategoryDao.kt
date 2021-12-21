package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.EquipmentCategory

@Dao
interface EquipmentCategoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(equipmentCategory: EquipmentCategory)

    @Update
    suspend fun update(equipmentCategory: EquipmentCategory)

    @Delete
    suspend fun delete(equipmentCategory: EquipmentCategory)

    @Query("SELECT * FROM equipmentCategory")
    suspend fun getListOfEquipmentCategories(): List<EquipmentCategory>?
}