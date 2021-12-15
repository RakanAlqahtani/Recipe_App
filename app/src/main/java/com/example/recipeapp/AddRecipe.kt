package com.example.recipeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeapp.API.APIClient
import com.example.recipeapp.API.APIInterface
import com.example.recipeapp.Model.Books
import com.example.recipeapp.Model.BooksItem
import kotlinx.android.synthetic.main.add_activity.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class AddRecipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)


      var apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        btSubmit.setOnClickListener{

            apiInterface?.addBooks(BooksItem(
                etTitle.text.toString(),
                etAuthor.text.toString(),
                etIngredients.text.toString(),
                etInstructions.text.toString(),
                0
            )
            )!!.enqueue(object : retrofit2.Callback<Books> {


                override fun onResponse(call: Call<Books>, response: Response<Books>) {
                    Toast.makeText(applicationContext, "User added!", Toast.LENGTH_LONG).show()
                    var intent = Intent(this@AddRecipe,MainActivity::class.java)
                    startActivity(intent)

                }

                override fun onFailure(call: Call<Books>, t: Throwable) {

                    Toast.makeText(this@AddRecipe, "Something went wrong", Toast.LENGTH_LONG).show()

                }
            })
        }

        btCancel.setOnClickListener {
            val intent = Intent(this@AddRecipe, MainActivity::class.java)
            startActivity(intent)
        }

    }
}