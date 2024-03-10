package kz.flyingv.shutapp.login.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kz.flyingv.shutapp.common.matrix.HomeServerUtil
import kz.flyingv.shutapp.login.domain.usecase.GetServerUseCase

@Module
@InstallIn(ViewModelComponent::class)
object LoginDI {

    fun provideServerUseCase(homeServerUtil: HomeServerUtil): GetServerUseCase {
        return GetServerUseCase(homeServerUtil)
    }

}