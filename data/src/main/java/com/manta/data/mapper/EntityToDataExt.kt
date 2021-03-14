package com.manta.data.mapper

import com.manta.data.table.MemoTable
import com.manta.domain.entity.Memo

fun MemoTable.toMemo() = Memo(this.content)