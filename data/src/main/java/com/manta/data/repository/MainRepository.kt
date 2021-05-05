package com.manta.data.repository

import android.app.Application
import androidx.room.Room
import com.manta.data.datasource.local.AppDatabase
import com.manta.data.datasource.UserDatasource
import com.manta.data.datasource.local.PreferenceUserDatasource
import com.manta.data.mapper.toData
import com.manta.data.mapper.toEntity
import com.manta.domain.data.MemoData
import com.manta.domain.data.UserData
import com.manta.domain.repository.Repository
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository  @Inject constructor(app: Application): Repository {

    private val localDB = Room.databaseBuilder(
        app, AppDatabase::class.java, "database-name"
    ).build()


    private val memoDatasource = localDB.memoDatasource()
    private val userDatasource : UserDatasource = PreferenceUserDatasource(app)

    override fun getAll() = memoDatasource.getAll().map { list -> list.map { it.toData() }}
    override fun deleteAllMemo(): Completable = memoDatasource.deleteAllMemo()

    override fun createMemo(memo: MemoData) = memoDatasource.createMemo(memo.toEntity())
    override fun updateMemo(memo: MemoData) = memoDatasource.updateMemo(memo.toEntity())
    override fun deleteMemo(memo: MemoData) = memoDatasource.deleteMemo(memo.toEntity())
    override fun getUserData(): UserData = userDatasource.getUser().toData()


}


