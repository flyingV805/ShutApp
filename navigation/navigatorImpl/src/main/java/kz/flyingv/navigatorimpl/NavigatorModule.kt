package kz.flyingv.navigatorimpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.flyingv.featureapi.FeatureApi
import kz.flyingv.navigatorapi.Navigator
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