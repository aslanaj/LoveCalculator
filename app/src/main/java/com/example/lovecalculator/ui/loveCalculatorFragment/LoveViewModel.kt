package com.example.lovecalculator.ui.loveCalculatorFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.repository.Repository
import com.example.lovecalculator.remote.LoveModel

class LoveViewModel : ViewModel() {
    val repository = Repository()
    fun livelove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}