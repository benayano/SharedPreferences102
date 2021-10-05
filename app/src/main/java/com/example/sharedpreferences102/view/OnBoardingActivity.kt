package com.example.sharedpreferences102.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.sharedpreferences102.R
import com.example.sharedpreferences102.model.OnBoardingRepository
import com.example.sharedpreferences102.viewModel.MainViewModel
import com.example.sharedpreferences102.viewModel.OnBoardingRepositoryFactory

class OnBoardingActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> {
        OnBoardingRepositoryFactory(
            OnBoardingRepository(
                PreferenceManager.getDefaultSharedPreferences(this)
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        viewModel.onAppIsOld()
    }
}