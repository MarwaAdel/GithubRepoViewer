package com.example.githubrepoviewer.network.local_network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubrepoviewer.core.model.GithubReposListModel
import com.example.githubrepoviewer.core.model.IssuesModel

@Dao
interface GithubDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateReposList(repo: List<GithubReposListModel>)
    @Query("SELECT * FROM repos_list")
    suspend fun getAllRepos(): List<GithubReposListModel>
    @Query("SELECT * FROM repos_list WHERE owner_login = :owner AND name = :repo")
    suspend fun getRepoByOwnerAndName(owner: String, repo: String): GithubReposListModel?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateIssue(issue: List<IssuesModel>)

    @Query("SELECT * FROM issues")
    suspend fun getAllIssues(): List<IssuesModel>
}