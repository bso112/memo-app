package com.manta.data.source.local

import androidx.room.Dao
import androidx.room.Query
import com.manta.data.table.MemoTable

@Dao
interface MemoDao {

    @Query("SELECT * FROM memo")
    fun getAll() : List<MemoTable>



}