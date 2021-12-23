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

    @Query("SELECT * FROM race")
    suspend fun getListOfRaces(): List<Race>?
}