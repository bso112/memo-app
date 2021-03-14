package com.manta.memo.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.manta.memo.AppAdapter

object RecyclerVIewBindings {

    @JvmStatic
    @BindingAdapter("adapter")
    fun RecyclerView.bindingAdapter(adapter: RecyclerView.Adapter<*>) {
        this.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("items")
    fun RecyclerView.setItems(items: List<*>) {
        if (this.adapter is AppAdapter) {
            (this.adapter as AppAdapter).submitList(items)
        }
    }
}