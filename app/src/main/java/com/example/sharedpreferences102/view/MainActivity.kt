package com.example.sharedpreferences102.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.sharedpreferences102.R
import com.example.sharedpreferences102.model.OnBoardingRepository
import com.example.sharedpreferences102.viewModel.MainViewModel
import com.example.sharedpreferences102.viewModel.OnBoardingRepositoryFactory

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels {
        OnBoardingRepositoryFactory(
            OnBoardingRepository(
                PreferenceManager.getDefaultSharedPreferences(
                    this
                )
            )
        )
    }

    private val firstText: TextView by lazy { findViewById(R.id.firstText) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.bindIsVisitedOnBoarding().observe(this) {
            if (!it) {
                val onBoardingActivity = Intent(this, OnBoardingActivity::class.java)
                startActivity(onBoardingActivity)
            }

        }

        viewModel.getNumOfVisited().observe(this) { numOfVisited->
            firstText.text = "Logged into the App\n ${numOfVisited.toString()} times"
            Toast.makeText(applicationContext, "-----------------${numOfVisited.toString()}------------------", Toast.LENGTH_LONG).show()
        }

        viewModel.addNumOfVisited()

        viewModel.onMainLunched()
    }
}