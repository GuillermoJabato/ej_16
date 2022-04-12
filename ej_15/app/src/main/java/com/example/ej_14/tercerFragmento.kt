package com.example.ej_14

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ej_14.databinding.FragmentTercerBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class tercerFragmento : Fragment() {


    private var _binding: FragmentTercerBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTercerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val posicion: Int = arguments?.getInt("id") ?: -1
        super.onViewCreated(view, savedInstanceState)
        if (posicion > -1) {
            binding.textotitulo.setText((activity as MainActivity).datosview.peliculas[posicion].titulo)
            binding.textogenero.setText((activity as MainActivity).datosview.peliculas[posicion].genero)
            binding.textoaO.setText((activity as MainActivity).datosview.peliculas[posicion].año.toString())
        }
        binding.botonGuardar.setOnClickListener {
            if (binding.textotitulo.text.isNotEmpty() || binding.textogenero.text.isNotEmpty() || binding.textoaO.text.isNotEmpty()) {
                (activity as MainActivity).datosview.editar_datos(
                    binding.textotitulo.text.toString(),
                    binding.textogenero.text.toString(),
                    binding.textoaO.text.toString().toInt()
                )
                findNavController().navigate(R.id.action_tercerFragmento_to_SecondFragment)
            }
        }
        binding.botonBorrar.setOnClickListener {
            (activity as MainActivity).datosview.borrar_datos(binding.textotitulo.text.toString())
            findNavController().navigate(R.id.action_tercerFragmento_to_SecondFragment)
        }
        binding.botonInsertar.setOnClickListener {
            var comprobar = true
            for (pelicula in (activity as MainActivity).datosview.peliculas) {
                comprobar = pelicula.titulo == binding.textotitulo.text.toString()
            }
            if (comprobar) {
                (activity as MainActivity).datosview.insertar_datos(
                    binding.textotitulo.text.toString(),
                    binding.textogenero.text.toString(),
                    binding.textoaO.text.toString().toInt()
                )
                findNavController().navigate(R.id.action_tercerFragmento_to_SecondFragment)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}