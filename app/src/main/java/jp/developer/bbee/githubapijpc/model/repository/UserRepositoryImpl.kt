package jp.developer.bbee.githubapijpc.model.repository

import jp.developer.bbee.githubapijpc.model.remote_data_source.GitHubUser
import jp.developer.bbee.githubapijpc.model.remote_data_source.RemoteDataSource
import javax.inject.Inject

/**
 * Implement [UserRepository]
 */
class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : UserRepository {
    override suspend fun getUser(userName: String): User {
        return remoteDataSource.getGitHubUser(userName = userName).toUser()
    }
}

/**
 *  Convert [GitHubUser] to [User]
 */
private fun GitHubUser.toUser(): User {
    return User(
        userId = UserId(value = id),
        name = name,
        avatarImage = NetworkImage(url = Url(value = avatarUrl)),
        blogUrl = Url(value = blog),
    )
}