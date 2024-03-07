package kz.flyingv.home

import androidx.navigation.NavGraphBuilder
import kz.flyingv.featureapi.FeatureApi

class HomeFeature: FeatureApi {

    override fun featureRoute(): String = "home"

    override fun registerGraph(builder: NavGraphBuilder) {

    }


}