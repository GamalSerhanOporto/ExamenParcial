package com.edu.ucb.examenparcial.fragments.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.edu.ucb.examenparcial.R
import com.edu.ucb.examenparcial.model.Book
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class ListFragmentDirections private constructor() {
    private data class ActionListFragmentToUpdateFragment(
        val currentBook: Book
    ) : NavDirections {
        override fun getActionId(): Int = R.id.action_listFragment_to_updateFragment

        @Suppress("CAST_NEVER_SUCCEEDS")
        override fun getArguments(): Bundle {
            val result = Bundle()
            if (Parcelable::class.java.isAssignableFrom(Book::class.java)) {
                result.putParcelable("currentBook", this.currentBook as Parcelable)
            } else if (Serializable::class.java.isAssignableFrom(Book::class.java)) {
                result.putSerializable("currentBook", this.currentBook as Serializable)
            } else {
                throw UnsupportedOperationException(Book::class.java.name +
                        " must implement Parcelable or Serializable or must be an Enum.")
            }
            return result
        }
    }

    companion object {
        fun actionListFragmentToAddFragment(): NavDirections =
            ActionOnlyNavDirections(R.id.action_listFragment_to_addFragment)

        fun actionListFragmentToUpdateFragment(currentBook: Book): NavDirections =
            ActionListFragmentToUpdateFragment(currentBook)
    }
}