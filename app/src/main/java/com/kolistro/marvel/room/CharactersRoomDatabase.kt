package com.kolistro.marvel.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kolistro.marvel.network.characters.Characters

@Database(entities = arrayOf(CharactersSave::class), version = 1, exportSchema = false)
public abstract class CharactersRoomDatabase:RoomDatabase() {
    abstract fun charactersDao(): CharactersDao

    companion object {
        @Volatile
        private var INSTANCE: CharactersRoomDatabase? = null

        fun getDatabase(context: Context): CharactersRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharactersRoomDatabase::class.java,
                    "characters_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}