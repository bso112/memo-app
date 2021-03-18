package com.manta.memo.presentation.memo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manta.domain.usecase.memoUsecase
import com.manta.memo.data.Memo
import com.manta.memo.data.mapper.toMemo
import com.manta.memo.tools.app.AppViewModel
import com.manta.memo.tools.app.subscribeOnBackground
import com.manta.memo.tools.app.subscribeWithDisposable
import com.manta.memo.util.AppSheetState
import com.manta.memo.util.AppUtil
import javax.inject.Inject

class MemoViewModel @Inject constructor(private val useCase: memoUsecase) : AppViewModel(){

    val createSheetState = MutableLiveData<AppSheetState>().apply {
        value = AppSheetState.STATE_COLLAPSED
    }

    private val _memoList = MutableLiveData<List<Memo>>()
    val memoList : LiveData<List<Memo>> = _memoList

    private val _onClickCreateMemoEvent = MutableLiveData<Unit>()
    val onClickCreateMemoEvent : LiveData<Unit> = _onClickCreateMemoEvent

    private val _onClickMemoEvent = MutableLiveData<Memo>()
    val onClickMemoEvent : LiveData<Memo> = _onClickMemoEvent

    fun getAll() {
        useCase.getAll()
            .subscribeOnBackground()
            .subscribeWithDisposable(this) {
                _memoList.value = it.map { memo -> memo.toMemo() }
            }
    }



    fun onClickCreate(){
        createSheetState.value = AppSheetState.STATE_EXPANDED
    }

    fun onClickDimView(){
        if (createSheetState.value == AppSheetState.STATE_EXPANDED){
            createSheetState.value = AppSheetState.STATE_COLLAPSED
        }
    }

    fun onClickCreateMemo(){
        _onClickCreateMemoEvent.value = Unit
        createSheetState.value = AppSheetState.STATE_COLLAPSED
    }



}