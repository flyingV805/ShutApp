package kz.flyingv.shutapp.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kz.flyingv.featureapi.FeatureApi
import kz.flyingv.shutapp.login.ui.LoginScreen

class LoginFeature: FeatureApi {

    override fun featureRoute(): String = "login"

    override fun registerGraph(builder: NavGraphBuilder) {
        builder.composable( featureRoute() ){ LoginScreen() }
    }

}