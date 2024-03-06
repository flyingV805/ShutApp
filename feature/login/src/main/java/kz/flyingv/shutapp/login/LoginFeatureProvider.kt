package kz.flyingv.shutapp.login

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import kz.flyingv.featureapi.FeatureApi

@Module
@InstallIn(SingletonComponent::class)
object LoginFeatureProvider {

    @IntoSet
    @Provides
    fun provideLaunch(): FeatureApi {
        return LoginFeature()
    }

}