package com.manta.data.source.local

import androidx.room.*
import com.manta.domain.entity.MemoEntity
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface MemoDao {
    @Query("SELECT * FROM memo")
    fun getAll() : Single<List<MemoEntity>>

    @Insert
    fun createMemo(content : MemoEntity) : Completable

    @Query("DELETE FROM Memo")
    fun deleteAllMemo() : Completable

    @Update
    fun updateMemo(content : MemoEntity) : Completable

    @Delete
    fun deleteMemo(memo : MemoEntity) : Completable





}