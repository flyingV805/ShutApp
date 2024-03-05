package kz.flyingv.shutapp.launch

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kz.flyingv.shutapp.launch.ui.LaunchScreen
import kz.flyngv.featureapi.FeatureApi

class LaunchFeature: FeatureApi {

    override fun featureRoute(): String = "launch"

    override fun registerGraph(builder: NavGraphBuilder) {
        builder.composable( featureRoute() ){ LaunchScreen() }
    }


}