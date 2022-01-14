package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType
import com.example.deee_en_deee.infoTypes.ClassType
import com.example.deee_en_deee.infoTypes.Spell

@Dao
interface SpellDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(spell: Spell)

    @Update
    suspend fun update(spell: Spell)

    @Delete
    suspend fun delete(spell: Spell)

    @Query("SELECT * FROM spell WHERE (:index == `index`)")
    suspend fun getSpell(index: String): Spell

    @Query("SELECT * FROM spell")
    suspend fun getListOfSpells(): List<Spell>?

    @Query("SELECT COUNT(*) == 0 FROM spell")
    suspend fun tableIsEmpty(): Boolean
}