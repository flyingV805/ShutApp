package kz.flyingv.shutapp.launch.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Suppress("unused_parameter")
@Composable
fun LaunchScreen(
    viewModel: LaunchViewModel = hiltViewModel()
) {

    Scaffold {

        Box(modifier = Modifier.padding(it))
        CircularProgressIndicator()

    }
    
}