package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Race

@Database(entities = [Race::class], version = 1)
@TypeConverters(Converters::class)
abstract class RaceDatabase: RoomDatabase() {

    abstract fun raceDao(): RaceDao

    companion object {
        @Volatile
        private var INSTANCE: RaceDatabase? = null

        fun getInstance(context: Context): RaceDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    RaceDatabase::class.java,
                    "race.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}