package com.example.sharedpreferences102.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.preference.PreferenceManager
import com.example.sharedpreferences102.R
import com.example.sharedpreferences102.model.OnBoardingRepository
import com.example.sharedpreferences102.viewModel.MainViewModel
import com.example.sharedpreferences102.viewModel.OnBoardingRepositoryFactory

class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels {
        OnBoardingRepositoryFactory(OnBoardingRepository(PreferenceManager.getDefaultSharedPreferences(this)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.bindIsVisitedOnBoarding().observe(this){
            if (!it){
                val onBoardingActivity = Intent(this,OnBoardingActivity::class.java)
                startActivity(onBoardingActivity)
            }

        }
        viewModel.onMainLunched()
    }
}