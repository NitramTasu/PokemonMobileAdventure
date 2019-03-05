package br.com.fiap.pokemonadventure.data.local.repositories

import android.arch.lifecycle.LiveData
import br.com.fiap.pokemonadventure.data.local.dao.PokemonDao
import br.com.fiap.pokemonadventure.data.local.entity.Pokemon
import br.com.fiap.pokemonadventure.data.remote.PokemonWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val webService: PokemonWebService,
    private val pokemonDao: PokemonDao,
    private val executor: Executor
) {

    fun getPokemon(pokemonId: String): LiveData<Pokemon> {
        return pokemonDao.load(pokemonId)
    }

    fun savePokemonWeb(pokemonId: String) {
        webService.getPokemon(pokemonId).enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                executor.execute {
                    val pokemon = response.body()
                    if (pokemon != null) {
                        pokemonDao.save(pokemon)
                    }
                }
            }
            override fun onFailure(call: Call<Pokemon>, t: Throwable) {

            }
        })
    }

}



