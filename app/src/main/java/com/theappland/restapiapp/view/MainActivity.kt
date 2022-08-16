package com.theappland.restapiapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.theappland.restapiapp.R
import com.theappland.restapiapp.view.adapter.RecyclerViewAdapter
import com.theappland.restapiapp.view.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    private var postAdapter = RecyclerViewAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.refreshData()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.posts.observe(this, Observer { posts ->
            posts?.let {
                postAdapter.updateList(posts)
            }
        })
    }
}