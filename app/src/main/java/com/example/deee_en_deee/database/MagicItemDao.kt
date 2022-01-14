package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.MagicItem

@Dao
interface MagicItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(magicItem: MagicItem)

    @Update
    suspend fun update(magicItem: MagicItem)

    @Delete
    suspend fun delete(magicItem: MagicItem)

    @Query("SELECT * FROM magicItem WHERE (:index == `index`)")
    suspend fun getMagicItem(index: String): MagicItem

    @Query("SELECT * FROM magicItem")
    suspend fun getListOfMagicItems(): List<MagicItem>?

    @Query("SELECT COUNT(*) == 0 FROM magicItem")
    suspend fun tableIsEmpty(): Boolean
}