package com.kolistro.marvel.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kolistro.marvel.network.characters.Characters

@Entity(tableName = "character-table")
class CharactersSave (@PrimaryKey @ColumnInfo(name = "characters") val characters: Characters)
