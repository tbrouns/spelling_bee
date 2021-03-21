package io.github.plastix.buzz.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        PuzzleEntity::class
    ],
    version = 1
)
abstract class PuzzleDatabase : RoomDatabase() {
    abstract fun puzzleDao(): PuzzleDao
}

fun instantiateDatabase(context: Context): PuzzleDatabase {
    return Room.databaseBuilder(context, PuzzleDatabase::class.java, "buzz-database")
        .fallbackToDestructiveMigration() // TODO good enough for now
        .build()
}