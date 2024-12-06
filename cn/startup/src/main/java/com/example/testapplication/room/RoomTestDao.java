package com.example.testapplication.room;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

/**
 * com.example.testapplication.room
 * created: cuizj4
 * at : 2024/6/19-18:39
 * desc:
 * version : 1.0.0
 */
@Dao
public interface RoomTestDao {
    @Update
    Integer updateData(RoomTestEntity entity);
    @Query("SELECT * FROM entityTestTable WHERE id = :id")
    Integer queryData(int id);
}
