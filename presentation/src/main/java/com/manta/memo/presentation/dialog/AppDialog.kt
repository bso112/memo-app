package com.manta.memo.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.lifecycle.LifecycleOwner
import com.manta.memo.databinding.AppDialogLayoutBinding
import com.manta.memo.tools.app.AppLifecycleObserver
import com.manta.memo.tools.app.BuilderBase
import com.manta.memo.tools.app.LifecycleAware

open class AppDialog<T> protected constructor(builder : Builder<T>) : Dialog(builder.context), LifecycleAware {

    private var binding: AppDialogLayoutBinding =
        AppDialogLayoutBinding.inflate(LayoutInflater.from(builder.context))

    init {
        binding.icon = builder.image
        binding.setContent(builder.content)
        binding.setTitle(builder.title)
        binding.delegate = builder.delegate
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun addLifecyclerOwner(lifecyclerOwner: LifecycleOwner) {
        lifecyclerOwner.lifecycle.addObserver(this)
    }

    override fun onOwnerResume() {

    }

    override fun onOwnerPause() {

    }

    override fun onOwnerDestroy() {
        dismiss()
    }

    //꼭 있어야하는건 생성자로
    class Builder<T>(val context: Context) : BuilderBase {
        @DrawableRes
        var image : Int = 0
            set(value){ this@Builder.run { field = value }}
        var title : String = ""
            set(value){ this@Builder.run { field = value }}
        var content : String = ""
            set(value){ this@Builder.run { field = value }}
        var delegate : AppDialogDelegate<T>? = null
            set(value){ this@Builder.run { field = value }}

        fun build(): AppDialog<T> {
            return AppDialog(this)
        }

    }
}



interface AppDialogDelegate<T>{
    /**
     * @param contents : 이 다이어로그가 설명하는 대상
     * ex) 삭제 다이어로그면 삭제하는 대상
     */
    fun onConfirm(contents : T)
    fun onCancel(contents : T)
}