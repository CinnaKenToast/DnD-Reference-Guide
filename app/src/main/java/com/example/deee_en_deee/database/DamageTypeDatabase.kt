package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.*
import com.example.deee_en_deee.infoTypes.*

@Database(entities = [DamageType::class], version = 1)
@TypeConverters(Converters::class)
abstract class DamageTypeDatabase: RoomDatabase() {

    abstract fun damageTypeDao(): DamageTypeDao

    companion object {
        @Volatile
        private var INSTANCE: DamageTypeDatabase? = null

        fun getInstance(context: Context): DamageTypeDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    DamageTypeDatabase::class.java,
                    "damageType.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}