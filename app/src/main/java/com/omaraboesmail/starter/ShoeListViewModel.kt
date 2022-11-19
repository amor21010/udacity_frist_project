package com.omaraboesmail.starter


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.omaraboesmail.starter.models.Shoe

class ShoeListViewModel : ViewModel() {
   private  val _shoesList= MutableLiveData<List<Shoe>>(emptyList())
    val shoesList: MutableLiveData<List<Shoe>> get()=_shoesList

    fun addShoeToList(shoe: Shoe){
        _shoesList.value= _shoesList.value?.plus(shoe)
    }

}