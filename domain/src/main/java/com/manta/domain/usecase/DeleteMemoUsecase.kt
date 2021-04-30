package com.manta.domain.usecase

import com.manta.domain.data.MemoData
import com.manta.domain.repository.Repository
import javax.inject.Inject



class DeleteMemoUsecase @Inject constructor(private val repo : Repository) {
    fun deleteMemo(memo : MemoData) = repo.deleteMemo(memo)
}