package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Subclass

@Database(entities = [Subclass::class], version = 1)
@TypeConverters(Converters::class)
abstract class SubclassDatabase: RoomDatabase() {

    abstract fun subclassDao(): SubclassDao

    companion object {
        @Volatile
        private var INSTANCE: SubclassDatabase? = null

        fun getInstance(context: Context): SubclassDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    SubclassDatabase::class.java,
                    "subclass.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}