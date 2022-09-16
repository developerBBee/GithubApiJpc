package jp.developer.bbee.githubapijpc.model.remote_data_source

/**
 * get Data Source from server
 */
interface RemoteDataSource {

    /**
     * Get [GitHubUser]
     */
    suspend fun getGitHubUser(userName: String): GitHubUser
}