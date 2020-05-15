package com.demo.base.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.base.models.Sample

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(sample: Sample): Long

    @Query("SELECT * FROM Sample")
    fun select(): LiveData<List<Sample>>


}