package com.example.deee_en_deee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.deee_en_deee.infoTypes.Monster

@Database(entities = [Monster::class], version = 1)
@TypeConverters(Converters::class)
abstract class MonsterDatabase: RoomDatabase() {

    abstract fun monsterDao(): MonsterDao

    companion object {
        @Volatile
        private var INSTANCE: MonsterDatabase? = null

        fun getInstance(context: Context): MonsterDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    MonsterDatabase::class.java,
                    "monster.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}