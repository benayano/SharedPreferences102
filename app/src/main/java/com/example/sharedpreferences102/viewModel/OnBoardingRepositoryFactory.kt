package com.example.sharedpreferences102.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sharedpreferences102.model.OnBoardingRepository

class OnBoardingRepositoryFactory(private val repository: OnBoardingRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java){
            return MainViewModel(repository)as T
        }else{
            throw IllegalAccessError()
        }
    }
}