package com.example.ej_14

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class DatosView(private val miRepositorio: Repositorio) : ViewModel() {
    val todas_peliculas: LiveData<List<Peliculas>> = miRepositorio.listaPeliculas.asLiveData()
    lateinit var peliculas: LiveData<Peliculas>


    fun meterdatos() = viewModelScope.launch {
        miRepositorio.Insertar(Peliculas("Pelicula1", "Terror", 1999))
        miRepositorio.Insertar(Peliculas("Pelicula2", "Accion", 1645))
        miRepositorio.Insertar(Peliculas("Pelicula3", "Aventura", 2213))
        miRepositorio.Insertar(Peliculas("Pelicula4", "Suspense", 1131))
        miRepositorio.Insertar(Peliculas("Pelicula5", "Comedia", 1121))
        miRepositorio.Insertar(Peliculas("Pelicula6", "Comedia", 1211))
        miRepositorio.Insertar(Peliculas("Pelicula7", "Comedia", 1199))
    }

    fun editar_datos( titulo: String, genero: String, ayo: Int) = viewModelScope.launch {
        miRepositorio.Actualizar(Peliculas(titulo,genero,ayo))

    }

    fun borrar_datos(titulo: String) = viewModelScope.launch {
        miRepositorio.BorrarPelicula(titulo)
    }

    fun insertar_datos(titulo: String, genero: String, ayo: Int) = viewModelScope.launch {
        miRepositorio.Insertar(Peliculas(titulo, genero, ayo))

    }

    class WordViewModelFactory(private val repository: Repositorio) : ViewModelProvider.Factory{
        override fun <T:ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(DatosView::class.java)){
                @Suppress("UNCHECKED_CAST")
                return DatosView(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
