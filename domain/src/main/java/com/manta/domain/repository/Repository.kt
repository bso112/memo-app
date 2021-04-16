package com.manta.domain.repository


import com.manta.domain.data.MemoData
import io.reactivex.Completable
import io.reactivex.Single


interface Repository{
    fun getAll() : Single<List<MemoData>>
    fun createMemo(memo : MemoData) : Completable
    fun deleteAllMemo() : Completable
    fun updateMemo(memo : MemoData) : Completable
    fun deleteMemo(memo : MemoData) : Completable
}