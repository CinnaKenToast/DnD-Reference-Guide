package com.example.deee_en_deee.ui

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.deee_en_deee.database.AbilityScoreDatabase
import com.example.deee_en_deee.infoTypes.AbilityScore
import com.example.deee_en_deee.infoTypes.InitialReferences
import com.example.deee_en_deee.useCase.CategoryFetcherUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AbilityScoreViewModel(application: Application): AndroidViewModel(application) {
    private val categoryFetcherUseCase = CategoryFetcherUseCase()
    val isLoading = mutableStateOf(true)

    val abilityScoreDao = AbilityScoreDatabase.getInstance(application.applicationContext).abilityScoreDao()
    val listOfCategory = mutableStateOf(InitialReferences())
    val listOfAbilityScores = mutableStateOf(listOf<AbilityScore>())

    init {
        viewModelScope.launch {
            categoryFetcherUseCase.getCategoryList(listOfCategory)
        }
    }

    private fun setLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }


    private suspend fun isAbilityScoreEmpty(): Boolean {
        return abilityScoreDao.tableIsEmpty()
    }

    fun getAbilityScore(index: String): AbilityScore {
        val abilityScore: AbilityScore
        runBlocking {
            setLoading(true)
            abilityScore = abilityScoreDao.getAbilityScore(index)
            setLoading(false)
        }
        return abilityScore
    }

    fun getAbilityScoreList() {
        viewModelScope.launch {
            Log.d("debug2", "ABILITY SCORE EMPTY: ${isAbilityScoreEmpty()}")
            setLoading(true)
            categoryFetcherUseCase.getAbilityScoreList(listOfCategory.value.abilityScore, listOfAbilityScores, abilityScoreDao)
            setLoading(false)
        }
    }
}

class AbilityScoreViewModelFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T: ViewModel?> create (modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(application)
    }
}