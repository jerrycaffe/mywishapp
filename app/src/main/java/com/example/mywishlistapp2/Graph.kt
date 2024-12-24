package com.example.mywishlistapp2

import android.content.Context
import androidx.room.Room
import com.example.mywishlistapp2.data.WishDatabase
import com.example.mywishlistapp2.data.WishRepository

//Object keyword in kotlin is used to declare a singleton, only one instance would be created. (sometimes we use it to initialize state classes and methods as well)
//here it is used as a service locator that will provide the dependency to the needed aspect of the app
object Graph {
    private lateinit var database: WishDatabase

    //by lazy introduces lazy loading i.e to be loaded only if it is needed
    //it will only be called the first time this repository is accessed
    val wishRepository by lazy { WishRepository(wishDao = database.wishDao()) }

    //to main place where the process is started. the context passed in here is the android's context
    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}