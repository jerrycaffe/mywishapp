package com.example.mywishlistapp2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp2.data.Wish
import com.example.mywishlistapp2.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: WishRepository = Graph.wishRepository) :
    ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String) {
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String) {
        wishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch { getAllWishes = wishRepository.getWishes() }
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) { wishRepository.addWish(wish) }
    }

    fun updateAWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) { wishRepository.updateAWish(wish) }
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishRepository.getWishById(id)
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) { wishRepository.deleteAWish(wish) }

    }
}