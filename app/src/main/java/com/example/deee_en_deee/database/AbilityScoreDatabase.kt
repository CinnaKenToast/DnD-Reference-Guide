package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.*
import com.example.deee_en_deee.infoTypes.AbilityScore
import com.example.deee_en_deee.infoTypes.AbilityScoreConverters

@Database(entities = [AbilityScore::class], version = 1)
@TypeConverters(AbilityScoreConverters::class)
abstract class AbilityScoreDatabase: RoomDatabase() {

    abstract fun abilityScoreDao(): AbilityScoreDao

    companion object {
        @Volatile
        private var INSTANCE: AbilityScoreDatabase? = null

        fun getInstance(context: Context): AbilityScoreDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    AbilityScoreDatabase::class.java,
                    "abilityScore.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}