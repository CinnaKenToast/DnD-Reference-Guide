package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.WeaponProperty

@Database(entities = [WeaponProperty::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeaponPropertyDatabase: RoomDatabase() {

    abstract fun weaponPropertyDao(): WeaponPropertyDao

    companion object {
        @Volatile
        private var INSTANCE: WeaponPropertyDatabase? = null

        fun getInstance(context: Context): WeaponPropertyDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    WeaponPropertyDatabase::class.java,
                    "weaponProperty.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}