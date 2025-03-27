package com.nebsan.recipeschallenge.di

import com.nebsan.recipeschallenge.data.remote.RecipesApi
import com.nebsan.recipeschallenge.data.repository.RecipesRepositoryImpl
import com.nebsan.recipeschallenge.domain.repository.RecipesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipesApi() : RecipesApi {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipesRepository(recipesApi: RecipesApi) : RecipesRepository {
        return RecipesRepositoryImpl(recipesApi)
    }
}