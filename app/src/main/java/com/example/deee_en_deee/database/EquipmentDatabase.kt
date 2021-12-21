package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Equipment
import com.example.deee_en_deee.infoTypes.EquipmentConverters

@Database(entities = [Equipment::class], version = 1)
@TypeConverters(EquipmentConverters::class)
abstract class EquipmentDatabase: RoomDatabase() {

    abstract fun equipmentDao(): EquipmentDao

    companion object {
        @Volatile
        private var INSTANCE: EquipmentDatabase? = null

        fun getInstance(context: Context): EquipmentDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    EquipmentDatabase::class.java,
                    "equipment.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}