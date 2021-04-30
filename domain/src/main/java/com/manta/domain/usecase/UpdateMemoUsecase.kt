package com.manta.domain.usecase

import com.manta.domain.data.MemoData
import com.manta.domain.repository.Repository
import javax.inject.Inject

class UpdateMemoUsecase  @Inject constructor(private val repo : Repository){
    fun updateMemo(memo : MemoData) = repo.updateMemo(memo)
}