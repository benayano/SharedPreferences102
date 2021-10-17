package com.example.sharedpreferences102.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharedpreferences102.model.OnBoardingRepository

class MainViewModel(private val repository: OnBoardingRepository) : ViewModel() {

    private val isVisitedOnBoardingObserver = MutableLiveData<Boolean>()
    private val numOfVisitedObserver = MutableLiveData<Int>()

    fun bindIsVisitedOnBoarding(): LiveData<Boolean> = isVisitedOnBoardingObserver

    fun getNumOfVisited() = numOfVisitedObserver

    fun onMainLunched() = isVisitedOnBoardingObserver.postValue(repository.isOnBoardingVisited())

    fun forEchAppLunched()=numOfVisitedObserver.postValue(repository.getCounterOfVisited())

    fun addNumOfVisited() {
        repository.addVisited()
        forEchAppLunched()
    }

    fun onAppIsOld() = repository.saveOnBoardingVisited(isVisited = true)

}