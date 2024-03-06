package kz.flyingv.shutapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kz.flyingv.uikit.theme.ShutAppTheme
import kz.flyingv.headsup.HeadsUpDisplay
import kz.flyingv.navigatorapi.Navigator
import kz.flyingv.uikit.theme.primary
import javax.inject.Inject

@AndroidEntryPoint
class ShutAppActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val primaryColor = when {
                (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) -> {
                    if (isSystemInDarkTheme()) dynamicDarkColorScheme(this).primaryContainer
                    else dynamicLightColorScheme(this).primaryContainer
                }
                else -> primary
            }

            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor( color = primaryColor )

            ShutAppTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = navigator.launchRoute()) {
                        navigator.provideNavigationGraph(this, navController)
                    }

                    HeadsUpDisplay()

                }
            }
        }

    }
}