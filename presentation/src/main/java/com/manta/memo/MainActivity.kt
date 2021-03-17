package com.manta.memo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manta.memo.databinding.ActivityMainBinding
import com.manta.memo.presentation.memo.MemoAdapter
import com.manta.memo.presentation.memo.MemoViewModel
import com.manta.memo.tools.app.AppActivity
import com.manta.memo.util.AppUtil
import com.manta.memo.util.itemdecoration.SpacingItemDecoration
import javax.inject.Inject


class MainActivity : AppActivity() {

    private val REQUEST_CREATE_MEMO = 0

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    //내부적으로 팩토리를 이용해 viewModel을 생성.
    private val memoViewModel: MemoViewModel by viewModels { factory }

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.recycler.adapter = MemoAdapter()
        binding.recycler.addItemDecoration(SpacingItemDecoration(this, 20F))
        binding.viewModel = memoViewModel
        setContentView(binding.root)

        memoViewModel.memoList.observe(this, Observer {
            it.forEach { e -> Log.d("mytest", e.toString()) }
        })

        memoViewModel.onClickCreateMemoEvent.observe(this, Observer {
            Intent(this, CreateMemoActivity::class.java).apply {
                startActivityForResult(this, REQUEST_CREATE_MEMO)
            }
        })

        memoViewModel.createMemoEvent.observe(this, Observer {
            Log.d("mytest", "inserted!")
        })

        memoViewModel.getAll()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CREATE_MEMO && resultCode == RESULT_OK) {
            AppUtil.toast("메모 생성완료!")
        }
    }

}


