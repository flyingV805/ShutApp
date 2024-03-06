package kz.flyingv.shutapp.common.session

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.matrix.android.sdk.api.Matrix
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SessionHolderProvider {

    @Singleton
    @Provides
    fun provideSessionHolder(matrix: Matrix): SessionHolder {
        return SessionHolder(matrix)
    }

}