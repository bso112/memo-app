package com.manta.memo.presentation.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import com.manta.memo.R
import com.manta.memo.databinding.AppDialogLayoutBinding
import com.manta.memo.util.AppUtil

class DeleteMemoDialog(
    context: Context
) : AppDialog(context, AppDialog.MIN_WIDTH) {

    private val binding: AppDialogLayoutBinding =
        AppDialogLayoutBinding.inflate(LayoutInflater.from(context))

    init {
        _imageResource.value = R.drawable.ic_baseline_delete_24
        title.value = "삭제 할까요?"
        content.value = "삭제한 메일이 30일간 휴지통에 보관됩니다."
        cancelText.value = "취소"
        confirmText.value = "삭제"
        binding.dialog = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window?.attributes?.width = AppUtil.dp2Px(context, 300F)
        window?.attributes?.height = WindowManager.LayoutParams.WRAP_CONTENT

    }




}