package com.dimitrisligi.mvvmrestapiusingretrofitandrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dimitrisligi.mvvmrestapiusingretrofitandrecyclerview.databinding.ActivityMainBinding
import viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    //variables
    private var binding: ActivityMainBinding? = null

    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var viewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.users.observe(this,{

        })

    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
        viewModel.cancelJobs()
    }
}