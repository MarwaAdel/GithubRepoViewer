package com.example.githubrepoviewer.network.mock

import com.example.githubrepoviewer.core.model.GithubReposListModel
import com.example.githubrepoviewer.core.model.IssuesModel
import com.example.githubrepoviewer.network.remote_network.IApiCall
import retrofit2.Response

class FakeApiCall : IApiCall {
    var reposListApiResponse: Response<List<GithubReposListModel>>? = null
    var exception: Exception? = null

    override suspend fun reposListApi(): Response<List<GithubReposListModel>> {
        exception?.let { throw it }
        return reposListApiResponse ?: Response.success(emptyList())
    }

    override suspend fun reposDetailsApi(
        owner: String,
        repo: String
    ): Response<GithubReposListModel> {
        TODO("Not yet implemented")
    }

    override suspend fun repoIssuesApi(owner: String, repo: String): Response<List<IssuesModel>> {
        TODO("Not yet implemented")
    }
}