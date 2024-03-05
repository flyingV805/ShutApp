package kz.flyngv.featureapi

import androidx.navigation.NavGraphBuilder

interface FeatureApi {

    fun featureRoute(): String

    fun registerGraph(builder: NavGraphBuilder)

}