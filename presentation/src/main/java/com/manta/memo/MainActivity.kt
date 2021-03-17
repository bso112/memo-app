package com.manta.memo

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manta.domain.entity.MemoEntity
import com.manta.memo.data.Memo
import com.manta.memo.databinding.ActivityMainBinding
import com.manta.memo.presentation.memo.MemoAdapter
import com.manta.memo.presentation.memo.MemoViewModel
import com.manta.memo.tools.app.AppActivity
import javax.inject.Inject


class MainActivity : AppActivity() {

    @Inject
    lateinit var factory : ViewModelProvider.Factory
    //내부적으로 팩토리를 이용해 viewModel을 생성.
    private val memoViewModel : MemoViewModel by viewModels { factory }

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recycler.adapter = MemoAdapter()
        setContentView(binding.root)

        memoViewModel.createMemoEvent.observe(this, Observer {
            Log.d("mytest", "inserted!")
        })

        memoViewModel.memoList.observe(this, Observer {
            it.forEach{ e -> Log.d("mytest", e.toString())}
        })
        memoViewModel.createMemo(MemoEntity(0, "asdasd"))
        memoViewModel.getAll()

    }

}


