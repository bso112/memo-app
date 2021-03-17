package com.manta.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.manta.domain.entity.MemoEntity
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface MemoDao {
    @Query("SELECT * FROM memo")
    fun getAll() : Single<List<MemoEntity>>

    @Insert
    fun createMemo(content : MemoEntity) : Completable





}