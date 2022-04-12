package com.example.ej_14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class Adaptador(var datos: MutableList<Peliculas>,val fragmento: Fragment) :
    RecyclerView.Adapter<Adaptador.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvTitulo: TextView = v.findViewById(R.id.tvTitulo)
        var tvGenero: TextView = v.findViewById(R.id.tvGenero)
        var tvAño: TextView = v.findViewById(R.id.tvAño)
        var boton:Button=v.findViewById(R.id.boton_editar)
        var posicion:Int=-2

        init {
            boton.setOnClickListener {
                val bundle = bundleOf("id" to this.posicion)
                fragmento.findNavController().navigate(R.id.action_SecondFragment_to_tercerFragmento,bundle)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.contenedor, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitulo.text = datos[position].titulo
        holder.tvGenero.text = datos[position].genero
        holder.tvAño.text = datos[position].año.toString()
        holder.posicion=position

    }

    override fun getItemCount(): Int {
        return datos.size
    }
}