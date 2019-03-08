package br.com.fiap.pokemonadventure.di.modules

import br.com.fiap.pokemonadventure.ui.pokemonprofile.PokemonProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeUserProfileFragment(): PokemonProfileFragment
}