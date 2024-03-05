package kz.flyngv.navigatorimpl

import androidx.navigation.NavGraphBuilder
import kz.flyngv.featureapi.FeatureApi
import kz.flyngv.navigatorapi.Navigator

class NavigatorImpl(
    private val features: Set<FeatureApi>
): Navigator {

    override fun launchRoute(): String = "launch"

    override fun provideNavigationGraph(builder: NavGraphBuilder) {
        features.forEach { feature -> feature.registerGraph(builder) }
    }

    override fun toRooms() {

    }

}