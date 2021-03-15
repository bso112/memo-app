package com.manta.memo.presentation.memo

import androidx.lifecycle.ViewModel
import com.manta.domain.entity.MemoEntity
import com.manta.domain.usecase.memoUsecase
import javax.inject.Inject

class MemoViewModel @Inject constructor(private val useCase: memoUsecase) : ViewModel(){

    fun getAll() : List<MemoEntity> {
        return useCase.getAll()
    }

    fun createMemo(memo : MemoEntity){
        useCase.createMemo(memo)
    }
}