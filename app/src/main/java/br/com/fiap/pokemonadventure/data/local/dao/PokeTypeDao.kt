package br.com.fiap.pokemonadventure.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import br.com.fiap.pokemonadventure.data.local.entity.PokeType

import br.com.fiap.pokemonadventure.data.local.entity.Pokemon

@Dao
interface PokeTypeDao{

    @Insert(onConflict = REPLACE)
    fun save(pokeType: PokeType)

    @Query("SELECT * FROM PokeType WHERE id = :id")
    fun load(id: String): LiveData<PokeType>

    @Query("SELECT * FROM  PokeType WHERE id = :id")
    fun hasPokemon(id: String): PokeType
}