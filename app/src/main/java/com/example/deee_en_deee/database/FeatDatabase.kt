package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.ClassType
import com.example.deee_en_deee.infoTypes.ClassTypeConverters
import com.example.deee_en_deee.infoTypes.Feat
import com.example.deee_en_deee.infoTypes.FeatConverters

@Database(entities = [Feat::class], version = 1)
@TypeConverters(FeatConverters::class)
abstract class FeatDatabase: RoomDatabase() {

    abstract fun featDao(): FeatDao

    companion object {
        @Volatile
        private var INSTANCE: FeatDatabase? = null

        fun getInstance(context: Context): FeatDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    FeatDatabase::class.java,
                    "feat.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}