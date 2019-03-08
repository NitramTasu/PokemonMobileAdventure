package br.com.fiap.pokemonadventure.di.components

import android.app.Application
import br.com.fiap.pokemonadventure.MyApplication
import br.com.fiap.pokemonadventure.di.modules.ActivityModule
import br.com.fiap.pokemonadventure.di.modules.AppModule
import br.com.fiap.pokemonadventure.di.modules.FragmentModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: MyApplication)
}