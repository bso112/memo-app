package com.manta.memo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.manta.domain.entity.Memo


class MemoAdapter : ListAdapter<Memo, MemoAdapter.MemoViewHolder>(Memo.diffUtil) {

    class MemoViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.memo_item, parent,false))
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}
