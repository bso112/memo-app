package com.manta.data.mapper

import com.manta.domain.entity.MemoEntity
import com.manta.data.data.Memo

fun MemoEntity.toMemo() = Memo(this.content)