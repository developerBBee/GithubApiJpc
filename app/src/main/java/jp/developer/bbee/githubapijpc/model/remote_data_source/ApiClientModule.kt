package jp.developer.bbee.githubapijpc.model.remote_data_source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

/**
 * [ApiClient]'s Module
 */
@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {

    /**
     * Create instance for DI of [ApiClient]
     */
    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideApiClient(apiClientProvider: ApiClientProvider): ApiClient {
        return apiClientProvider.provide()
    }
}