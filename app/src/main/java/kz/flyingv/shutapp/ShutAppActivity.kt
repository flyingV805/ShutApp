package kz.flyingv.shutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kz.flyingv.shutapp.ui.theme.ShutAppTheme
import kz.flyingv.headsup.HeadsUpDisplay
import kz.flyingv.navigatorapi.Navigator
import javax.inject.Inject

@AndroidEntryPoint
class ShutAppActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShutAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = navigator.launchRoute()) {
                        navigator.provideNavigationGraph(this)
                    }
                    HeadsUpDisplay()
                }
            }
        }

    }
}