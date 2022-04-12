package com.example.ej_14

import androidx.annotation.NonNull
import androidx.annotation.WorkerThread
import androidx.room.*
import kotlinx.coroutines.flow.Flow

class Entidad {
    @Entity(tableName = "Peliculas")
    data class Pelicula(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        @NonNull @ColumnInfo(name = "titulo") val titulo: String = "",
        @NonNull @ColumnInfo(name = "genero") val genero: String = "",
        @NonNull @ColumnInfo(name = "año") val año: Int = 0
    )
}







