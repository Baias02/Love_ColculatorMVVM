package com.example.love_colculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.love_colculator.databinding.ActivityResultBinding
import com.example.love_colculator.retrofit.LoveModel

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initResult()
        binding.tryAgainBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initResult() {
        val data = intent.getSerializableExtra("key") as LoveModel?
        if (data != null) {
            with(binding){
                result.text = data.result
                percentage.text = data.percentage
                resultFname.text = data.firstName
                resultSname.text = data.secondName
            }
        }
    }


}