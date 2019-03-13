package br.com.fiap.pokemonadventure.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import br.com.fiap.pokemonadventure.data.local.MyDataBase
import br.com.fiap.pokemonadventure.data.local.dao.PokemonDao
import br.com.fiap.pokemonadventure.data.local.repositories.PokemonRepository
import br.com.fiap.pokemonadventure.data.remote.PokemonWebService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): MyDataBase {
        return Room.databaseBuilder(
            application,
            MyDataBase::class.java,
            "pokemonapi.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePokemon(dataBase: MyDataBase): PokemonDao {
        return dataBase.pokemonDao()
    }

    @Provides
    @Singleton
    fun provideExecutor(): Executor{
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor( StethoInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://pokeapi.co/api/v2/")
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonWebService(retrofit: Retrofit): PokemonWebService {
        return retrofit.create(PokemonWebService::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(pokemonWebService: PokemonWebService, pokemonDao: PokemonDao, executor: Executor): PokemonRepository{
        return PokemonRepository(pokemonWebService, pokemonDao, executor)
    }
}