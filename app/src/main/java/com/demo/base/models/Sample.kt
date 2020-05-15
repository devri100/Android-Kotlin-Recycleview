package com.demo.base.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Entity
data class Sample (
    @PrimaryKey
    var id: Long,
    var value: String
){

    @Inject
    constructor(): this(1L, "Hello")

}