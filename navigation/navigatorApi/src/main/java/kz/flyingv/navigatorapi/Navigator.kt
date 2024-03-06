package kz.flyingv.navigatorapi

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface Navigator {

    fun launchRoute(): String
    fun provideNavigationGraph(builder: NavGraphBuilder, controller: NavController)

    fun toLogin()
    fun toHome()

    fun toRooms()

}