package com.manta.memo.data.mapper

import com.manta.domain.entity.MemoEntity
import com.manta.memo.data.Memo

fun Memo.toEntity() = MemoEntity(
    title,
    content,
    isFolder,
    date,
    filter,
    id
)