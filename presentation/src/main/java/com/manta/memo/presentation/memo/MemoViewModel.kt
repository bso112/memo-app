package com.manta.memo.presentation.memo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manta.domain.usecase.*
import com.manta.memo.data.Memo
import com.manta.memo.data.mapper.toData
import com.manta.memo.data.mapper.toMemo
import com.manta.memo.tools.app.AppViewModel
import com.manta.memo.tools.app.subscribeOnBackground
import com.manta.memo.tools.app.subscribeWithDisposable
import com.manta.memo.tools.app.toLiveData
import com.manta.memo.util.AppSheetState
import javax.inject.Inject

class MemoViewModel @Inject constructor(
    private val deleteMemoUsecase: DeleteMemoUsecase,
    private val getAllMemoUsecase: GetAllMemoUsecase
) : AppViewModel(), MemoAdapterDelegate{

    val createSheetState = MutableLiveData<AppSheetState>().apply {
        value = AppSheetState.STATE_COLLAPSED
    }



    private val _memoList = MutableLiveData<List<Memo>>()
    val memoList = _memoList.toLiveData()

    private val _onClickCreateMemoEvent = MutableLiveData<Unit>()
    val onClickCreateMemoEvent = _onClickCreateMemoEvent.toLiveData()

    private val  _onClickMemoEvent = MutableLiveData<Memo>()
    val onClickMemoEvent  = _onClickMemoEvent.toLiveData()

    private val _onLongClickMemoEvent = MutableLiveData<Memo>()
    val onLongClickMemoEvent  = _onLongClickMemoEvent.toLiveData()


    fun getAll() {
        getAllMemoUsecase.getAllMemo()
            .subscribeOnBackground()
            .subscribeWithDisposable(this) {
                _memoList.value = it.map { memo -> memo.toMemo() }
            }
    }


    fun deleteMemo(memo : Memo){
        deleteMemoUsecase.deleteMemo(memo.toData())
            .subscribeOnBackground()
            .subscribeWithDisposable(this){

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

    override fun clickMemo(memo: Memo) {
        _onClickMemoEvent.value = memo
    }

    override fun longClickMemo(memo: Memo) {
        _onLongClickMemoEvent.value = memo
    }

    override fun clickFolder() {

    }



}