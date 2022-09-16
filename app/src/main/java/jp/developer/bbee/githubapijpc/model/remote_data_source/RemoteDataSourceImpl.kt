package jp.developer.bbee.githubapijpc.model.remote_data_source

import javax.inject.Inject

/**
 * [RemoteDataSource] implements class
 */
class RemoteDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient,
) : RemoteDataSource {
    override suspend fun getGitHubUser(userName: String): GitHubUser {
        val response = apiClient.getGitHubUser(userName = userName)
        if (response.isSuccessful) {
            val gitHubUser: GitHubUser = requireNotNull(response.body())
            return gitHubUser
        }
        throw HttpException()
    }
}

/**
 * Response is not successful Exception
 */
class HttpException : Throwable()