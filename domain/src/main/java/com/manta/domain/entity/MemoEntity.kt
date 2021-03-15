package com.manta.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.PropertyKey

@Entity(tableName = "memo")
data class MemoEntity (
    @PrimaryKey(autoGenerate = true) val uid : Int,
    @ColumnInfo(name = "content") val content : String  = ""
)