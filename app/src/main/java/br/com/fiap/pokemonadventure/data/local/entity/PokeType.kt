package br.com.fiap.pokemonadventure.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Pokemon::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("pokemonId"),
    onDelete = ForeignKey.CASCADE)]
)
data class PokeType(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val slot: Int = 0,
    val type: Type,
    val pokemonId: Long
)