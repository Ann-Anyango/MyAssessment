package com.example.myassessment.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myassessment.Repository.PostRepository
import com.example.myassessment.viewModel.PostViewModel


class PostViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(PostRepository(ApiService.create())) as T }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}