package com.manta.data.repository

import android.app.Application
import androidx.room.Room
import com.manta.data.source.local.AppDatabase
import com.manta.data.Entity.MemoEntity
import com.manta.data.mapper.toData
import com.manta.data.mapper.toEntity
import com.manta.domain.data.MemoData
import com.manta.domain.repository.Repository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository  @Inject constructor(app: Application): Repository {

    private val localDB = Room.databaseBuilder(
        app, AppDatabase::class.java, "database-name"
    ).build()

    private val memoDao = localDB.memoDao()

    override fun getAll() = memoDao.getAll().map { list -> list.map { it.toData() }}
    override fun deleteAllMemo(): Completable = memoDao.deleteAllMemo()

    override fun createMemo(memo: MemoData) = memoDao.createMemo(memo.toEntity())
    override fun updateMemo(memo: MemoData) = memoDao.updateMemo(memo.toEntity())
    override fun deleteMemo(memo: MemoData) = memoDao.deleteMemo(memo.toEntity())


}


