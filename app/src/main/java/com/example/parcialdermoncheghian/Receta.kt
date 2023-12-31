package com.example.parcialdermoncheghian

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receta (
    val id: Int,
    val name: String,
    val dificultad:  DificultadReceta,
    val origen: String,
    val ingredientes: List<Ingredientes>,
    val image: String?,
    val country: Pais
    ): Parcelable

enum class DificultadReceta {
    FACIL,
    MEDIO,
    DIFICIL
}
enum class  Ingredientes {
    HARINA,
    TRIGO,
    ALMIBAR,
    CARNE,
    PEREJIL,
    TOMATE
}
enum class Pais{
    ARMENIA,
    ARABIA,
    SIRIA,
    CHIPRE,
    LIBANO
}