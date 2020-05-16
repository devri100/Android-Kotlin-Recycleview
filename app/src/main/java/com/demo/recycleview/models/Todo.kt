package com.demo.recycleview.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Entity
data class Todo (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var value: String,
    val date: Date
)