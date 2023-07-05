package com.example.love_colculator.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.love_colculator.LoveViewModel
import com.example.love_colculator.databinding.ActivityMainBinding
import com.example.love_colculator.retrofit.LoveModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            getBtn.setOnClickListener {
                viewModel.getLiveData(fnameEd.text.toString(), snameEd.text.toString())
                    .observe(this@MainActivity, Observer { loveModel ->
                        val result = loveModel
                        val intent = Intent(this@MainActivity, ResultActivity::class.java)
                        intent.putExtra("key", result)
                        startActivity(intent)
                    })
            }
        }
    }
}