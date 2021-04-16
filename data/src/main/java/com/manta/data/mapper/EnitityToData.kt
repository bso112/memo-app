package com.manta.data.mapper

import com.manta.data.Entity.MemoEntity
import com.manta.domain.data.MemoData

fun MemoEntity.toData() : MemoData {
   return MemoData(title, content, isFolder, date, filter, uid)
}

fun MemoData.toEntity() : MemoEntity {
   return MemoEntity(title, content, isFolder, date, filter, uid)
}