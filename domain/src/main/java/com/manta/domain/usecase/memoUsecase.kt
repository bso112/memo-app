package com.manta.domain.usecase

import com.manta.domain.entity.MemoEntity
import com.manta.domain.repository.Repository
import javax.inject.Inject

class memoUsecase @Inject constructor(private val repo : Repository) {

    fun getAll() : List<MemoEntity>{
        return repo.getAll()
    }

    fun createMemo(memo : MemoEntity){
        repo.createMemo(memo)
    }
}