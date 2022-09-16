package jp.developer.bbee.githubapijpc.model.repository

/**
 * User data class
 */
data class User(
    val userId: UserId,
    val name: String,
    val avatarImage: NetworkImage,
    val blogUrl: Url,
)
