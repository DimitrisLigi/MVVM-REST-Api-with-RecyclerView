package com.dimitrisligi.mvvmrestapiusingretrofitandrecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dimitrisligi.mvvmrestapiusingretrofitandrecyclerview.databinding.ActivityMainBinding
import recyclerviewadapter.MyRecyclerViewAdapter
import viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    //variables
    private var binding: ActivityMainBinding? = null

    private lateinit var myRecyclerViewAdapter : MyRecyclerViewAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var viewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initRecyclerView()
        getDATA()

    }

    fun initRecyclerView(){
        binding?.rvFeed?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            myRecyclerViewAdapter = MyRecyclerViewAdapter()
            adapter = myRecyclerViewAdapter
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun getDATA(){
        viewModel.users.observe(this,{
            myRecyclerViewAdapter.setListOfUsers(it.data as MutableList)
            myRecyclerViewAdapter.notifyDataSetChanged()
//            Toast.makeText(this,it.data[0].firstName,Toast.LENGTH_LONG).show()
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
        viewModel.cancelJobs()
    }
}