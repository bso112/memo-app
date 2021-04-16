package com.manta.memo.presentation.creatememo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manta.data.Entity.MemoEntity
import com.manta.domain.usecase.memoUsecase
import com.manta.memo.R
import com.manta.memo.data.Memo
import com.manta.memo.data.mapper.toMemo
import com.manta.memo.tools.app.AppViewModel
import com.manta.memo.tools.app.subscribeOnBackground
import com.manta.memo.tools.app.subscribeWithDisposable
import com.manta.memo.util.AppUtil
import java.util.*
import javax.inject.Inject

class CreateMemoViewModel @Inject constructor(
    private val useCase: memoUsecase
) : AppViewModel() {



    private val _createMemoEvent = MutableLiveData<Memo>()
    val createMemoEvent : LiveData<Memo> = _createMemoEvent

    val editTitle = MutableLiveData("")
    val editContent = MutableLiveData("")
    private var memoID : Int = 0

    fun clickCreate(){
        createMemo(getMemo())
    }

    fun clickUpdate(){
        updateMemo(getMemo())
    }

    private fun createMemo(memo : MemoEntity) {
        useCase.createMemo(memo)
            .subscribeOnBackground()
            .subscribeWithDisposable(this) {
                _createMemoEvent.value = memo.toMemo()
            }
    }

    private fun updateMemo(memo : MemoEntity){
        useCase.updateMemo(memo)
            .subscribeOnBackground()
            .subscribeWithDisposable(this) {
                _createMemoEvent.value = memo.toMemo()
            }
    }

    private fun getMemo() = MemoEntity(
        editTitle.value!!,
        editContent.value!!,
        false,
        AppUtil.getDate(Calendar.getInstance().time),
        R.color.blue,
        memoID
    )


    fun setMemo(memo : Memo){
        editTitle.value = memo.title
        editContent.value = memo.content
        memoID = memo.id
    }




}