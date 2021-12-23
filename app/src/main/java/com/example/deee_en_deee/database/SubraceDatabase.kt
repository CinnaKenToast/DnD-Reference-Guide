package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Subrace

@Database(entities = [Subrace::class], version = 1)
@TypeConverters(Converters::class)
abstract class SubraceDatabase: RoomDatabase() {

    abstract fun subraceDao(): SubraceDao

    companion object {
        @Volatile
        private var INSTANCE: SubraceDatabase? = null

        fun getInstance(context: Context): SubraceDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    SubraceDatabase::class.java,
                    "subrace.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}