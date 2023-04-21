package com.khanappsnj.procoreinterviewapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

const val TAG = "CardViewModel"

class CardViewModel : ViewModel() {
    private var _cards = MutableLiveData<Card>()
    val cards
        get() = _cards

    private var _finishedLoading = MutableLiveData<Boolean>(false)
    val finishedLoading
    get() = _finishedLoading

    init {
        viewModelScope.launch {
            loadData()
        }
    }

    private suspend fun loadData() {
        val client = RetrofitClient.createInstance()
        try {
            val response = client.getCards()
            if (response.isSuccessful) {
                cards.value = response.body()
                _finishedLoading.value = true
            } else {
                Log.d(TAG, "Response came back unsuccessful")
            }
        } catch (e: java.lang.Exception) {
            Log.d(TAG, "Response came back with and error")
        }
    }

    fun updateCards(onUpdate: (Card?) -> Card?) {
        _cards.postValue(onUpdate(_cards.value))
    }
}