package com.example.ej_14

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repositorio(val miDAO: PeliculaDao) {
    val listaPeliculas: Flow<List<Peliculas>> = miDAO.MostrarDatos()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(pelicula: Peliculas) {
        miDAO.Insertar(pelicula)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun BorrarPelicula(titulo: String) {
        miDAO.BorrarPelicula(titulo)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(pelicula: Peliculas) {
        miDAO.Actualizar(pelicula)
    }
}
