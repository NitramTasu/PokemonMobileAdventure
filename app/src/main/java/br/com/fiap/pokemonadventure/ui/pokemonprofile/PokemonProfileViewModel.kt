package br.com.fiap.pokemonadventure.ui.pokemonprofile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.fiap.pokemonadventure.data.local.entity.Pokemon
import br.com.fiap.pokemonadventure.data.local.repositories.PokemonRepository
import javax.inject.Inject

class PokemonProfileViewModel @Inject constructor(
    var pokemonRepository: PokemonRepository ): ViewModel(){

    var pokemon: LiveData<Pokemon> = MutableLiveData<Pokemon>()

    fun getPokemon(pokemonId: String){
        pokemon = pokemonRepository.getPokemon(pokemonId)
    }
}