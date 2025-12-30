package com.example.android_retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface TodoApi {

    @GET("todos")
    suspend fun getTodos(): List<Todo>

    @GET("todos/{id}")
    suspend fun getTodoById(@Path("id") id: Int): Todo

}
