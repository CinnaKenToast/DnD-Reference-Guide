package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType

@Database(entities = [AlignmentType::class], version = 1)
abstract class AlignmentDatabase: RoomDatabase() {

    abstract fun alignmentDao(): AlignmentDao

    companion object {
        @Volatile
        private var INSTANCE: AlignmentDatabase? = null

        fun getInstance(context: Context): AlignmentDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    AlignmentDatabase::class.java,
                    "alignmentType.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}