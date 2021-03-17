package com.manta.memo.presentation.memo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manta.domain.entity.MemoEntity
import com.manta.domain.usecase.memoUsecase
import com.manta.memo.data.Memo
import com.manta.memo.data.mapper.toMemo
import com.manta.memo.tools.app.AppViewModel
import com.manta.memo.tools.app.subscribeOnBackground
import com.manta.memo.tools.app.subscribeWithDisposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MemoViewModel @Inject constructor(private val useCase: memoUsecase) : AppViewModel(){



    private val _createMemoEvent = MutableLiveData<Unit>()
    val createMemoEvent : LiveData<Unit> = _createMemoEvent
    private val _memoList = MutableLiveData<List<Memo>>()
    val memoList : LiveData<List<Memo>> = _memoList

    fun getAll() {
        useCase.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWithDisposable(this){
                _memoList.value = it.map { memo-> memo.toMemo()}
            }
    }

    fun createMemo(memo : MemoEntity) {
        useCase.createMemo(memo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWithDisposable(this){
                _createMemoEvent.value = Unit
            }
    }

}