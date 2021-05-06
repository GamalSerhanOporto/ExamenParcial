package com.edu.ucb.examenparcial.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.edu.ucb.examenparcial.R
import com.edu.ucb.examenparcial.model.Book
import com.edu.ucb.examenparcial.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mBookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        view.addBook_btn.setOnClickListener{
            insertDataToDataBase()
        }
        return view
    }

    private fun insertDataToDataBase() {
        val title = addTitle_et.text.toString()
        val isbn = addIsbn_et.text.toString()
        val author = addAuthor_et.text.toString()
        val postDate = addPostDate_et.text.toString()
        val pageNumber =  Integer.parseInt(addPageNumber_et.text.toString())
        val description = addDescription_et.text.toString()
        val posterPath = addPosterPath_et.text.toString()

        if(inputCheck(title, isbn, author, postDate, description, posterPath)){
            // Objeto Libro Creado
            val book = Book(
                title,
                isbn,
                author,
                postDate,
                pageNumber,
                description,
                posterPath
            )
            // Add Data
            mBookViewModel.addBook(book)
            Toast.makeText(requireContext(), "Book Successfully Added!!", Toast.LENGTH_LONG).show()
            // Go to List
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else {
            Toast.makeText(requireContext(), "Please Fill All Fields", Toast.LENGTH_LONG).show()
        }
    }

   private fun inputCheck (title:String, isbn:String, author: String, postDate: String, description: String, posterPath: String): Boolean{
       return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(isbn) && TextUtils.isEmpty(author) && TextUtils.isEmpty(description) && TextUtils.isEmpty(posterPath) && TextUtils.isEmpty(postDate)  )
   }

}