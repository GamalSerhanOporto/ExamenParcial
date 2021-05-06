package com.edu.ucb.examenparcial.fragments.update

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
import androidx.navigation.fragment.navArgs
import com.edu.ucb.examenparcial.R
import com.edu.ucb.examenparcial.model.Book
import com.edu.ucb.examenparcial.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.fragment_add.*

import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mBookViewModel : BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        view.updateTitle_et.setText(args.currentBook.title)
        view.updateIsbn_et.setText(args.currentBook.isbn)
        view.updateAuthor_et.setText(args.currentBook.author)
        view.updatePostDate_et.setText(args.currentBook.postDate)
        view.updatePageNumber_et.setText(args.currentBook.pageNumber.toString())
        view.updateDescription_et.setText(args.currentBook.description)
        view.updatePosterPath_et.setText(args.currentBook.posterPath)

        view.updateBook_btn.setOnClickListener {
            updateItem()
        }

        return view
    }

    private  fun updateItem(){
        val title = updateTitle_et.text.toString()
        val isbn  = updateIsbn_et.text.toString()
        val author  = updateAuthor_et.text.toString()
        val postDate  = updatePostDate_et.text.toString()
        val pageNumber = Integer.parseInt(addPageNumber_et.toString())
        val description = updateDescription_et.text.toString()
        val posterPath = updatePosterPath_et.text.toString()

        if(inputCheck(title, isbn, author, postDate, description, posterPath)){
            // Create Book Object
            val updateBook = Book (title, isbn, author, postDate, pageNumber, description, posterPath)
            //Update Book Data
            mBookViewModel.updateBook(updateBook)
            Toast.makeText(requireContext(), "Book Updated Succesfully!!", Toast.LENGTH_SHORT).show()
            // Go to List
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please Fill All Fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck (title:String, isbn:String, author: String, postDate: String, description: String, posterPath: String): Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(isbn) && TextUtils.isEmpty(author) && TextUtils.isEmpty(description) && TextUtils.isEmpty(posterPath) && TextUtils.isEmpty(postDate)  )
    }
}