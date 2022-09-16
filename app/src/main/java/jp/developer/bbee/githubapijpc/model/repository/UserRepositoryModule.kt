package jp.developer.bbee.githubapijpc.model.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Module of [UserRepository]
 */
@Module
@InstallIn(ViewModelComponent::class)
class UserRepositoryModule {

    /**
     * Create instance for DI of [UserRepository]
     */
    @Provides
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository {
        return userRepositoryImpl
    }
}