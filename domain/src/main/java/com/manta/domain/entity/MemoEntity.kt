package com.manta.data.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.PropertyKey

@Entity
data class MemoTable (
    @PrimaryKey val uid : Int,
    @ColumnInfo(name = "content") val content : String  = ""
)