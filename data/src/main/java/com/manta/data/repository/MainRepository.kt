package com.manta.data.repository

import android.app.Application
import androidx.room.Room
import com.manta.data.source.local.AppDatabase
import com.manta.domain.entity.MemoEntity
import com.manta.domain.repository.Repository
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository  @Inject constructor(app: Application): Repository {

    private val localDB = Room.databaseBuilder(
        app, AppDatabase::class.java, "database-name"
    ).build()

    private val memoDao = localDB.memoDao()

    override fun getAll() =  memoDao.getAll()

    override fun createMemo(memo: MemoEntity) = memoDao.createMemo(memo)
    override fun deleteAllMemo(): Completable = memoDao.deleteAllMemo()


}


