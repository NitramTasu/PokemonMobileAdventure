package br.com.fiap.pokemonadventure.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.fiap.pokemonadventure.data.local.dao.PokemonDao
import br.com.fiap.pokemonadventure.data.local.entity.Pokemon

@Database(entities = [Pokemon::class], version = 1)
//@TypeConverters(DateConverter::class)
abstract class MyDataBase: RoomDatabase(){
    abstract fun pokemonDao(): PokemonDao

    companion object {
        private val INSTANCE: MyDataBase? = null
    }
}