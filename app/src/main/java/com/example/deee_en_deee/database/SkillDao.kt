package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Skill

@Dao
interface SkillDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(skill: Skill)

    @Update
    suspend fun update(skill: Skill)

    @Delete
    suspend fun delete(skill: Skill)

    @Query("SELECT * FROM skill WHERE (:index == `index`)")
    suspend fun getSkill(index: String): Skill

    @Query("SELECT * FROM skill")
    suspend fun getListOfSkills(): List<Skill>?

    @Query("SELECT COUNT(*) == 0 FROM skill")
    suspend fun tableIsEmpty(): Boolean
}