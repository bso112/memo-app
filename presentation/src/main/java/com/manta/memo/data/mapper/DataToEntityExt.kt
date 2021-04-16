package com.manta.memo.data.mapper

import com.manta.domain.data.MemoData
import com.manta.memo.data.Memo

fun Memo.toData() = MemoData(
    title,
    content,
    isFolder,
    date,
    filter,
    id
)