package jp.developer.bbee.githubapijpc.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

/**
 * Input form and searching button
 */
@Composable
fun SearchView(
    searchQuery: MutableState<String>,
    onSearchButtonTapped: () -> Unit
) {
    Row(Modifier.fillMaxWidth()) {
        TextField(
            label = {Text("Input GitHub account...")},
            value = searchQuery.value,
            onValueChange = {text -> searchQuery.value = text},
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {onSearchButtonTapped()}
        ) {
            Text(text = "Search")
        }
    }
}
