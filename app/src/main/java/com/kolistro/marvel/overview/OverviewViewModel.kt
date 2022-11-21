package com.kolistro.marvel.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolistro.marvel.network.MarvelApi
import com.kolistro.marvel.network.characters.Characters
import kotlinx.coroutines.launch

enum class MarvelApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel: ViewModel() {
    private val _status = MutableLiveData<MarvelApiStatus>()
    val status: LiveData<MarvelApiStatus> = _status

    private val _marvelData = MutableLiveData<Characters>()
    val marvelData: LiveData<Characters> = _marvelData

    private val _character = MutableLiveData<com.kolistro.marvel.network.characters.Result>()
    var character: LiveData<com.kolistro.marvel.network.characters.Result> = _character

    val _id = MutableLiveData<String>()
    var id: LiveData<String> = _id


    private fun getMarvelData(){
        viewModelScope.launch {
            _status.value=MarvelApiStatus.LOADING
            try {
                _marvelData.value = MarvelApi.retrofitService.getMarvelCharacters()
                _status.value = MarvelApiStatus.DONE
            }catch (e: Exception){
                _status.value = MarvelApiStatus.ERROR
                _marvelData.value = null
            }
        }
    }

    private fun getMarvelHero(){
        viewModelScope.launch {
            _status.value = MarvelApiStatus.LOADING
            try {
                _character.value = MarvelApi.retrofitService2.getHero(_id.value)
                _status.value = MarvelApiStatus.DONE
            }catch (e: Exception){
                _status.value = MarvelApiStatus.ERROR
                _character.value = null
            }
        }
    }


    init {
        getMarvelData()
        getMarvelHero()
    }
}