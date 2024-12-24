package com.example.mywishlistapp2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(id = 1, title = "Google Watch 2", description = "Android Watch"),
        Wish(id = 2, title = "Oculus Quest 2", description = "A VR headset for playing games"),
        Wish(
            id = 3,
            title = "A Sci-fi, Book",
            description = "A science friction book from any best seller"
        ),
        Wish(id = 4, title = "Bean bag", description = "A comfy bean bag to substitute for a chair")
    )
}