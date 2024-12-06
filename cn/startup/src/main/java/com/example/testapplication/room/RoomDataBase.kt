package com.example.testapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * com.example.testapplication.room
 * created: cuizj4
 * at : 2024/6/14-16:21
 * desc:
 * version : 1.0.0
 */
@Database(entities = [RoomEntity::class], exportSchema = false,version = 1)
abstract class RoomDataBase:RoomDatabase() {
    abstract fun roomDao(): RoomDao
}