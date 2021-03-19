package com.manta.memo.presentation.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.manta.memo.R
import com.manta.memo.databinding.AppDialogLayoutBinding

class DeleteMemoDialog(
    context: Context
) : AppDialog(context, AppDialog.MIN_WIDTH) {

    private val binding: AppDialogLayoutBinding =
        AppDialogLayoutBinding.inflate(LayoutInflater.from(context))

    //부모가 먼저불림.
    init {
        binding.dialog = this
        binding.lifecycleOwner = 
        _imageResource.set(R.drawable.ic_baseline_delete_24)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        confirmText.set("삭제")
        cancelText.set("취소")

    }

}