package com.example.testapplication.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * com.example.testapplication.room
 * created: cuizj4
 * at : 2024/6/19-18:40
 * desc:
 * version : 1.0.0
 */
@Database(entities = {RoomEntity.class},version = 2)
abstract class RoomTestDataBase extends RoomDatabase {
    abstract RoomDao roomDao();
}
