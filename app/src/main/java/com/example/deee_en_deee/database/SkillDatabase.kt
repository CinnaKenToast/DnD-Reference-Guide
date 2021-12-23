package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Skill

@Database(entities = [Skill::class], version = 1)
@TypeConverters(Converters::class)
abstract class SkillDatabase: RoomDatabase() {

    abstract fun skillDao(): SkillDao

    companion object {
        @Volatile
        private var INSTANCE: SkillDatabase? = null

        fun getInstance(context: Context): SkillDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    SkillDatabase::class.java,
                    "skill.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}