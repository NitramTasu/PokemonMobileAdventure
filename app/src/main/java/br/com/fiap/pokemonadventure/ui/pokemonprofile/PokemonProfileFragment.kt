package br.com.fiap.pokemonadventure.ui.pokemonprofile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fiap.pokemonadventure.R
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_pokemon_profile.*
import javax.inject.Inject

class PokemonProfileFragment : Fragment() {

    @Inject
    private lateinit var viewModeFactory: ViewModelProvider.Factory

    private lateinit var viewMode: PokemonProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_profile, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpDagger()
        setUpView()
        setUpViewModel()

    }

    private fun setUpView() {
        btSearch.setOnClickListener {
            var idPokemon = etSearch.text.toString()
            viewMode.getPokemon(idPokemon)
            viewMode.pokemon.observe(this, Observer {
                tvName.text = it?.name
            })
        }
    }

    private fun setUpViewModel() {
        viewMode = ViewModelProviders.of(this, viewModeFactory)
            .get(PokemonProfileViewModel::class.java)
    }

    private fun setUpDagger() {
        AndroidSupportInjection.inject(this)
    }


}