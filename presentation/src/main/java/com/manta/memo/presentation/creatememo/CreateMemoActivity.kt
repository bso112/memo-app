package com.manta.memo.presentation.creatememo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manta.memo.data.Memo
import com.manta.memo.databinding.ActivityCreatememoBinding
import com.manta.memo.tools.app.AppActivity
import com.manta.memo.util.AppUtil
import javax.inject.Inject

class CreateMemoActivity : AppActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val viewModel: CreateMemoViewModel by viewModels { factory }

    lateinit var binding: ActivityCreatememoBinding

    private var isUpdate = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val memo = intent.getSerializableExtra(AppUtil.EXTRA_MEMO) as? Memo
        memo?.let {
            viewModel.setMemo(it)
            isUpdate = true
        }

        binding = ActivityCreatememoBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.isUpdate = isUpdate

        setContentView(binding.root)

        viewModel.createMemoEvent.observe(this, Observer {
            setResult(RESULT_OK)
            finish()
        })

    }


}