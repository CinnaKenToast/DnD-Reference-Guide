package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Trait

@Database(entities = [Trait::class], version = 1)
@TypeConverters(Converters::class)
abstract class TraitDatabase: RoomDatabase() {

    abstract fun traitDao(): TraitDao

    companion object {
        @Volatile
        private var INSTANCE: TraitDatabase? = null

        fun getInstance(context: Context): TraitDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    TraitDatabase::class.java,
                    "trait.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}