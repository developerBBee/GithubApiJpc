package jp.developer.bbee.githubapijpc.model.remote_data_source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Module of [RemoteDataSource]
 */
@Module
@InstallIn(ViewModelComponent::class)
class RemoteDataSourceModule {

    /**
     * Create instance for DI of [RemoteDataSource]
     */
    @Provides
    fun provideRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ) : RemoteDataSource {
        return remoteDataSourceImpl
    }
}