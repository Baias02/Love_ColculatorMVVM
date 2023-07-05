package com.example.love_colculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.love_colculator.retrofit.LoveModel

class LoveViewModel : ViewModel() {

    var repository = Repository()

    fun getLiveData(firstName: String, secondName:String): LiveData<LoveModel> {

        return repository.getData(firstName,secondName)

    }
}