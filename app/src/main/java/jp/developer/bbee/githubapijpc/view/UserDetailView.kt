package jp.developer.bbee.githubapijpc.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import jp.developer.bbee.githubapijpc.model.repository.User

/**
 * Result of searching
 */
@Composable
fun UserDetailView (user: User) {
    Column {
        Text(text = user.userId.value.toString())
        Text(text = user.name)
        Text(text = user.avatarImage.url.value)
        Text(text = user.blogUrl.value)
    }
}