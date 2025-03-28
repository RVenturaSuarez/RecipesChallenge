package com.nebsan.recipeschallenge.utils

import androidx.room.TypeConverter

class InstructionsConverter {

    @TypeConverter
    fun instructionsListToString(instructions: List<String>) : String {
        return instructions.joinToString(separator = "|")
    }

    @TypeConverter
    fun stringInstructionsToList(instructions: String) : List<String> {
        return instructions.split("|")
    }
}