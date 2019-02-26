package br.com.fiap.pokemonadventure.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

import br.com.fiap.pokemonadventure.data.local.entity.Pokemon

interface PokemonDao{

    @Insert(onConflict = REPLACE)
    fun save(pokemon: Pokemon)

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    fun load(id: Int): LiveData<Pokemon>
}