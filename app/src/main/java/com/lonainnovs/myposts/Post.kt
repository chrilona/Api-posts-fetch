package com.lonainnovs.myposts

data class Post(
    var userId:Int,
    var id:Int,
    var title:String,
    var body:String
)

data class Comment(
    var postId:Int,
    var id :Int,
    var name:String,
    var emai:String,
    var body: String

)
