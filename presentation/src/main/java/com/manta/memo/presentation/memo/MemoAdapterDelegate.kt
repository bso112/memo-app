package com.manta.memo.presentation.memo

import com.manta.memo.data.Memo

interface MemoAdapterDelegate {
    fun clickMemo(memo : Memo)
    fun clickFolder()
}