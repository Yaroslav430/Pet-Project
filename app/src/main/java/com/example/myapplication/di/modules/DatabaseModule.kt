package com.example.myapplication.di.modules

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.MainRepository
import com.example.myapplication.data.dao.FilmDao
import com.example.myapplication.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}