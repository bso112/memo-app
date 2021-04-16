package com.manta.domain.data

data class MemoData(
    val title: String = "",
    val content: String = "",
    val isFolder: Boolean = false,
    val date: String = "",
    val filter: Int = 0,
    val uid: Int = 0
)