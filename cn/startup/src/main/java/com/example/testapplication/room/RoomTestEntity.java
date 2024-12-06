package com.example.testapplication.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * com.example.testapplication.room
 * created: cuizj4
 * at : 2024/6/19-18:38
 * desc:
 * version : 1.0.0
 */

@Entity(tableName = "entityTestTable")
public class RoomTestEntity {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "name")
    private String name;
}
