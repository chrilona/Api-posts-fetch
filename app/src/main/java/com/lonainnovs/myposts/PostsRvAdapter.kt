package com.lonainnovs.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lonainnovs.myposts.databinding.PostListItemBinding

class PostsRvAdapter(var context: Context,var posts:List<Post>): RecyclerView.Adapter<PostViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding= PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
      var currentPost = posts.get(position)
      with(holder.binding){
          tvUserId.text = currentPost.userId.toString()
          tvId.text = currentPost.id.toString()
          tvTitle.text = currentPost.title
          tvBody.text = currentPost.body
       }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}
class PostViewHolder(val binding: PostListItemBinding):RecyclerView.ViewHolder(binding.root)

