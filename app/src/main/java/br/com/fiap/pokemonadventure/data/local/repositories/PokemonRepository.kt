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
        refreshPokemon(pokemonId)
        return pokemonDao.load(pokemonId)
    }

    private fun refreshPokemon(pokemonId: String) {

        executor.execute {
            val pokemon = pokemonDao.hasPokemon(pokemonId) != null

            if (!pokemon){
                webService.getPokemon(pokemonId).enqueue(object : Callback<Pokemon>{
                    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                        executor.execute {
                            val pokemon = response.body()
                            if(pokemon != null){
                                pokemonDao.save(pokemon)
                            }
                        }
                    }
                    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                        println(t.message)
                    }
                })
            }
        }

    }
}



