package com.example.githubrepoviewer.network.local_network

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.githubrepoviewer.core.model.GithubReposListModel
import com.example.githubrepoviewer.core.model.IssuesModel

@Database(entities = [GithubReposListModel::class, IssuesModel::class], version = 2)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun githubDao(): GithubDao
}