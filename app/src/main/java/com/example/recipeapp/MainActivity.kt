package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.API.APIClient
import com.example.recipeapp.API.APIInterface
import com.example.recipeapp.Model.Books
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.util.*

class MainActivity : AppCompatActivity() {

    private  var books : Books = Books()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = RVAdapter(books)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)


        var apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        apiInterface?.getBooks()?.enqueue(object : Callback<Books>{
            override fun onResponse(call: Call<Books>, response: Response<Books>) {

                books = response.body()!!
                adapter.update(books)

            }

            override fun onFailure(call: Call<Books>, t: Throwable) {


            }

        })

        btnAdd.setOnClickListener{

            var intent = Intent(this,AddRecipe::class.java)
            startActivity(intent)

        }
    }
}