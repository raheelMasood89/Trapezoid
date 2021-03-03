package com.example.trapeziumcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trapeziumcards.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: PopularListAdapter
    private lateinit var binding: ActivityMainBinding
    val mData = arrayOf<Result>(
       Result(""),
        Result(""),
        Result(""),
        Result(""),
        Result(""),
        Result(""),
        Result(""),
        Result(""),
        Result("")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = PopularListAdapter(PopularListAdapter.PopularListClickListener { movieID ->
        })
        adapter.submitList(mData.toMutableList())
        binding.rv.adapter = adapter
    }
}