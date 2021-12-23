package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Language

@Database(entities = [Language::class], version = 1)
@TypeConverters(Converters::class)
abstract class LanguageDatabase: RoomDatabase() {

    abstract fun languageDao(): LanguageDao

    companion object {
        @Volatile
        private var INSTANCE: LanguageDatabase? = null

        fun getInstance(context: Context): LanguageDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    LanguageDatabase::class.java,
                    "language.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}