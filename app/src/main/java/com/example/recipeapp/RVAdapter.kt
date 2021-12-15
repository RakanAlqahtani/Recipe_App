package com.example.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.Model.Books
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter(var book : Books): RecyclerView.Adapter<RVAdapter.ItemHolderView>() {
    class ItemHolderView(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolderView {
        return ItemHolderView(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolderView, position: Int) {

        var title = book[position].title
        var author = book[position].author
        var ingredients = book[position].ingredients
        var instructions = book[position].instructions

        holder.itemView.apply {
            tvTitle.text = title
            tvAuthor.text = author
            tvIngredients.text = ingredients
            tvInstructions.text = instructions
        }

    }

    override fun getItemCount() = book.size

    fun update(book: Books) {

        this.book = book
        notifyDataSetChanged()

    }
}