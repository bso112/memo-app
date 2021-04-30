package com.manta.memo.presentation.creatememo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manta.memo.R
import com.manta.memo.data.Memo
import com.manta.memo.databinding.ActivityCreatememoBinding
import com.manta.memo.databinding.ActivityMainBinding
import com.manta.memo.tools.app.AppActivity
import com.manta.memo.util.AppUtil
import javax.inject.Inject

class CreateMemoActivity : AppActivity<ActivityCreatememoBinding>(R.layout.activity_creatememo) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val viewModel: CreateMemoViewModel by viewModels { factory }

    private var isUpdate = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val memo = intent.getSerializableExtra(AppUtil.EXTRA_MEMO) as? Memo
        memo?.let {
            viewModel.setMemo(it)
            isUpdate = true
        }

        binding {
            lifecycleOwner = this@CreateMemoActivity
            viewModel = this@CreateMemoActivity.viewModel
            isUpdate = this@CreateMemoActivity.isUpdate
        }

        viewModel.createMemoEvent.observe(this, Observer {
            setResult(RESULT_OK)
            finish()
        })

    }


}