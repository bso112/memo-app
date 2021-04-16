package com.manta.memo.data.mapper

import com.manta.domain.data.MemoData
import com.manta.memo.data.Memo


fun MemoData.toMemo() = Memo(
    uid,
    title,
    content,
    isFolder,
    date,
    filter
)
