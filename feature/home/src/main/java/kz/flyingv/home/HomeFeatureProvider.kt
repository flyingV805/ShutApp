package kz.flyingv.home

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import kz.flyingv.featureapi.FeatureApi

@Module
@InstallIn(SingletonComponent::class)
object HomeFeatureProvider {

    @IntoSet
    @Provides
    fun provideHome(): FeatureApi {
        return HomeFeature()
    }

}