package com.example.view_photos_pokemon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.Model.Pokemon
import com.example.view_photos_pokemon.model.PokemonDetail
import com.example.view_photos_pokemon.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(private val pokemonRepository: PokemonRepository,var i : Int) : ViewModel() {
    init {
        viewModelScope.launch (Dispatchers.IO) {
            pokemonRepository.getResults(i)
        }
    }
    val pokemon : LiveData<Pokemon>
        get() = pokemonRepository.results
}