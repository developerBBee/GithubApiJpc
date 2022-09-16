package jp.developer.bbee.githubapijpc.model.remote_data_source

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * [ApiClient] builder class
 */
class ApiClientProvider @Inject constructor() {
    companion object {
        private const val API_END_POINT = "https://api.github.com/"
    }

    /**
     * Return [ApiClient]
     */
    @ExperimentalSerializationApi
    fun provide(): ApiClient {
        return Retrofit.Builder()
            .baseUrl(API_END_POINT)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory(
                    "application/json".toMediaType()
                ),
            )
            .build()
            .create(ApiClient::class.java)
    }
}