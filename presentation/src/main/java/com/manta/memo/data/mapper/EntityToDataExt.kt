package com.manta.memo.data.mapper

import com.manta.domain.entity.MemoEntity
import com.manta.memo.data.Memo


fun MemoEntity.toMemo() = Memo(this.content)