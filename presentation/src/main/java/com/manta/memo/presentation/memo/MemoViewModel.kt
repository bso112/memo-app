package com.manta.memo.presentation.memo

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manta.domain.entity.MemoEntity
import com.manta.domain.usecase.memoUsecase
import com.manta.memo.data.Memo
import com.manta.memo.data.mapper.toMemo
import com.manta.memo.tools.app.AppViewModel
import com.manta.memo.tools.app.subscribeOnBackground
import com.manta.memo.tools.app.subscribeWithDisposable
import com.manta.memo.util.AppSheetState
import com.manta.memo.util.AppUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.time.LocalDate
import javax.inject.Inject

class MemoViewModel @Inject constructor(private val useCase: memoUsecase) : AppViewModel(){

    val createSheetState = MutableLiveData<AppSheetState>().apply {
        value = AppSheetState.STATE_COLLAPSED
    }

    private val _createMemoEvent = MutableLiveData<Unit>()
    val createMemoEvent : LiveData<Unit> = _createMemoEvent

    private val _memoList = MutableLiveData<List<Memo>>()
    val memoList : LiveData<List<Memo>> = _memoList


    private val _onClickCreateMemoEvent = MutableLiveData<Unit>()
    val onClickCreateMemoEvent : LiveData<Unit> = _onClickCreateMemoEvent

    fun getAll() {
        useCase.getAll()
            .subscribeOnBackground()
            .subscribeWithDisposable(this){
                _memoList.value = it.map { memo-> memo.toMemo()}
            }
    }

    fun createMemo(memo : MemoEntity) {
        useCase.createMemo(memo)
            .subscribeOnBackground()
            .subscribeWithDisposable(this){
                _createMemoEvent.value = Unit
            }
    }

    fun deleteAll(){
        useCase.deleteAllMemo()
            .subscribeOnBackground()
            .subscribeWithDisposable(this){
                AppUtil.toast("delete all")
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
    }

}