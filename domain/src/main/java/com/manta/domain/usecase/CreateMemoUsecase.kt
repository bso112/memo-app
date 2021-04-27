package com.manta.domain.usecase

import com.manta.domain.data.MemoData
import com.manta.domain.repository.Repository
import javax.inject.Inject

class CreateMemoUsecase @Inject constructor(private val repo : Repository) {
    fun createMemo(memo : MemoData) = repo.createMemo(memo)
}