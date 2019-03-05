package br.com.fiap.pokemonadventure.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.fiap.pokemonadventure.di.keys.ViewModelKey
import br.com.fiap.pokemonadventure.ui.pokemonprofile.PokemonProfileViewModel
import br.com.fiap.pokemonadventure.util.viewmodel.FactoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract  class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonProfileViewModel::class)
    abstract fun bindPokemonViewModel(repoViewModel: PokemonProfileViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel): ViewModelProvider.Factory

}