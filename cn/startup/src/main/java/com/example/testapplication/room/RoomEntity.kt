package com.example.testapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * com.example.testapplication
 * created: cuizj4
 * at : 2024/6/14-16:18
 * desc:
 * version : 1.0.0
 */
@Entity(tableName = "entityTable")
class RoomEntity (
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "status") var status:Int=0,
){
}