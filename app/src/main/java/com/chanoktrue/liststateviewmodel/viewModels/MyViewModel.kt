package com.chanoktrue.liststateviewmodel.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.chanoktrue.liststateviewmodel.models.DataModel
import kotlin.random.Random

class MyViewModel: ViewModel() {
    //State
    private val _elements = mutableStateListOf<DataModel>()
    val elements: List<DataModel> = _elements

    //Events
    fun addElement() {
        val randomNumber = Random.nextInt(from = 1, until = 100)

        _elements.add(DataModel(email = "emaila$randomNumber", password = "password$randomNumber"))

        Log.e("ViewModel", "addElement: ${_elements.last()}", )
    }
}
