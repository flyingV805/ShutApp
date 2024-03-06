package kz.flyingv.navigatorimpl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import kz.flyingv.featureapi.FeatureApi
import kz.flyingv.navigatorapi.Navigator

class NavigatorImpl(
    private val features: Set<FeatureApi>
): Navigator {


    private var _navigationController: NavController? = null
    private val controller get() = _navigationController!!

    override fun launchRoute(): String = "launch"

    override fun provideNavigationGraph(builder: NavGraphBuilder, navigationController: NavController) {
        _navigationController = navigationController
        features.forEach { feature -> feature.registerGraph(builder) }
    }

    override fun toLogin() {
        controller.navigate("login") {
            popUpTo("launch") { inclusive = true }
        }
    }

    override fun toHome() {

    }

    override fun toRooms() {

    }

}