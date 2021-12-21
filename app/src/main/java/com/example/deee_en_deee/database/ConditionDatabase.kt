package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Condition
import com.example.deee_en_deee.infoTypes.ConditionConverters

@Database(entities = [Condition::class], version = 1)
@TypeConverters(ConditionConverters::class)
abstract class ConditionDatabase: RoomDatabase() {

    abstract fun conditionDao(): ConditionDao

    companion object {
        @Volatile
        private var INSTANCE: ConditionDatabase? = null

        fun getInstance(context: Context): ConditionDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    ConditionDatabase::class.java,
                    "condition.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}