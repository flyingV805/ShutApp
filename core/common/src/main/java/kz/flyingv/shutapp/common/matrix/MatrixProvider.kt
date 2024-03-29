package kz.flyingv.shutapp.common.matrix

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.matrix.android.sdk.api.Matrix
import org.matrix.android.sdk.api.MatrixConfiguration
import org.matrix.android.sdk.api.auth.AuthenticationService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MatrixProvider {

    @Singleton
    @Provides
    fun provideMatrix(@ApplicationContext context: Context): Matrix {
        val roomDisplayNameProvider = RoomDisplayNameProvider(context)
        return Matrix(
            context = context,
            matrixConfiguration = MatrixConfiguration(
                roomDisplayNameFallbackProvider = roomDisplayNameProvider
            )
        )
    }

    @Singleton
    @Provides
    fun provideHomeServerUtil(): HomeServerUtil {
        return HomeServerUtil()
    }

    @Singleton
    @Provides
    fun provideAuthService(matrix: Matrix): AuthenticationService {
        return matrix.authenticationService()
    }

}