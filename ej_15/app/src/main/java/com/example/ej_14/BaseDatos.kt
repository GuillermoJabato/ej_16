package com.example.ej_14

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Peliculas::class), version = 1, exportSchema = false)
abstract class BaseDatos : RoomDatabase() {
    abstract fun miDAO(): PeliculaDao

    companion object {
        @Volatile
        private var INSTANCE: BaseDatos? = null

        fun getDatabase(context: Context): BaseDatos {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "peliculas_database"
                ).build()
                INSTANCE = instance
                //return instance
                instance
            }
        }

    }
}