package com.manta.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manta.data.data.Memo
import com.manta.domain.entity.MemoEntity
import com.manta.memo.databinding.ActivityMainBinding
import com.manta.memo.presentation.memo.MemoAdapter
import com.manta.memo.presentation.memo.MemoViewModel
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : ViewModelProvider.Factory
    //내부적으로 팩토리를 이용해 viewModel을 생성.
    private val memoViewModel : MemoViewModel by viewModels { factory }

    lateinit var binding : ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.adapter = MemoAdapter()
        binding.items = emptyList<Memo>()



        memoViewModel.createMemo(MemoEntity(0, "hello world!"))

        memoViewModel.getAll()

    }
}


