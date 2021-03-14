package com.manta.memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.manta.domain.entity.Memo
import com.manta.memo.databinding.FolderItemBinding
import com.manta.memo.databinding.MemoItemBinding
import com.manta.memo.util.AppViewHolder


class MemoAdapter : ListAdapter<Memo, AppViewHolder<Memo>>(Memo.diffUtil) {

    private val TYPE_FOLDER = 0
    private val TYPE_MEMO = 1

    class FolderViewHolder(private val binding : FolderItemBinding) : AppViewHolder<Memo>(binding){
        override fun bindDataOnView(data: Memo) {
            binding.folderName = data.title
        }
    }

    class MemoViewHolder(private val binding : MemoItemBinding) : AppViewHolder<Memo>(binding){
        override fun bindDataOnView(data: Memo) {
            binding.content = data.content
            binding.date = data.date
            binding.filter = data.filter
            binding.title = data.title
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).isFolder) TYPE_FOLDER else TYPE_MEMO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder<Memo> {
        return when (viewType) {
            TYPE_FOLDER -> FolderViewHolder(FolderItemBinding.inflate(LayoutInflater.from(parent.context)))
            TYPE_MEMO -> MemoViewHolder(MemoItemBinding.inflate(LayoutInflater.from(parent.context)))
            else -> FolderViewHolder(FolderItemBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }

    override fun onBindViewHolder(holder: AppViewHolder<Memo>, position: Int) {
        holder.bindDataOnView(getItem(position))
    }

}
