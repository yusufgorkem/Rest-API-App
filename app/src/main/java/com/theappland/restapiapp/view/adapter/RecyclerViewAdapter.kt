package com.theappland.restapiapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.theappland.restapiapp.R
import com.theappland.restapiapp.databinding.RecyclerRowBinding
import com.theappland.restapiapp.view.model.PostModel

class RecyclerViewAdapter(private val postList : ArrayList<PostModel>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    class RecyclerViewHolder(var view: RecyclerRowBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.recycler_row,parent,false)
        val view = DataBindingUtil.inflate<RecyclerRowBinding>(inflater,R.layout.recycler_row,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.view.post = postList[position]

        /*
        holder.itemView.postTitleTextView.text = postList[position].postTitle.substring(0,12)
        holder.itemView.postIdTextView.text = postList[position].userId.toString()
         */
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun updateList(newPostList: List<PostModel>) {
        postList.clear()
        postList.addAll(newPostList)
        notifyDataSetChanged()
    }
}