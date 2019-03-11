package br.com.fiap.pokemonadventure.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Pokemon(

    @PrimaryKey
    val id: Int,
    val name: String
    //val type: String,
    //val url: String
)
