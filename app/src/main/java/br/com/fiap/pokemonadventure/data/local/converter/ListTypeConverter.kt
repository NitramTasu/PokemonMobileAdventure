package br.com.fiap.pokemonadventure.data.local.converter

import android.arch.persistence.room.TypeConverter
import br.com.fiap.pokemonadventure.data.local.entity.PokeType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


object ListTypeConverter {

    @TypeConverter @JvmStatic
    fun fromString(value: String): ArrayList<PokeType> {
        val listType = object : TypeToken<ArrayList<PokeType>>() {

        }.type

        return Gson().fromJson<ArrayList<PokeType>>(value, listType)
    }

    @TypeConverter @JvmStatic
    fun fromArrayList(list: ArrayList<PokeType>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

}