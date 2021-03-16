package com.manta.memo.data.mapper

import com.manta.memo.data.Memo


fun Memo.toMemo() = Memo(this.content)