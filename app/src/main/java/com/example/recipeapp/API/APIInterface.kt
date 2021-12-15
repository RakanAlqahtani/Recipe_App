package com.example.recipeapp.API

import com.example.recipeapp.Model.Books
import com.example.recipeapp.Model.BooksItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {


    @GET("recipes/")
    fun getBooks(): retrofit2.Call<Books>

    @POST("recipes/")
    fun addBooks(@Body book: BooksItem) : retrofit2.Call<Books>
}