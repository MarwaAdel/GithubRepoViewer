package com.example.githubrepoviewer.network.remote_network

import com.example.githubrepoviewer.core.model.GithubReposListModel
import com.example.githubrepoviewer.core.model.IssuesModel
import retrofit2.Response

interface IApiCall {
   suspend fun reposListApi() : Response<List<GithubReposListModel>>
    suspend fun reposDetailsApi(owner: String, repo: String) : Response<GithubReposListModel>
    suspend fun repoIssuesApi(owner: String, repo: String) : Response<List<IssuesModel>>
}