package com.manta.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manta.domain.entity.Memo
import com.manta.memo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.adapter = MemoAdapter()
        binding.items = emptyList<Memo>()


        setContentView(binding.root)




    }
}