package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Monster

@Dao
interface MonsterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(monster: Monster)

    @Update
    suspend fun update(monster: Monster)

    @Delete
    suspend fun delete(monster: Monster)

    @Query("SELECT * FROM monster WHERE (:index == `index`)")
    suspend fun getMonster(index: String): Monster

    @Query("SELECT * FROM monster")
    suspend fun getListOfMonsters(): List<Monster>?

    @Query("SELECT COUNT(*) == 0 FROM monster")
    suspend fun tableIsEmpty(): Boolean
}