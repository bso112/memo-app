package com.manta.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.manta.domain.entity.MemoEntity
import java.util.*

@Dao
interface MemoDao {
    @Query("SELECT * FROM memo")
    fun getAll() : List<MemoEntity>

    @Insert
    fun createMemo(content : MemoEntity)





}