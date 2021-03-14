package com.manta.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.manta.data.table.MemoTable

@Database(entities = arrayOf(MemoTable::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memoDao() : MemoDao

}