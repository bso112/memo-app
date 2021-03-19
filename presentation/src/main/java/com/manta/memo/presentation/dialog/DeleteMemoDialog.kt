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


    init {
        binding.dialog = this
        binding.lifecycleOwner = this
        cancelText.set("취소")
        confirmText.set("삭제")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }


}