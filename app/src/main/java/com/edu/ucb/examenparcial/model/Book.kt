package com.edu.ucb.examenparcial.model
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "book_table")
data class Book(@ColumnInfo(name = "title") val title: String, val isbn:String, val author:String, val postDate:String, val pageNumber:Int, val description:String, val posterPath:String) :
    Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}
