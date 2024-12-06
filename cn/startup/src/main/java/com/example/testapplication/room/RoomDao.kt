package com.example.testapplication.room

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Query
import androidx.room.Update


/**
 * com.example.testapplication.room
 * created: cuizj4
 * at : 2024/6/14-16:21
 * desc:
 * version : 1.0.0
 */
@Dao
interface RoomDao {


    @Update
    fun updateData(vararg entity: RoomEntity): Int

    @Query("select * from entityTable where name =:name")
    fun queryData(name:String):RoomEntity

    @Query("SELECT * FROM entityTable where status=:status")
    fun getDataList(status:Int): List<RoomEntity>// 返回一次性的用户列表
}