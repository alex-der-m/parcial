package com.example.parcialdermoncheghian

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        recyclerView.adapter = adapter

        val listaReceta = getRecetas()

        adapter.submitList(listaReceta)

    }

    private fun getRecetas(): MutableList<Receta> {
        return mutableListOf(
            Receta(id = 1, name = "Manti", DificultadReceta.MEDIO, origen = "Armenio", listOf(Ingredientes.HARINA, Ingredientes.CARNE), image = "https://www.comidaarmenia.com/wp-content/uploads/2020/01/manti-armenio-receta-1280x720.jpg", Pais.ARMENIA),
            Receta(id = 2, name = "Fatay", DificultadReceta.FACIL, origen = "Arabe", listOf(Ingredientes.HARINA, Ingredientes.CARNE), image = "https://pycarmenia.com/wp-content/uploads/2020/01/220.jpg", Pais.ARABIA),
            Receta(id = 3, name = "Kibbe", DificultadReceta.DIFICIL, origen = "Líbano", listOf(Ingredientes.TRIGO, Ingredientes.CARNE), image = "https://comidasegipcias.com/wp-content/uploads/2019/10/receta-kibbe.jpg", Pais.LIBANO),
            Receta(id = 4, name = "Tabbouleh", DificultadReceta.FACIL, origen = "Sirio", listOf(Ingredientes.PEREJIL, Ingredientes.TOMATE), image = "https://www.comidaarmenia.com/wp-content/uploads/2020/02/tabule-ensalada-aremenia.jpg", Pais.SIRIA),
            Receta(id = 5, name = "Baklava", DificultadReceta.MEDIO, origen = "Chipre", listOf(Ingredientes.HARINA, Ingredientes.ALMIBAR), image = "https://pycarmenia.com/wp-content/uploads/2020/01/128.jpg", Pais.CHIPRE),

            )}
    }