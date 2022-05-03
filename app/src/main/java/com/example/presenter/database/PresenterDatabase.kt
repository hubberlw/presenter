package com.example.presenter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.presenter.database.entity.Category
import com.example.presenter.database.entity.Role
import com.example.presenter.database.entity.PairRolePerson
import com.example.presenter.database.entity.Person

@Database(entities = [Role::class, Person::class, Category::class, PairRolePerson::class],
    version = 1, exportSchema = false)
abstract class PresenterDatabase: RoomDatabase() {
    abstract fun presenterDao(): PresenterDao

    companion object {
        @Volatile
        private var INSTANCE: PresenterDatabase? = null

        fun getInstance(context: Context): PresenterDatabase {
            synchronized (this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PresenterDatabase::class.java,
                        "presenter_database"
                    )
                        .fallbackToDestructiveMigration()
                        .createFromAsset("database/presenter.db")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
