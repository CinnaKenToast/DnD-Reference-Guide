package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Rule

@Database(entities = [Rule::class], version = 1)
@TypeConverters(Converters::class)
abstract class RuleDatabase: RoomDatabase() {

    abstract fun ruleDao(): RuleDao

    companion object {
        @Volatile
        private var INSTANCE: RuleDatabase? = null

        fun getInstance(context: Context): RuleDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    RuleDatabase::class.java,
                    "rule.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}