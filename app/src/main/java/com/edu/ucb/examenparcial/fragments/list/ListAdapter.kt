package com.edu.ucb.examenparcial.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.edu.ucb.examenparcial.R
import com.edu.ucb.examenparcial.model.Book
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var bookList = emptyList<Book>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false))
    }

    override fun getItemCount(): Int {
        return  bookList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val picasso = Picasso.get()
        val currentItem =  bookList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.title_txt.text = currentItem.title
        holder.itemView.isbn_txt.text = currentItem.isbn
        holder.itemView.author_txt.text = currentItem.author
        holder.itemView.postDate_txt.text = currentItem.postDate
        holder.itemView.pageNumber_txt.text = currentItem.pageNumber.toString()
        holder.itemView.description_txt.text = currentItem.author
        picasso.load(currentItem.posterPath)
            .into(holder.itemView.my_image_view)

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun setData (books : List <Book>){
        this.bookList = books
        notifyDataSetChanged()
    }



}