package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType
import com.example.deee_en_deee.infoTypes.Language

@Dao
interface LanguageDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(language: Language)

    @Update
    suspend fun update(language: Language)

    @Delete
    suspend fun delete(language: Language)

    @Query("SELECT * FROM language WHERE (:index == `index`)")
    suspend fun getLanguage(index: String): Language

    @Query("SELECT * FROM language")
    suspend fun getListOfLanguages(): List<Language>?

    @Query("SELECT COUNT(*) == 0 FROM language")
    suspend fun tableIsEmpty(): Boolean
}