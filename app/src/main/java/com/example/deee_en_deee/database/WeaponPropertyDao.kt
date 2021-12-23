package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.WeaponProperty

@Dao
interface WeaponPropertyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(weaponProperty: WeaponProperty)

    @Update
    suspend fun update(weaponProperty: WeaponProperty)

    @Delete
    suspend fun delete(weaponProperty: WeaponProperty)

    @Query("SELECT * FROM weaponProperty")
    suspend fun getListOfWeaponProperties(): List<WeaponProperty>?
}