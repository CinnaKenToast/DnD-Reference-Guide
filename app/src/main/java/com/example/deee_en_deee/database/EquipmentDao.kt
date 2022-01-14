package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType
import com.example.deee_en_deee.infoTypes.Equipment

@Dao
interface EquipmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(equipment: Equipment)

    @Update
    suspend fun update(equipment: Equipment)

    @Delete
    suspend fun delete(equipment: Equipment)

    @Query("SELECT * FROM equipment WHERE (:index == `index`)")
    suspend fun getEquipment(index: String): Equipment

    @Query("SELECT * FROM equipment")
    suspend fun getListOfEquipments(): List<Equipment>?

    @Query("SELECT COUNT(*) == 0 FROM equipment")
    suspend fun tableIsEmpty(): Boolean
}