package com.manta.domain.usecase

import com.manta.domain.data.MemoData
import com.manta.domain.repository.Repository
import javax.inject.Inject

class GetAllMemoUsecase @Inject constructor(private val repo : Repository) {
    fun getAllMemo() = repo.getAll()
}