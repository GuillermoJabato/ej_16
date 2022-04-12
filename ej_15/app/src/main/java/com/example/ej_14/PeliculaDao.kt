package com.example.ej_14

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PeliculaDao {
    @Query("Select titulo, genero, año FROM Peliculas ORDER BY id ASC")
    fun MostrarDatos(): Flow<List<Peliculas>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun Insertar(pelicula: Peliculas)

    @Delete
    fun BorrarPelicula(titulo: String)

    @Update
    suspend fun Actualizar(pelicula: Peliculas)

}