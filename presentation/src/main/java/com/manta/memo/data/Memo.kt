package com.manta.memo.data

import androidx.annotation.ColorRes
import androidx.recyclerview.widget.DiffUtil
import java.io.Serializable

data class Memo(
    var id: Int = 0,
    var title: String = "",
    var content: String = "",
    var isFolder: Boolean = false,
    var date: String = "",
    @ColorRes var filter: Int = 0
) : Serializable {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Memo>() {
            override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
                return oldItem.content == newItem.content
            }

            override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
                return oldItem == newItem
            }
        }
    }

}