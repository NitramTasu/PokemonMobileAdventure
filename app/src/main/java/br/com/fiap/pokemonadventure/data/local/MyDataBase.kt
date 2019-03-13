package br.com.fiap.pokemonadventure.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import br.com.fiap.pokemonadventure.data.local.converter.ListTypeConverter
import br.com.fiap.pokemonadventure.data.local.dao.PokemonDao
import br.com.fiap.pokemonadventure.data.local.entity.Pokemon

@Database(entities = [Pokemon::class], version = 1)
@TypeConverters(ListTypeConverter::class)
abstract class MyDataBase: RoomDatabase(){
    abstract fun pokemonDao(): PokemonDao

    companion object {
        private val INSTANCE: MyDataBase? = null
    }
}