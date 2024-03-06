package kz.flyingv.shutapp.launch.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kz.flyingv.shutapp.common.session.SessionHolder
import kz.flyingv.shutapp.launch.domain.usecase.IsSessionAvailableUseCase

@Module
@InstallIn(ViewModelComponent::class)
object LaunchDI {

    fun provideSessionUseCase(sessionHolder: SessionHolder): IsSessionAvailableUseCase {
        return  IsSessionAvailableUseCase(sessionHolder)
    }

}