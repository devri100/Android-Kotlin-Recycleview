package com.demo.recycleview.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.recycleview.models.Todo

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: Todo): Long

    @Query("SELECT * FROM Todo")
    fun select(): LiveData<List<Todo>>


}