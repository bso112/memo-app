package com.manta.memo.presentation.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
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
        _imageResource.value = R.drawable.ic_baseline_delete_24
        title.value = "삭제하시겠어요?"
        content.value = "삭제한 메모는 휴지통에 30일간 보관됩니다."
        cancelText.value = "취소"
        confirmText.value = "삭제"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }


}