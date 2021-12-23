package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Spell

@Database(entities = [Spell::class], version = 1)
@TypeConverters(Converters::class)
abstract class SpellDatabase: RoomDatabase() {

    abstract fun spellDao(): SpellDao

    companion object {
        @Volatile
        private var INSTANCE: SpellDatabase? = null

        fun getInstance(context: Context): SpellDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    SpellDatabase::class.java,
                    "spell.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}