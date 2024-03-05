package kz.flyingv.shutapp.launch

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import kz.flyngv.featureapi.FeatureApi


@Module
@InstallIn(SingletonComponent::class)
object LaunchFeatureProvider {

    @IntoSet
    @Provides
    fun provideLaunch(): FeatureApi {
        return LaunchFeature()
    }

}