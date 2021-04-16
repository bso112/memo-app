package com.manta.domain.usecase


import com.manta.domain.data.MemoData
import com.manta.domain.repository.Repository
import javax.inject.Inject

class memoUsecase @Inject constructor(private val repo : Repository) {

    fun getAll() = repo.getAll()
    fun createMemo(memo : MemoData) = repo.createMemo(memo)
    fun deleteAllMemo() = repo.deleteAllMemo()
    fun updateMemo(memo : MemoData) = repo.updateMemo(memo)
    fun deleteMemo(memo : MemoData) = repo.deleteMemo(memo)

}