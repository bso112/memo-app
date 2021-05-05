package com.manta.data.mapper

import com.manta.data.Entity.MemoEntity
import com.manta.data.Entity.UserEntity
import com.manta.domain.data.MemoData
import com.manta.domain.data.UserData

fun MemoEntity.toData() : MemoData {
   return MemoData(title, content, isFolder, date, filter, uid)
}

fun MemoData.toEntity() : MemoEntity {
   return MemoEntity(title, content, isFolder, date, filter, uid)
}

fun UserEntity.toData() : UserData {
   return UserData(name)
}

fun UserData.toEntity() : UserEntity{
   return UserEntity(name)
}