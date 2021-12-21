package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType
import com.example.deee_en_deee.infoTypes.ClassType
import com.example.deee_en_deee.infoTypes.ClassTypeConverters

@Database(entities = [ClassType::class], version = 1)
@TypeConverters(ClassTypeConverters::class)
abstract class ClassDatabase: RoomDatabase() {

    abstract fun classDao(): ClassDao

    companion object {
        @Volatile
        private var INSTANCE: ClassDatabase? = null

        fun getInstance(context: Context): ClassDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    ClassDatabase::class.java,
                    "classType.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}