package kz.flyngv.navigatorimpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.flyngv.featureapi.FeatureApi
import kz.flyngv.navigatorapi.Navigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigatorModule {

    @Singleton
    @Provides
    fun provideNavigator(features: Set<@JvmSuppressWildcards FeatureApi>): Navigator {
        return NavigatorImpl(features)
    }

}