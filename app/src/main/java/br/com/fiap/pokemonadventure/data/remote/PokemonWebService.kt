package br.com.fiap.pokemonadventure.data.remote

import br.com.fiap.pokemonadventure.data.local.entity.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonWebService {

    @GET("/pokemon/{pokemon}")
    fun getPokemon(@Path("pokemon") userId: String): Call<Pokemon>
}
