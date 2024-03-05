package kz.flyngv.navigatorapi

import androidx.navigation.NavGraphBuilder

interface Navigator {

    fun launchRoute(): String
    fun provideNavigationGraph(builder: NavGraphBuilder)

    fun toRooms()

}