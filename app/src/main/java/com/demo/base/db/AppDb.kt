package com.demo.base.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.base.models.Sample

@Database(
    entities = [Sample::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDb : RoomDatabase() {

    abstract fun sampleDao(): SampleDao

}