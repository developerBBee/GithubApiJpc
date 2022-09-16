package jp.developer.bbee.githubapijpc.model.repository

/**
 * Interface of [User] repository
 */
interface UserRepository {

    /**
     * Return [User] of [UserName]
     */
    suspend fun getUser(userName: String): User
}