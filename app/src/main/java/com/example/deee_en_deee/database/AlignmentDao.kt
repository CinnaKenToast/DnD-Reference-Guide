package com.example.deee_en_deee.database

import androidx.room.*
import com.example.deee_en_deee.infoTypes.AlignmentType

@Dao
interface AlignmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(alignmentType: AlignmentType)

    @Update
    suspend fun update(alignmentType: AlignmentType)

    @Delete
    suspend fun delete(alignmentType: AlignmentType)

    @Query("SELECT * FROM alignmentType WHERE (:index == `index`)")
    suspend fun getAlignment(index: String): AlignmentType

    @Query("SELECT * FROM alignmentType")
    suspend fun getListOfAlignments(): List<AlignmentType>?

    @Query("SELECT COUNT(*) == 0 FROM alignmentType")
    suspend fun tableIsEmpty(): Boolean
}