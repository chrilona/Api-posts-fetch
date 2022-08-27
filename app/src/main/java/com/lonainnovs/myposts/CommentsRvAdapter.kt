package com.lonainnovs.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lonainnovs.myposts.databinding.CommentsListsItemsBinding

class CommentsRvAdapter (var commentsList: List<Comment>):RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
    var binding = CommentsListsItemsBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var comments = commentsList.get(position)
        with(holder.binding){
            tvPostId.text = comments.postId.toString()
            tvIdName.text = comments.id.toString()
            tvName.text = comments.name
            tvEmail.text = comments.email
            tvBodyComments.text = comments.body
        }
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

}
class CommentViewHolder(var binding: CommentsListsItemsBinding):RecyclerView.ViewHolder(binding.root)