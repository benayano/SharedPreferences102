package com.example.sharedpreferences102.model

import android.content.SharedPreferences
import androidx.core.content.edit

class OnBoardingRepository(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val VISITED_ON_BOARDING_KEY = "visited_on_boarding"
        private const val NUM_OF_VISITED = "numOfVisited"
    }

    fun isOnBoardingVisited() = sharedPreferences
        .getBoolean(VISITED_ON_BOARDING_KEY, false)

    fun saveOnBoardingVisited(isVisited: Boolean) {
        sharedPreferences
            .edit {
                putBoolean(VISITED_ON_BOARDING_KEY, isVisited)
            }
    }

    fun getCounterOfVisited() = sharedPreferences
        .getInt(NUM_OF_VISITED,0)

    fun addVisited() {
        val countVisited:Int=getCounterOfVisited()
        sharedPreferences
            .edit  {
                putInt(NUM_OF_VISITED,countVisited+1)
            }
    }


}