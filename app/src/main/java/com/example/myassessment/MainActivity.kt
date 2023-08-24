package com.example.myassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myassessment.RecyclerView.PostAdapter
import com.example.myassessment.ViewModel.PostViewModelFactory
import com.example.myassessment.databinding.ActivityMainBinding
import com.example.myassessment.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PostViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, PostViewModelFactory()).get(PostViewModel::class.java)

        adapter = PostAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.posts.observe(this, { posts ->
            adapter.submitList(posts)
        })
    }
}