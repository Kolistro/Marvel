package com.kolistro.marvel.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CharactersDao {
    @Insert
    fun insertAll(vararg charactersSave: CharactersSave)

    @Update
    fun updateUsers(vararg charactersSave: CharactersSave)

    @Query("SELECT * FROM `character-table`")
    fun loadAllUsers(): Array<CharactersSave>
}