package com.example.parcialdermoncheghian

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter (val context: Context): ListAdapter<Receta, Adapter.ViewHolder>(DiffCallback) {

   inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
       private val name: TextView = view.findViewById(R.id.TextViewNombre)
       private val difficult: TextView = view.findViewById(R.id.textViewDificultad)
       private val origin: TextView = view.findViewById(R.id.textViewOrigen)
       private val ingredients: TextView = view.findViewById(R.id.textViewIngredientes)
       private val image: ImageView = view.findViewById(R.id.imageView)
       private val imageCountry: ImageView = view.findViewById(R.id.imageViewPais)

       @SuppressLint("SuspiciousIndentation")
       fun bind (receta: Receta){
        name.text = receta.name
        difficult.text = "Dificultad: " + receta.dificultad.toString()
        origin.text = "Origen: " + receta.origen
        ingredients.text = "Ingredientes: " + receta.ingredientes.toString()
        val imagen = when (receta.country){
            Pais.ARMENIA -> R.drawable.armenia
            Pais.ARABIA -> R.drawable.arabia
            Pais.CHIPRE -> R.drawable.chipre
            Pais.SIRIA -> R.drawable.siria
            else -> R.drawable.libano
        }
           imageCountry.setImageResource(imagen)
           Glide.with(context).load(receta.image).into(image)
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val receta = getItem(position)
        holder.bind(receta)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Receta>(){
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }
    }
}