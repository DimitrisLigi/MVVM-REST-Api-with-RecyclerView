package com.dimitrisligi.mvvmrestapiusingretrofitandrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimitrisligi.mvvmrestapiusingretrofitandrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //variables
    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }
}