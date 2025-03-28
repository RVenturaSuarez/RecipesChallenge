package com.nebsan.recipeschallenge.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nebsan.recipeschallenge.data.local.dao.RecipeDao
import com.nebsan.recipeschallenge.data.local.entities.RecipeEntity
import com.nebsan.recipeschallenge.utils.InstructionsConverter

@Database(entities = [RecipeEntity::class], version = 1)
@TypeConverters(InstructionsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}