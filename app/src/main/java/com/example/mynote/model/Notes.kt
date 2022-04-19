package com.example.mynote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "title_note")
    var title: String,
    @ColumnInfo(name = "text_note")
    var textNote: String?,
    @ColumnInfo(name = "picture_note")
    var pictureNote:String,
    @ColumnInfo(name = "date_note")
    val date: String?
)





