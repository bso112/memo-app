package com.manta.domain.repository

import com.manta.domain.entity.MemoEntity

interface Repository{
    fun getAll() : List<MemoEntity>
    fun createMemo(memo : MemoEntity)
}