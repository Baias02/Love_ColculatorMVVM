package com.example.love_colculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.love_colculator.retrofit.LoveModel
import com.example.love_colculator.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getData(firstname: String, secondName: String): MutableLiveData<LoveModel> {
        val liveLove = MutableLiveData<LoveModel>()
        RetrofitService.api.getPercentage(firstname, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful)
                        liveLove.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })
        return liveLove
    }
}



