package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.MagicSchool

@Database(entities = [MagicSchool::class], version = 1)
@TypeConverters(Converters::class)
abstract class MagicSchoolDatabase: RoomDatabase() {

    abstract fun magicSchoolDao(): MagicSchoolDao

    companion object {
        @Volatile
        private var INSTANCE: MagicSchoolDatabase? = null

        fun getInstance(context: Context): MagicSchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    MagicSchoolDatabase::class.java,
                    "magicSchool.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}