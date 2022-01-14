package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.Race

@Dao
interface RaceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(race: Race)

    @Update
    suspend fun update(race: Race)

    @Delete
    suspend fun delete(race: Race)

    @Query("SELECT * FROM race WHERE (:index == `index`)")
    suspend fun getRace(index: String): Race

    @Query("SELECT * FROM race")
    suspend fun getListOfRaces(): List<Race>?

    @Query("SELECT COUNT(*) == 0 FROM race")
    suspend fun tableIsEmpty(): Boolean
}