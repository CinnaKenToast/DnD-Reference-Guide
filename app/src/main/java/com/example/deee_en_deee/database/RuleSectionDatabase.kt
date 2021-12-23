package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.RuleSection

@Database(entities = [RuleSection::class], version = 1)
@TypeConverters(Converters::class)
abstract class RuleSectionDatabase: RoomDatabase() {

    abstract fun ruleSectionDao(): RuleSectionDao

    companion object {
        @Volatile
        private var INSTANCE: RuleSectionDatabase? = null

        fun getInstance(context: Context): RuleSectionDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    RuleSectionDatabase::class.java,
                    "ruleSection.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}