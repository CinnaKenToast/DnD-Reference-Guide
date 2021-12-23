package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.MagicItem

@Database(entities = [MagicItem::class], version = 1)
@TypeConverters(Converters::class)
abstract class MagicItemDatabase: RoomDatabase() {

    abstract fun magicItemDao(): MagicItemDao

    companion object {
        @Volatile
        private var INSTANCE: MagicItemDatabase? = null

        fun getInstance(context: Context): MagicItemDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    MagicItemDatabase::class.java,
                    "magicItem.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}