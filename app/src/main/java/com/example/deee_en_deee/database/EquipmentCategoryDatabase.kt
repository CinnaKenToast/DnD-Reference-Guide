package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.*
import com.example.deee_en_deee.infoTypes.EquipmentCategory

@Database(entities = [EquipmentCategory::class], version = 1)
@TypeConverters(Converters::class)
abstract class EquipmentCategoryDatabase: RoomDatabase() {

    abstract fun equipmentCategoryDao(): EquipmentCategoryDao

    companion object {
        @Volatile
        private var INSTANCE: EquipmentCategoryDatabase? = null

        fun getInstance(context: Context): EquipmentCategoryDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    EquipmentCategoryDatabase::class.java,
                    "equipmentCategory.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}