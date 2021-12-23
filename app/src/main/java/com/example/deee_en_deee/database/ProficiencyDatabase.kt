package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Proficiency

@Database(entities = [Proficiency::class], version = 1)
@TypeConverters(Converters::class)
abstract class ProficiencyDatabase: RoomDatabase() {

    abstract fun proficiencyDao(): ProficiencyDao

    companion object {
        @Volatile
        private var INSTANCE: ProficiencyDatabase? = null

        fun getInstance(context: Context): ProficiencyDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    ProficiencyDatabase::class.java,
                    "proficiency.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}