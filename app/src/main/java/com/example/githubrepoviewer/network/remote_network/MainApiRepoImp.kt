package com.example.githubrepoviewer.network.remote_network

import com.example.githubrepoviewer.core.model.GithubReposListModel
import com.example.githubrepoviewer.core.model.IssuesModel
import retrofit2.Response

class MainApiRepoImp(
    private val apiCall: ApiCall
) : IApiCall {
    override suspend fun reposListApi(): Response<List<GithubReposListModel>> {
        return apiCall.reposListApi()
    }

    override suspend fun reposDetailsApi(
        owner: String,
        repo: String
    ): Response<GithubReposListModel> {
        return apiCall.reposDetailsApi(owner, repo)
    }

    override suspend fun repoIssuesApi(
        owner: String,
        repo: String
    ): Response<List<IssuesModel>> {
        return apiCall.repoIssuesApi(owner, repo)
    }
}