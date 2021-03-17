package com.manta.domain.repository

import com.manta.domain.entity.MemoEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single


interface Repository{
    fun getAll() : Single<List<MemoEntity>>
    fun createMemo(memo : MemoEntity) : Completable
}