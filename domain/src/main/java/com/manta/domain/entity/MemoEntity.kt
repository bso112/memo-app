package com.manta.domain.entity

import androidx.annotation.ColorRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class MemoEntity (
    @ColumnInfo(name = "title") val title : String  = "",
    @ColumnInfo(name = "content") val content : String  = "",
    @ColumnInfo(name = "isFolder") val isFolder : Boolean  = false,
    @ColumnInfo(name = "date") val date : String  = "",
    @ColumnInfo(name = "filter") @ColorRes val filter : Int  = 0,
    @PrimaryKey(autoGenerate = true) val uid : Int = 0
    ){
}