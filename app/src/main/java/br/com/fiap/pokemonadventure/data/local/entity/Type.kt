package br.com.fiap.pokemonadventure.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = PokeType::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("pokeTypeId"),
    onDelete = ForeignKey.CASCADE)])
data class Type(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val url: String,
    val pokeTypeId: Long
)