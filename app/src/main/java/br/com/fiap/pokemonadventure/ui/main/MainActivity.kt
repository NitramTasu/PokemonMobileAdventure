package br.com.fiap.pokemonadventure.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import br.com.fiap.pokemonadventure.R
import br.com.fiap.pokemonadventure.ui.pokemonprofile.PokemonProfileFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpDagger()
        setUpFragment()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    private fun setUpDagger(){
        AndroidInjection.inject(this)
    }
    private fun setUpFragment(){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, PokemonProfileFragment(), null)
            .commit()
    }
}
