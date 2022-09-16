package jp.developer.bbee.githubapijpc.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.developer.bbee.githubapijpc.model.repository.User
import jp.developer.bbee.githubapijpc.model.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Main ViewModel
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    /**
     * Sealed class for View state
     */
    sealed class UiState {

        /**
         * Init state
         */
        object Initial : UiState()

        /**
         * Loading
         */
        object Loading : UiState()

        /**
         * Success loading
         */
        data class Success(val user: User) : UiState()

        /**
         * Failure loading
         */
        object Failure : UiState()
    }

    /**
     * Mutable state as [UiState] for View
     */
    val uiState: MutableState<UiState> = mutableStateOf(UiState.Initial)

    /**
     * Mutable state for string of searching word
     */
    val searchQuery: MutableState<String> = mutableStateOf("")

    /**
     * Searching
     *
     * Request User data to Repository by searching word
     */
    fun onSearchTapped() {
        val searchQuery: String = searchQuery.value

        viewModelScope.launch {
            uiState.value = UiState.Loading
            runCatching {
                userRepository.getUser(userName = searchQuery)
            }.onSuccess {
                uiState.value = UiState.Success(user = it)
            }.onFailure {
                uiState.value = UiState.Failure
            }
        }
    }
}