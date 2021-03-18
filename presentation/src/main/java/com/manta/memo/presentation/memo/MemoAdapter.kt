package com.manta.memo.presentation.memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.manta.memo.data.Memo
import com.manta.memo.databinding.FolderItemBinding
import com.manta.memo.databinding.MemoItemBinding
import com.manta.memo.util.AppViewHolder


class MemoAdapter(private val delegate: MemoAdapterDelegate) :
    ListAdapter<Memo, AppViewHolder<Memo>>(Memo.diffUtil) {

    private val TYPE_FOLDER = 0
    private val TYPE_MEMO = 1

    class FolderViewHolder(private val binding: FolderItemBinding) : AppViewHolder<Memo>(binding) {
        override fun bindDataOnView(data: Memo) {
            binding.folderName = data.title
        }
    }

    class MemoViewHolder(private val binding: MemoItemBinding) : AppViewHolder<Memo>(binding) {
        override fun bindDataOnView(data: Memo) {
            binding.memo = data

        }
    }


    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).isFolder) TYPE_FOLDER else TYPE_MEMO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder<Memo> {
        return if (viewType == TYPE_FOLDER) {
            FolderViewHolder(
                FolderItemBinding.inflate(LayoutInflater.from(parent.context)).apply {
                    delegate = this@MemoAdapter.delegate
                }
            )
        } else
            MemoViewHolder(
                MemoItemBinding.inflate(LayoutInflater.from(parent.context)).apply {
                    delegate = this@MemoAdapter.delegate
                }
            )
    }

    override fun onBindViewHolder(holder: AppViewHolder<Memo>, position: Int) {
        holder.bindDataOnView(getItem(position))
    }

}
