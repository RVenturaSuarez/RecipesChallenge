package com.nebsan.recipeschallenge.data.remote

import com.nebsan.recipeschallenge.data.remote.dto.RecipesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesApi {

    @GET("recipes")
    suspend fun getRecipes(@Query("limit") limit: Int = 30) : RecipesDto
}