package com.lonainnovs.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lonainnovs.myposts.databinding.ActivityCommentBinding
import com.lonainnovs.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var postId = 0
class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPostById()
        obtainPostId()
    }
    fun obtainPostId(){
        postId = intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPostById(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)

        request.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post = response.body()
                    binding.tvPostBody.text = post?.body
                    binding.tvPostTitle.text = post?.title
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }
}