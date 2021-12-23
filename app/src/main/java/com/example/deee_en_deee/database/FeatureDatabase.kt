package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Feature

@Database(entities = [Feature::class], version = 1)
@TypeConverters(Converters::class)
abstract class FeatureDatabase: RoomDatabase() {

    abstract fun featureDao(): FeatureDao

    companion object {
        @Volatile
        private var INSTANCE: FeatureDatabase? = null

        fun getInstance(context: Context): FeatureDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    FeatureDatabase::class.java,
                    "feature.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}